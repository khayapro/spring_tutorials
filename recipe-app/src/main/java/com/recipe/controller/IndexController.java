package com.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by khayapro on 2018/11/07.
 */

@Controller
public class IndexController {

    @RequestMapping({"", "/", "/index.html"})
    public String getIndex() {
        System.out.println("print something else");
        return "index";
    }
}