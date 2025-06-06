package ua.dev.shopservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.dev.shopservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
