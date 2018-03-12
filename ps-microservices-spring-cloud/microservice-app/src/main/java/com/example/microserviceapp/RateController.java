package com.example.microserviceapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RateController {

    @Value("${rate}")
    private String rate;
    @Value("${lanecount}")
    private String laneCount;
    @Value("${tollstart}")
    private String tollstart;

    @RequestMapping("/rate")
    public String getRate(Model model) {
        model.addAttribute("rate_amount", rate);
        model.addAttribute("lanes", laneCount);
        model.addAttribute("toll_start", tollstart);
//        return model.toString();

        return "rateview";
    }
}
