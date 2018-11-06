package com.petclinic.controllers;

import com.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by khayapro on 2018/11/05.
 */
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"owners", "owners/index"})
    public String getOwnerList(final Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }
}
