package com.coding.school.webapp.carRepair.Controllers;

import com.coding.school.webapp.carRepair.Model.RegisterForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private static final String REGISTER_FORM = "user";

    @RequestMapping(name = "/admin/home", method = RequestMethod.GET)
    String homePage(Model model, HttpSession session){
        model.addAttribute(REGISTER_FORM, new RegisterForm());
        return "index";
    }
}
