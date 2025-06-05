package ua.dev.shopservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.dev.shopservice.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
    
}
