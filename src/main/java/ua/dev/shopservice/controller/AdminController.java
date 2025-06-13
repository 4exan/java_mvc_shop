package ua.dev.shopservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;
import ua.dev.shopservice.dto.CreateItemRequest;
import ua.dev.shopservice.dto.CreateUserRequest;
import ua.dev.shopservice.service.ItemService;
import ua.dev.shopservice.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/admin")
@Log4j2
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
    log.info("Created item -> " + req.toString());
    return "redirect:/admin";
  }

  @PostMapping("/items/edit")
  public String updateItem(@ModelAttribute CreateItemRequest req) {
    itemService.updateItem(req);
    log.info("Edited item -> " + req.toString());
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
    log.info("Created user -> " + req.toString());
    return "redirect:/admin";
  }

  @PostMapping("/users/edit")
  public String updateUser(@ModelAttribute CreateUserRequest req) {
    userService.updateUser(req);
    log.info("Edited user -> " + req.toString());
    return "redirect:/admin";
  }

}
