package com.petclinic.controllers;

import com.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by khayapro on 2018/11/05.
 */
@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index"})
    public String vets(final Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
