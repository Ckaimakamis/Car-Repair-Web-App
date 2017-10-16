package com.coding.school.webapp.carRepair.Controllers;

import com.coding.school.webapp.carRepair.Converters.OwnerConverter;
import com.coding.school.webapp.carRepair.Domain.Owner;
import com.coding.school.webapp.carRepair.Exceptions.UserExistException;
import com.coding.school.webapp.carRepair.Model.RegisterForm;
import com.coding.school.webapp.carRepair.Services.OwnerService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class RegisterController {

    //kalw to interface san kalitero practice
    @Autowired
    OwnerService service;

    private static final String REGISTER_FORM = "user";

    @RequestMapping(name = "/registerUser", method = RequestMethod.POST)
    String addUser(@Valid @ModelAttribute("REGISTER_FORM") RegisterForm model, HttpSession session,
                   RedirectAttributes redirectAttributes){
        try{
            service.registerOwner(OwnerConverter.buildUserObject(model));
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/admin/home";
    }
}
