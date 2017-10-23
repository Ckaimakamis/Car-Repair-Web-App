package com.coding.school.webapp.carRepair.Controllers;

import com.coding.school.webapp.carRepair.Converters.OwnerConverter;
import com.coding.school.webapp.carRepair.Converters.RepairConverter;
import com.coding.school.webapp.carRepair.Domain.Owner;
import com.coding.school.webapp.carRepair.Domain.Repair;
import com.coding.school.webapp.carRepair.Domain.Vehicle;
import com.coding.school.webapp.carRepair.Model.RegisterForm;
import com.coding.school.webapp.carRepair.Model.RepairRegisterForm;
import com.coding.school.webapp.carRepair.Model.SearchForm;
import com.coding.school.webapp.carRepair.Model.SearchRepairForm;
import com.coding.school.webapp.carRepair.Repositories.RepairRepository;
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

    private static final String REPAIR_REGISTER_FORM ="createRepair";

    @Autowired
    RepairService repairService;


    @Autowired
    OwnerService ownerService;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    private MessageSource messageSource;


    @RequestMapping(value = "/admin/repairs", method = RequestMethod.GET)
    public String exposeRepairSite(Model model) {

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


    @RequestMapping(value = "/admin/searchRepair", method = RequestMethod.POST)
    public String doSearch(@ModelAttribute(SEARCH_FORM) SearchRepairForm searchRepairForm,
                           HttpSession session,
                           RedirectAttributes redirectAttributes) throws ParseException {

        Vehicle vehicle = vehicleService.findByPlateNumber(searchRepairForm.getPlateNumber());
        Owner owner = ownerService.findByVat(searchRepairForm.getVat());

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Repair> repairsByDate = new ArrayList<>();
        List<Repair> repairs;

        if (owner != null) {
            repairs = (List<Repair>) owner.getVehicle().getRepairs();
        }else if (vehicle != null){
            repairs = (List<Repair>) vehicle.getRepairs();
        }else {
            repairs = null;
        }

        for (Repair repair : repairs) {
            String stringRepairDate = dateFormat.format(repair.getDateTime());
            java.util.Date repairDate = dateFormat.parse(stringRepairDate);

            if (searchRepairForm.getPeriodSearch() != null) {
                java.util.Date fromDate = dateFormat.parse(searchRepairForm.getDate());
                java.util.Date toDate = dateFormat.parse(searchRepairForm.getDateTo());
                if ((repairDate.after(fromDate) || repairDate.equals(fromDate)) &&
                        (repairDate.before(toDate)) || repairDate.equals(toDate)) {
                    repairsByDate.add(repair);
                }

            } else {
                if (stringRepairDate.equals(searchRepairForm.getDate())) {
                    repairsByDate.add(repair);
                }
            }
        }

        if (repairs == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Repair not found");
        }

        redirectAttributes.addFlashAttribute(REPAIRS, repairsByDate);

        return "redirect:/admin/repairs";
    }

}
