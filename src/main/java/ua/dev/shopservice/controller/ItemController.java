package ua.dev.shopservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.dev.shopservice.dto.CreateItemRequest;
import ua.dev.shopservice.service.ItemService;

//TODO create 'config'
//TODO create authorization
//TODO refactor template folder (admin/user)
//TODO create 'User'/'Admin' models

@Controller
@RequestMapping("items")
public class ItemController {
    
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping
    public String getAllItems(Model model){
        model.addAttribute("items", itemService.getAllItems());
        return "items/items";
    }

    @GetMapping("/new")
    public String createItem(Model model){
        model.addAttribute("item", new CreateItemRequest());
        return "items/new";
    }

    @PostMapping
    public String saveItem(@ModelAttribute CreateItemRequest req){
        itemService.createNewItem(req);
        return "redirect:/items";
    }

}
