package com.coding.school.webapp.carRepair.Controllers;

import com.coding.school.webapp.carRepair.Domain.Owner;
import com.coding.school.webapp.carRepair.Domain.Repair;
import com.coding.school.webapp.carRepair.Domain.Vehicle;
import com.coding.school.webapp.carRepair.Model.SearchForm;
import com.coding.school.webapp.carRepair.Services.OwnerService;
import com.coding.school.webapp.carRepair.Services.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RepairController {

    private static final String SEARCH_FORM = "searchForm";

    public static final String OWNER = "owner";

    public static final String REPAIRS = "repairs";

    @Autowired
    OwnerService ownerService;

    @RequestMapping(value = "/admin/repairs", method = RequestMethod.GET)
    public String exposeRepairSite(Model model) {

        return "serviceIndex";
    }

    @RequestMapping(value = "/searchRepair", method = RequestMethod.POST)
    public String doSearch(@ModelAttribute(SEARCH_FORM) SearchForm searchForm,
                           HttpSession session,
                           RedirectAttributes redirectAttributes) {

        Owner owner = ownerService.findByVat(searchForm.getVat());
        List<Repair> repairs = null;


        repairs = new ArrayList<>(owner.getVehicle().getRepairs());

        List<Repair> repairsByDate = null;
        for(Repair repair:repairs) {
            if(repair.getDateTime().equals(searchForm.getDate())){
                repairsByDate.add(repair);
            }
        }

        if (repairs == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Repair not found");
        }

        redirectAttributes.addFlashAttribute(OWNER, owner);
        redirectAttributes.addFlashAttribute(REPAIRS, repairsByDate);

        return "redirect:/admin/repair";
    }
}
