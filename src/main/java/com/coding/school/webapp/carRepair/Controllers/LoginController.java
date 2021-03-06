package com.coding.school.webapp.carRepair.Controllers;

import com.coding.school.webapp.carRepair.Model.LoginForm;
import com.coding.school.webapp.carRepair.Services.OwnerService;
import com.coding.school.webapp.carRepair.Services.OwnerServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    OwnerService service;

    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(OwnerServiceImpl.class);

    private static final String LOGIN_FORM = "loginForm";

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, @RequestParam(name = "error", required = false) String error) {
        if (error != null) {
            LOG.error("User not found!");
            model.addAttribute("errorMessage", "User not found! Please try again");
        }

        model.addAttribute(LOGIN_FORM, new LoginForm());
        return "login";

    }
}