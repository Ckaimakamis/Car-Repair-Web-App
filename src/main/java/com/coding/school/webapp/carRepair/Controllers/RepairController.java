package com.coding.school.webapp.carRepair.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RepairController {

    @RequestMapping(value = "/admin/repair", method = RequestMethod.GET)
    public String exposeRepairSite(Model model) {

        return "serviceIndex";
    }
}
