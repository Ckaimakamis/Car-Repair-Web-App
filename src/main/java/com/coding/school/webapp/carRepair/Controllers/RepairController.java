package com.coding.school.webapp.carRepair.Controllers;

import com.coding.school.webapp.carRepair.Domain.Owner;
import com.coding.school.webapp.carRepair.Domain.Repair;
import com.coding.school.webapp.carRepair.Domain.Vehicle;
import com.coding.school.webapp.carRepair.Model.SearchForm;
import com.coding.school.webapp.carRepair.Model.SearchRepairForm;
import com.coding.school.webapp.carRepair.Services.OwnerService;
import com.coding.school.webapp.carRepair.Services.RepairService;
import com.coding.school.webapp.carRepair.Services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RepairController {

    private static final String SEARCH_FORM = "searchRepairForm";

    public static final String REPAIRS = "repairs";

    @Autowired
    OwnerService ownerService;

    @RequestMapping(value = "/admin/repair", method = RequestMethod.GET)
    public String exposeRepairSite(Model model) {

        return "serviceIndex";
    }

    @RequestMapping(value = "/admin/searchRepair", method = RequestMethod.POST)
    public String doSearch(@ModelAttribute(SEARCH_FORM) SearchRepairForm searchRepairForm,
                           HttpSession session,
                           RedirectAttributes redirectAttributes) {

        Owner owner = ownerService.findByVat(searchRepairForm.getVat());
        List<Repair> repairs = new ArrayList<>(owner.getVehicle().getRepairs());
        List<Repair> repairsByDate = new ArrayList<>();


        for(Repair repair:repairs) {
            String repairDate = new SimpleDateFormat("yyyy-MM-dd").format(repair.getDateTime());
            if(repairDate.equals(searchRepairForm.getDate())){
                repairsByDate.add(repair);
            }
        }

        if (repairs.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Repair not found");
        }

        redirectAttributes.addFlashAttribute(REPAIRS, repairsByDate);
        return "redirect:/admin/repair";
    }

}
