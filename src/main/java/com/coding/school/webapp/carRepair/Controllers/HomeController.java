package com.coding.school.webapp.carRepair.Controllers;

import com.coding.school.webapp.carRepair.Domain.Owner;
import com.coding.school.webapp.carRepair.Domain.Repair;
import com.coding.school.webapp.carRepair.Domain.Vehicle;
import com.coding.school.webapp.carRepair.Model.SearchForm;
import com.coding.school.webapp.carRepair.Services.OwnerService;
import com.coding.school.webapp.carRepair.Services.RepairService;
import com.coding.school.webapp.carRepair.Services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    private static final String SEARCH_FORM = "searchForm";

    private static final String REPAIR_DATA = "repairs";

    private static final String VEHICLE = "vehicle";

    private static final int NUMBER_OF_REPAIRS = 10;

    @Autowired
    RepairService repairService;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    OwnerService ownerService;

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    String homePage(Model model, HttpSession session){

        List<Repair> repairs = repairService.findNextRepairs(NUMBER_OF_REPAIRS);

        model.addAttribute(REPAIR_DATA, repairs);
        session.setAttribute(REPAIR_DATA, repairs);
        model.addAttribute(SEARCH_FORM, new SearchForm());
        return "adminHomeIndex";
    }


    @RequestMapping(value = "/user/home", method = RequestMethod.GET)
    String userHomePage(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = (String) auth.getPrincipal();
        String password = (String) auth.getCredentials();

        Owner owner = ownerService.getOnlineOwner(username, password);
        Vehicle vehicle = vehicleService.findByOwner(owner);
        if(vehicle != null){
            model.addAttribute(VEHICLE, vehicle);
        }

        List<Repair> repairs = repairService.findByVehicle(vehicle);

        model.addAttribute(REPAIR_DATA,repairs);

        return "userHomeIndex";
    }

}
