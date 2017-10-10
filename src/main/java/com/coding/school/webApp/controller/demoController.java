package com.coding.school.webApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class demoController {

    @RequestMapping("/")
    String demoPage() {
        return "index";
    }

    @RequestMapping("/login")
    String logInPage() {
        return "loginForm";
    }
}
