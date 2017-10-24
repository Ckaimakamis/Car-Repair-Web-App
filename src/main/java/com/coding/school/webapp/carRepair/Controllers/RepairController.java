package com.coding.school.webapp.carRepair.Controllers;

import com.coding.school.webapp.carRepair.Converters.RepairConverter;
import com.coding.school.webapp.carRepair.Converters.VehicleConverter;
import com.coding.school.webapp.carRepair.Domain.Owner;
import com.coding.school.webapp.carRepair.Domain.Repair;
import com.coding.school.webapp.carRepair.Domain.Vehicle;
import com.coding.school.webapp.carRepair.Model.RepairRegisterForm;
import com.coding.school.webapp.carRepair.Model.SearchRepairForm;
import com.coding.school.webapp.carRepair.Model.VehicleRegisterForm;
import com.coding.school.webapp.carRepair.Services.OwnerService;
import com.coding.school.webapp.carRepair.Services.RepairService;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RepairController {

    private static final String SEARCH_FORM = "searchRepairForm";

    private static final String REPAIRS = "repairs";

    private static final String REPAIR_REGISTER_FORM = "createRepair";

    private static final String REPAIR_EDIT_FORM = "repairEditForm";

    @Autowired
    RepairService repairService;

    @Autowired
    OwnerService ownerService;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    private MessageSource messageSource;


    @RequestMapping(value = "/admin/repairs", method = RequestMethod.GET)
    public String exposeRepairSite(Model model, HttpSession session) {
        model.addAttribute(REPAIRS, session.getAttribute(REPAIRS));
        return "repairIndex";
    }

    @RequestMapping(value = "/admin/registerRepair", method = RequestMethod.POST)
    public String registerRepair(@Valid @ModelAttribute(REPAIR_REGISTER_FORM ) RepairRegisterForm registrationForm, BindingResult bindingResult,
                          HttpSession session, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            String message = messageSource.getMessage(bindingResult.getAllErrors().get(0), null);
            redirectAttributes.addFlashAttribute("errorMessage", message);
        }else{
            try{
                Repair repair = RepairConverter.buildRepairObject(registrationForm);
                Vehicle vehicle = vehicleService.findByPlateNumber(registrationForm.getPlateNumber());
                if(vehicle == null){
                    redirectAttributes.addFlashAttribute("errorMessage", "There is no vehicle with plate number "
                            + registrationForm.getPlateNumber());
                    return "redirect:/admin/repairs";
                }
                repairService.registerRepair(repair, vehicle);
                redirectAttributes.addFlashAttribute("message", "repair "+ repair.getOperations()
                        + " " + repair.getOperations() + " successfully inserted! :)");
            }catch(Exception e){
                redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            }
        }

        return "redirect:/admin/repairs";
    }

    @RequestMapping(value = "/admin/searchRepair", method = RequestMethod.GET)
    public String getSearchView(Model model) {

        return "repairEditForm";
    }

    @RequestMapping(value = "/admin/searchRepair", method = RequestMethod.POST)
    public String doSearch(@ModelAttribute(SEARCH_FORM) SearchRepairForm searchRepairForm,
                           RedirectAttributes redirectAttributes) throws ParseException {

        List<Repair> repairs = new ArrayList<>();
        Owner owner = ownerService.findByVat(searchRepairForm.getVat());
        Vehicle vehicle = vehicleService.findByPlateNumber(searchRepairForm.getPlateNumber());

        switch (searchRepairForm.getSearchType()) {
            case "dateSel":
                repairs = repairService.findOneDayRepairs(searchRepairForm.getDate());
                break;
            case "periodSel":
                repairs = repairService.findManyDaysRepairs(searchRepairForm.getDate(), searchRepairForm.getDateTo());
                break;
            case "vatSel":
                repairs = new ArrayList<>(owner.getVehicle().getRepairs());
                break;
            case "plateNumberSel":
                repairs = new ArrayList<>(vehicle.getRepairs());
                break;
        }

        if(repairs.size() == 0){
            redirectAttributes.addFlashAttribute("errorMessage", "Repairs not found!");
        }else{
            redirectAttributes.addFlashAttribute(REPAIRS, repairs);
        }
        return "redirect:/admin/searchRepair";
    }

    @RequestMapping(value = "/admin/editRepair", method = RequestMethod.POST)
    String editRepair(@ModelAttribute(REPAIR_EDIT_FORM) RepairRegisterForm updateForm, RedirectAttributes redirectAttributes){

        try{
            repairService.updateRepair(RepairConverter.buildRepairObject(updateForm));
            redirectAttributes.addFlashAttribute("message", "Repair Updated :)");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("errorMessage", "Ooops something went wrong\nRepair was not updated!");
        }

        return "redirect:/admin/repairs";
    }
}
