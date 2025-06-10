package ua.dev.shopservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.dev.shopservice.dto.CreateUserRequest;
import ua.dev.shopservice.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/new")
  public String createUser(Model model) {
    model.addAttribute("user", new CreateUserRequest());
    return "items/new";
  }

  @PostMapping
  public String saveUser(@ModelAttribute CreateItemRequest req) {
    itemService.createNewItem(req);
    return "redirect:/items";
  }

}
