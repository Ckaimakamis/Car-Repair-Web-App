package com.coding.school.webapp.carRepair.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RepairController {

    @RequestMapping(name = "/repairs", method = RequestMethod.GET)
    public String showRepairs(){
        return "serviceIndex";
    }
}
