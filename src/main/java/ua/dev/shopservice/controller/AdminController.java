package ua.dev.shopservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.dev.shopservice.dto.CreateItemRequest;
import ua.dev.shopservice.dto.CreateUserRequest;
import ua.dev.shopservice.service.ItemService;
import ua.dev.shopservice.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

  private final UserService userService;
  private final ItemService itemService;

  @Autowired
  public AdminController(UserService userService, ItemService itemService) {
    this.userService = userService;
    this.itemService = itemService;
  }

  @GetMapping
  public String adminDashboard(Model model) {
    model.addAttribute("items", itemService.getAllItems());
    model.addAttribute("users", userService.getAllUsers());
    return "admin/dashboard";
  }

  @GetMapping("/items/new")
  public String createItem(Model model) {
    model.addAttribute("item", new CreateItemRequest());
    return "admin/new-item";
  }

  @PostMapping("/items/new")
  public String saveItem(@ModelAttribute CreateItemRequest req) {
    itemService.createNewItem(req);
    return "redirect:/admin";
  }

  @GetMapping("/users/new")
  public String createUser(Model model) {
    model.addAttribute("user", new CreateUserRequest());
    return "admin/new-user";
  }

  @PostMapping("/users/new")
  public String saveUser(@ModelAttribute CreateUserRequest req) {
    userService.createNewUser(req);
    return "redirect:/admin";
  }

}
