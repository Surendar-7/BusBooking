package org.example.controller;


import org.example.respo.seatRepo;
import org.example.tables.seatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class seat {


    @Autowired
    seatRepo seatRepo;

    @GetMapping("/seat")  // started the main page
    public String showForm(Model model) {
        model.addAttribute("seatEntity", new seatEntity());
        return "seat";
    }

    @PostMapping("/seat/selection")
    public String sd(@RequestParam String seatno,
                     @RequestParam String busid,
                     Model model){

        List<seatEntity> userselection = seatRepo.findBySeatNoAndBusId(seatno, busid);

        model.addAttribute("seat", userselection);

        return "seat";
    }


}
