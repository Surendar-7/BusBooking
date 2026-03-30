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
    RegEntityRepo RegEntityRepo;

    List<RegEntity> regdata=new ArrayList<>();


    @GetMapping("/register")
    public String reg(Model model){
        model.addAttribute("RegEntity", new RegEntity());
        return "register";
    }
    @PostMapping("/register")
    public String save(@ModelAttribute ("RegEntity") RegEntity regEntity){
        RegEntityRepo.save(regEntity);
        return "register";
    }




    @GetMapping("/login")
    public String buslog(Model model){
        model.addAttribute("RegEntity", new RegEntity());
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam String username ,
                        @RequestParam String email , @RequestParam String password) {

//        RegEntity  user=(RegEntityRepo.findByEmailAndPassword(email,password));
//        RegEntity  user =( RegEntityRepo.findByUserName(email);
//        RegEntity user=(RegEntityRepo.findByUserName(password);

//        if (user.equals(email) && user.equals(password)){
//            return "busbooking";
//        }else {
//            return "register";
//        }


        RegEntity user = RegEntityRepo.findByEmail(email);

        if (user != null){
            return "busbooking";
        } else {
            return "register";
        }

    }
    @GetMapping("/busbooking")
    public String bus(Model model){
        model.addAttribute("RegEntity" , new RegEntity());
        return "busbooking";
    }





}
