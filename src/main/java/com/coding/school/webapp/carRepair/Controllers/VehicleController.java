package com.coding.school.webapp.carRepair.Controllers;

import com.coding.school.webapp.carRepair.Converters.VehicleConverter;
import com.coding.school.webapp.carRepair.Domain.Owner;
import com.coding.school.webapp.carRepair.Domain.Vehicle;
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

    private static final String VEHICLE_EDIT_FORM = "ownerEditForm";

    @RequestMapping(value = "/admin/vehicles", method = RequestMethod.GET)
    String serveVehiclePage(Model model){

        return "vehicleIndex";
    }

    @RequestMapping(value = "/admin/vehicleRegister", method = RequestMethod.POST)
    String RegisterVehicle(@Valid @ModelAttribute(VEHICLE_REGISTER_FORM) VehicleRegisterForm registerForm, BindingResult bindingResult,
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
}
