package com.petclinic.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by khayapro on 2018/11/05.
 */

@Controller
public class IndexController {

    @RequestMapping({"", "/", "/index", "index.html"})
    public String index() {
        return "index";
    }
}
