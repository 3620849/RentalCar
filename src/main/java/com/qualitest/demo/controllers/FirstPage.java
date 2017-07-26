package com.qualitest.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by UA C on 23.07.2017.
 */
@Controller
public class FirstPage {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndexPage() {
        return "index";
    }
}
