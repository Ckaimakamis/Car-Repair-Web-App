package com.coding.school.webapp.carRepair.Controllers;

import com.coding.school.webapp.carRepair.Domain.Owner;
import com.coding.school.webapp.carRepair.Domain.Repair;
import com.coding.school.webapp.carRepair.Domain.Vehicle;
import com.coding.school.webapp.carRepair.Model.SearchRepairForm;
import com.coding.school.webapp.carRepair.Services.OwnerService;
import com.coding.school.webapp.carRepair.Services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RepairController {

    private static final String SEARCH_FORM = "searchRepairForm";

    public static final String REPAIRS = "repairs";

    @Autowired
    OwnerService ownerService;

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(value = "/admin/repairs", method = RequestMethod.GET)
    public String exposeRepairSite(Model model) {

        return "serviceIndex";
    }

    @RequestMapping(value = "/searchRepair", method = RequestMethod.POST)
    public String doSearch(@ModelAttribute(SEARCH_FORM) SearchRepairForm searchRepairForm,
                           HttpSession session,
                           RedirectAttributes redirectAttributes) throws ParseException {

        Vehicle vehicle = vehicleService.findByPlateNumber(searchRepairForm.getPlateNumber());


        Owner owner = ownerService.findByVat(searchRepairForm.getVat());
        List<Repair> repairs = new ArrayList<>(owner.getVehicle().getRepairs());
        List<Repair> repairsByDate = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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

        if (repairs.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Repair not found");
        }

        redirectAttributes.addFlashAttribute(REPAIRS, repairsByDate);
        return "redirect:/admin/repairs";
    }

}
