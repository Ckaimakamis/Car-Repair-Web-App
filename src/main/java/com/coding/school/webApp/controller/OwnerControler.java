package com.coding.school.webApp.controller;

import com.coding.school.webApp.model.Owner;
import com.coding.school.webApp.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("OwnerController")
public class OwnerControler {
    @Autowired
    @Qualifier("OwnerService")
    OwnerService service;

    @RequestMapping(name = "/owner", params = "ID")
    public Owner getOwnerById(@RequestParam("ID") Integer ID){
        Owner owner = service.findById(ID);
        return owner;
    }

    String getOwnerVat(@RequestParam("ID") Integer ID){
        Owner owner = service.findById(ID);
        return owner.getVat().toString();
    }
}
