package com.coding.school.webapp.carRepair.Controllers;

import com.coding.school.webapp.carRepair.Domain.Owner;
import com.coding.school.webapp.carRepair.Domain.Repair;
import com.coding.school.webapp.carRepair.Domain.Vehicle;
import com.coding.school.webapp.carRepair.Model.RegisterForm;
import com.coding.school.webapp.carRepair.Model.SearchForm;
import com.coding.school.webapp.carRepair.Services.OwnerService;
import com.coding.school.webapp.carRepair.Services.RepairService;
import com.coding.school.webapp.carRepair.Services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private static final String REGISTER_FORM = "user";

    private static final String SEARCH_FORM = "searchForm";

    private static final String REPAIR_DATA = "repairs";

    @Autowired
    RepairService repairService;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    OwnerService ownerService;

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    String homePage(Model model, HttpSession session){



        model.addAttribute(SEARCH_FORM, new SearchForm());
        return "index";
    }


    @RequestMapping(value = "/user/home", method = RequestMethod.GET)
    String userHomePage(Model model, HttpSession session){

        Authentication auth =
                SecurityContextHolder.getContext().getAuthentication();

        String username = (String) auth.getPrincipal(); // username is user email

        Owner owner = ownerService.findByEmail(username);
        Vehicle vehicle = vehicleService.findByOwner(owner);
        List<Repair> repairs = repairService.findByVehicle(vehicle);

        model.addAttribute(REPAIR_DATA,repairs);

        return "userHome";
    }

}
