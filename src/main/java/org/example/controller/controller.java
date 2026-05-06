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




    @GetMapping("/register")  // started the main page and it is give the user data stored in DB
    public String reg(Model model) {
        model.addAttribute("RegEntity", new RegEntity());
        return "register";
    }


    @PostMapping("/register") // stored the data to DB
    public String save(@ModelAttribute("RegEntity") RegEntity regEntity) {
        regEntityRepo.save(regEntity);
        return "redirect:/login";
    }


    @GetMapping("/login")  // it is started the main login page
    public String loginPage(Model model) {
        model.addAttribute("RegEntity", new RegEntity());
        return "login";
    }


    @PostMapping("/saved")  // compare the data to the database
    public String login(@RequestParam String email,
                        @RequestParam String password
                        ) {

        List<RegEntity> user =
                regEntityRepo.findByEmailAndPassword(email, password);

        if (!user.isEmpty()) {
            return "redirect:/busbooking";
        } else {
            return "redirect:/register";
        }
    }

}