package org.example.controller;


import org.example.respo.BusDetailRepo;
import org.example.tables.BusDetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    BusDetailRepo BusDetailRepo;

    @GetMapping("/busbooking")
    public String bus(Model model) {
        model.addAttribute("BusDetailEntity", new BusDetailEntity());
        return "busbooking";
    }

//    @PostMapping("/saved")
//    public String placesdata(@RequestParam String from,
//                             @RequestParam String to , @ModelAttribute("BusDetailEntity") BusDetailEntity BusDetailEntity,
//                             Model model) {
//        BusDetailRepo.save(BusDetailEntity);
//
//        List<BusDetailEntity> d = BusDetailRepo.findByFromLocationAndToLocation(from , to);
//
//
////        model.addAttribute("BusDetailEntity", BusDetailEntity);
//
//        return "register";
//    }


    @GetMapping("/search")
    public List<BusDetailEntity> searchBus(@RequestParam String toPlace) {
        return BusDetailRepo.findByToPlace(toPlace);
    }

}
