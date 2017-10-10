//package com.coding.school.webApp.controller;
//
//import com.coding.school.webApp.model.Repair;
//import com.coding.school.webApp.service.RepairService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller("RepairController")
//public class RepairController {
//
//    @Autowired
//    @Qualifier("RepairService")
//    private RepairService service;
//
//    @RequestMapping(name = "/repair", params = "ID")
//    String repairDemo(@RequestParam("ID") Integer ID){
//        Repair repair = service.findById(ID);
//        return repair.getType().toString();
//    }
//
//}
