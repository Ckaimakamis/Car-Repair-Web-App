package com.coding.school.webapp.carRepair.Controllers;

import com.coding.school.webapp.carRepair.Domain.Owner;
import com.coding.school.webapp.carRepair.Services.OwnerService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {

    //kalw to interface san kalitero practice
    @Autowired
    OwnerService service;

    @RequestMapping(name = "/registerUser", method = RequestMethod.POST)
    String addUser(@ModelAttribute("user") Owner model, HttpSession session){
        service.registerOwner(model);
        return "redirect:/admin/home";
    }
}
