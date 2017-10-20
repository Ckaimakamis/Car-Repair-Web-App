package com.coding.school.webapp.carRepair.Controllers;

import com.coding.school.webapp.carRepair.Domain.Owner;
import com.coding.school.webapp.carRepair.Model.RegisterForm;
import com.coding.school.webapp.carRepair.Model.SearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private static final String REGISTER_FORM = "user";

    private static final String SEARCH_FORM = "searchForm";


    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    String homePage(Model model, HttpSession session){



        model.addAttribute(SEARCH_FORM, new SearchForm());
        return "index";
    }
}
