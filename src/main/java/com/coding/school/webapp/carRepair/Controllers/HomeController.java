package com.coding.school.webapp.carRepair.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping(name = "/admin/home", method = RequestMethod.GET)
    String homePage(Model model, HttpSession session){
        return "index";
    }
}
