package com.coding.school.webapp.carRepair.Controllers;

import com.coding.school.webapp.carRepair.Domain.Owner;
import com.coding.school.webapp.carRepair.Domain.Repair;
import com.coding.school.webapp.carRepair.Model.SearchForm;
import com.coding.school.webapp.carRepair.Services.OwnerService;
import com.coding.school.webapp.carRepair.Services.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

public class RepairSearchController {

    private static final String SEARCH_FORM = "searchForm";
    public static final String REPAIR = "repair";
    @Autowired
    RepairService repairService;
    OwnerService ownerService;

    @RequestMapping(value = "/searchRepair", method = RequestMethod.GET)
    public String getSearchView(Model model) {
        model.addAttribute(SEARCH_FORM, new SearchForm());
        return "repair";
    }

    @RequestMapping(value = "/searchRepair", method = RequestMethod.POST)
    public String doSearch(@ModelAttribute(SEARCH_FORM) SearchForm searchForm,
                           HttpSession session,
                           RedirectAttributes redirectAttributes) {

        Repair repair = repairService.findByDateTime(searchForm.getDateTime());
        Owner owner = ownerService.findByVat( searchForm.getVat());

        if (repair == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Repair not found");
        }

        redirectAttributes.addFlashAttribute(REPAIR, repair);
        return "redirect:/searchRepair";
    }
}
