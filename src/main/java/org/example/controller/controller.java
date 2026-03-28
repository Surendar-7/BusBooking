package org.example.controller;


import org.example.respo.RegEntityRepo;
import org.example.tables.RegEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class controller {

    @Autowired
    RegEntityRepo RegEntityRepo;

    @GetMapping("/register")
    public String reg(Model model){
        model.addAttribute("RegEntity", new RegEntity());
        return "register";
    }
    @PostMapping("/saveUser")
    public String save(@ModelAttribute RegEntity RegEntity ){
        RegEntityRepo.save(RegEntity);
        return "demo";
    }





}
