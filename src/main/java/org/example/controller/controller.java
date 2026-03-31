package org.example.controller;

import org.example.respo.RegEntityRepo;
import org.example.tables.RegEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class controller {


    @Autowired
    RegEntityRepo regEntityRepo;




    @GetMapping("/register")
    public String reg(Model model) {
        model.addAttribute("RegEntity", new RegEntity());
        return "register";
    }


    @PostMapping("/datasaved")
    public String save(@ModelAttribute("RegEntity") RegEntity regEntity) {
        regEntityRepo.save(regEntity);
        return "redirect:/login";
    }


    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("RegEntity", new RegEntity());
        return "login";
    }


    @PostMapping("/saved")
    public String login(@RequestParam String email,@RequestParam String username,
                        @RequestParam String password) {


        List<RegEntity> user;

        user= regEntityRepo.findByEmailAndPassword(email,password);




        if (user!= null) {

            return "redirect:/busbooking";
        } else {
            return "redirect:/register";
        }
    }

}