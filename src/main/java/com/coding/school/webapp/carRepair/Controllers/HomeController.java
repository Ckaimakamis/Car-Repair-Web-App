package com.coding.school.webapp.carRepair.Controllers;

import com.coding.school.webapp.carRepair.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    AccountService accountService;

    private boolean isLoggedIn;

    @PostConstruct
    void checkOnlineUser(){

    }

    @RequestMapping(name = "/", method = RequestMethod.GET)
    String homePage(Model model, HttpSession session){
        return "index";
    }
}
