package com.petclinic.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by khayapro on 2018/11/05.
 */
@Controller
public class OwnerController {

    @RequestMapping({"owners", "owners/index"})
    public String owner() {
        return "owners/index";
    }
}
