package ua.dev.shopservice.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import ua.dev.shopservice.repository.UserRepository;
import ua.dev.shopservice.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

  private final UserDetailsServiceImpl userDetailsServiceImpl;

  private final UserRepository userRepository;

  SecurityConfig(UserRepository userRepository, UserDetailsServiceImpl userDetailsServiceImpl) {
    this.userRepository = userRepository;
    this.userDetailsServiceImpl = userDetailsServiceImpl;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/h2-console/**").permitAll()
            .requestMatchers("/shop/**", "/").permitAll()
            .requestMatchers("/admin/**").authenticated()
            .requestMatchers("/css/**", "/js/**").permitAll())
        .csrf(csrf -> csrf
            .ignoringRequestMatchers("/h2-console/**"))
        .headers((headers) -> headers
            .defaultsDisabled()
            .frameOptions(frameOptions -> frameOptions.sameOrigin()))
        .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
        .logout(logout -> logout
            .logoutSuccessUrl("/shop")
            .permitAll());
    return http.build();
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(userDetailsServiceImpl);
    provider.setPasswordEncoder(passwordEncoder());
    return provider;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public CommandLineRunner run() {
    return args -> {
      if (userRepository.findByEmail("admin").isEmpty()) {
        ua.dev.shopservice.model.User user = new ua.dev.shopservice.model.User();
        user.setEmail("admin");
        user.setPassword(passwordEncoder().encode("admin"));
        user.setRole("ADMIN");
        userRepository.save(user);
      } else {
        System.out.println(
            "Loaded user: " + userRepository.findByEmail("admin").orElseThrow(() -> new RuntimeException()).toString());
      }
    };
  }

}
