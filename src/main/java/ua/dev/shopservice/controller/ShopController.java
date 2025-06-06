package ua.dev.shopservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.dev.shopservice.service.UserService;

@Controller
@RequestMapping("/shop")
public class ShopController {
    
    private final UserService userService;

    @Autowired
    public ShopController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public String shopIndex(){
        return "shop/index";
    }

}
