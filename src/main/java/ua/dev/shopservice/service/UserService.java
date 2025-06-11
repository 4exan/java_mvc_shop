package ua.dev.shopservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import ua.dev.shopservice.dto.CreateUserRequest;
import ua.dev.shopservice.exception.UserNotFoundException;
import ua.dev.shopservice.model.User;
import ua.dev.shopservice.repository.UserRepository;

@Service
@Log4j2
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public void createNewUser(CreateUserRequest req) {
    User user = User.builder()
        .firstName(req.getFirstName())
        .lastName(req.getLastName())
        .email(req.getEmail())
        .phone(req.getPhone())
        .password(passwordEncoder.encode(req.getPassword()))
        .role(req.getRole())
        .build();
    saveUser(user);
  }

  public void updateUser(long id, CreateUserRequest req) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException("User with ID: " + id + " not found"));
    user.setFirstName(req.getFirstName());
    user.setLastName(req.getLastName());
    user.setEmail(req.getEmail());
    user.setPhone(req.getPhone());
    user.setPassword(passwordEncoder.encode(req.getPassword()));
    user.setRole(req.getRole());
    saveUser(user);
  }

  private void saveUser(User user) {
    try {
      userRepository.save(user);
    } catch (Exception e) {
      log.error("Error occurred while saving user", new RuntimeException("Catched"));
    }
  }

}
