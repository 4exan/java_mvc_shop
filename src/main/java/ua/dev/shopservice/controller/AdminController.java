package ua.dev.shopservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.dev.shopservice.repository.ItemRepository;
import ua.dev.shopservice.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public AdminController(UserRepository userRepository, ItemRepository itemRepository){
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }
    
    @GetMapping
    public String adminDashboard(Model model){
        model.addAttribute("items", itemRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        return "admin/dashboard";
    }
    
}
