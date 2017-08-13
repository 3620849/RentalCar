package com.qualitest.demo.controllers;

import com.qualitest.demo.model.Role;
import com.qualitest.demo.model.User;
import com.qualitest.demo.model.UserAutority;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.condition.ConsumesRequestCondition;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

/**
 * Created by UA C on 23.07.2017.
 */
@Controller
public class PageController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndexPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = null;
        try{
         user = (User) authentication.getPrincipal();
        }catch (ClassCastException e){
             if (authentication.getPrincipal()=="anonymousUser"){
                 user=new User();
                 user.setUsername("anonymousUser");
                 user.grantRole(Role.ROLE_ANONYMOUS);
             }
        }
        model.addAttribute("username",user.getUsername());
        model.addAttribute("roles",user.getAuthorities().stream().map(s -> s.getAuthority()).collect(joining(",")));
        return "index";
    }

    /*@RequestMapping(value = "/login")
    required false znachit cto peremennaya v URL mojet bit a mojet i net
    public String LoginPage(@RequestParam(value = "error",required = false)String error,
                            @RequestParam(value = "logout",required = false)String logout, Model model){
        model.addAttribute("error", error!=null);
        model.addAttribute("logout", logout!=null);
        return "login";
    }*/
}
