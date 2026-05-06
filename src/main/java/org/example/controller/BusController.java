package org.example.controller;

import org.example.respo.BusDetailRepo;
import org.example.tables.BusEntity;
//import org.example.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    BusDetailRepo BusDetailRepo;

    @PostMapping("/save")
    public String saveBus(@RequestBody BusEntity bus , Model model) {
        BusDetailRepo.save(bus);

        List<BusEntity> list = BusDetailRepo.findAll();
        model.addAttribute("result", list); // it is the main process , it is stored the user search data in results and the result data are redirected to the html page for using loops

        return "busdetail";
    }
}