package com.coding.school.webapp.carRepair.Controllers;

import com.coding.school.webapp.carRepair.Converters.VehicleConverter;
import com.coding.school.webapp.carRepair.Domain.Owner;
import com.coding.school.webapp.carRepair.Domain.Vehicle;
import com.coding.school.webapp.carRepair.Model.SearchForm;
import com.coding.school.webapp.carRepair.Model.VehicleRegisterForm;
import com.coding.school.webapp.carRepair.Services.OwnerService;
import com.coding.school.webapp.carRepair.Services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    OwnerService ownerService;

    @Autowired
    private MessageSource messageSource;

    private static final String VEHICLE_SEARCH_FORM = "vehicleSearchForm";

    private static final String VEHICLE_REGISTER_FORM = "vehicleRegisterForm";

    private static final String VEHICLE_EDIT_FORM = "vehicleEditForm";

    private static final String VEHICLE = "vehicle";

    private static final String OWNER = "owner";

    @RequestMapping(value = "/admin/vehicles", method = RequestMethod.GET)
    String serveVehiclePage(Model model){

        return "vehicleIndex";
    }

    @RequestMapping(value = "/admin/vehicleRegister", method = RequestMethod.POST)
    public String registerVehicle(@Valid @ModelAttribute(VEHICLE_REGISTER_FORM) VehicleRegisterForm registerForm, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            String message = messageSource.getMessage(bindingResult.getAllErrors().get(0), null);
            redirectAttributes.addFlashAttribute("errorMessage", message);
        }else{
            Owner owner = null;
            try{
                owner = ownerService.findByVat(registerForm.getVat());
                if(owner == null){
                    redirectAttributes.addFlashAttribute("errorMessage", "Owner's VAT: " + registerForm.getVat() + " does not exist!");
                    return "redirect:/admin/vehicles";
                }
                Vehicle vehicle = VehicleConverter.buildVehicleObject(registerForm);
                vehicle.setOwner(owner);
                vehicleService.registerVehicle(vehicle);
                redirectAttributes.addFlashAttribute("message", "Vehicle " + vehicle.getModel()
                        + ", " + vehicle.getPlateNumber() + ", " + vehicle.getColor()
                        +  " of " + vehicle.getYear()+ " \nsuccessfully inserted for user "
                        + owner.getFirstName() + " " + owner.getLastName() +"\n:)");
            }catch (Exception e){
                if(e.getMessage().equals("Vehicle already exists!")){
                    redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
                }else {
                    redirectAttributes.addFlashAttribute("errorMessage", "User " + owner.getFirstName() + " "
                            + owner.getLastName() +" already has a vehicle!");
                }

            }
        }

        return "redirect:/admin/vehicles";
    }

    @RequestMapping(value = "/admin/searchVehicle", method = RequestMethod.GET)
    public String getSearchView(Model model) {

        return "vehicleEditForm";
    }

    @RequestMapping(value = "/admin/searchVehicle", method = RequestMethod.POST)
    public String searchVehicle(@Valid @ModelAttribute(VEHICLE_SEARCH_FORM) SearchForm searchForm, RedirectAttributes redirectAttributes){

        Vehicle vehicle = null;
        Owner owner = null;

        if(!searchForm.getPlateNumber().equals("")){
            vehicle = vehicleService.findByPlateNumberOrVat(searchForm.getPlateNumber(), searchForm.getVat());
            owner = vehicle.getOwner();
        }else if(!searchForm.getVat().equals("")){
            owner = ownerService.findByVat(searchForm.getVat());
            vehicle = vehicleService.findByOwner(owner);
        }

        if (vehicle == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Vehicle not found");
        }else {
            redirectAttributes.addFlashAttribute(OWNER, owner);
        }

        redirectAttributes.addFlashAttribute(VEHICLE, vehicle);

        return "redirect:/admin/searchVehicle";
    }

    @RequestMapping(value = "/admin/editVehicle", method = RequestMethod.POST)
    String editVehicle(@Valid @ModelAttribute(VEHICLE_EDIT_FORM) VehicleRegisterForm updateForm, RedirectAttributes redirectAttributes){

        try{
            vehicleService.updateVehicle(VehicleConverter.buildVehicleObject(updateForm));
            redirectAttributes.addFlashAttribute("message", "Vehicle Updated :)");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("errorMessage", "Ooops something went wrong\nVehicle was not updated!");
        }

        return "redirect:/admin/vehicles";
    }

    @RequestMapping(value = "/admin/deleteVehicle", method = RequestMethod.POST)
    String deleteUser(@Valid @ModelAttribute(VEHICLE_EDIT_FORM) VehicleRegisterForm deleteForm, BindingResult bindingResult,
                      HttpSession session, RedirectAttributes redirectAttributes){

        try{
            Vehicle vehicle = vehicleService.findByPlateNumber(deleteForm.getPlateNumber());
            vehicleService.deleteVehicle(vehicle);
            redirectAttributes.addFlashAttribute("message", "Vehicle Deleted :(");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("errorMessage", "Ooops something went wrong\nVehicle was not deleted!");
        }

        return "redirect:/admin/vehicles";
    }
}
