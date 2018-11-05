package com.petclinic.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by khayapro on 2018/11/05.
 */
@Controller
public class VetController {

    @RequestMapping({"/vets", "/vets/index"})
    public String vets() {
        return "vets/index";
    }
}
