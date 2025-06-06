package ua.dev.shopservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ua.dev.shopservice.dto.UserDetailsImpl;
import ua.dev.shopservice.model.User;
import ua.dev.shopservice.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Optional<User> user = userRepository.findByEmail(email);

        return user.map(UserDetailsImpl::new).orElseThrow(() -> new UsernameNotFoundException(email + "not found"));
    }

}
