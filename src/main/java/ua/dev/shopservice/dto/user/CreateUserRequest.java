package ua.dev.shopservice.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
  private long id;
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private String password;
  private String role;
}
