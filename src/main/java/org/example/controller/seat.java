package org.example.controller;


import org.example.respo.seatRepo;
import org.example.tables.seatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class seat {


    @Autowired
    seatRepo seatRepo;

    @GetMapping("/seat")  // normal getmapping started the page , but is show the all data from database after started the page
    public String showSeats(Model model) {
        List<seatEntity> seats = seatRepo.findAll();
        model.addAttribute("seats", seats);
        return "seat";
    }





    @PostMapping("/seat/update")
    public String updateSeats(
            @RequestParam(value = "seatselection", required = false) List<String> selectedSeats,
            Model model ) {




        for (String seatNo : selectedSeats) {// why for each loop bcz we can selected the multiple at same time so the loops are works
            seatEntity seat = seatRepo.findBySeatNo(seatNo);  //seatEntity is datatype

            if (seat != null && !seat.isAvailable()) {

                seat.setAvailable(true);
                seatRepo.save(seat);
            }
        }

        return "redirect:/seat";
    }

}
