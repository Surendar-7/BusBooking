package org.example.controller;


import org.example.respo.BusDetailRepo;
import org.example.respo.seatRepo;
import org.example.tables.BusEntity;
import org.example.tables.RegEntity;
import org.example.tables.seatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    BusDetailRepo BusDetailRepo;


    @GetMapping("/busbooking")  // started the main page
    public String bus(Model model) {
        model.addAttribute("BusEntity", new BusEntity());
        return "busbooking";
    }

    @PostMapping("/busbooking")  // compare the bus details in database and redirect to the html page
    public String search(@RequestParam String fromPlace,
                         @RequestParam String toPlace,
                         Model model) {

        List<BusEntity> result =
                BusDetailRepo.findByFromPlaceAndToPlace(fromPlace, toPlace);

        model.addAttribute("result", result); // it is the main process , it is stored the user search data in results and the result data are redirected to the html page for using loops

        if(result.isEmpty()){
            return "redirect:/register";
        }
        else {
            return "busdetail";
        }
    }
}


