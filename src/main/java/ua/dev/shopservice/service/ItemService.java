package ua.dev.shopservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import ua.dev.shopservice.dto.item.CreateItemRequest;
import ua.dev.shopservice.exception.ItemNotFoundException;
import ua.dev.shopservice.model.Item;
import ua.dev.shopservice.repository.ItemRepository;

@Service
@Log4j2
public class ItemService {

  private final ItemRepository itemRepository;

  @Autowired
  public ItemService(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  public List<Item> getAllItems() {
    return itemRepository.findAll();
  }

  public void createNewItem(CreateItemRequest req) {
    Item item = Item.builder()
        .article(req.getArticle())
        .type(req.getType())
        .category(req.getCategory())
        .name(req.getName())
        .shortDescription(req.getShortDescription())
        .fullDescription(req.getFullDescription())
        .imgUrl(req.getImgUrl())
        .regularPrice(req.getRegularPrice())
        .salePrice(req.getSalePrice())
        .quantity(req.getQuantity())
        .onSale(req.isSale())
        .isAvailable(req.isAvailable())
        .dateCreated(LocalDateTime.now())
        .dateEdited(LocalDateTime.now())
        .build();
    saveItem(item);
  }

  public void updateItem(CreateItemRequest req) {
    Item item = itemRepository.findById(req.getId())
        .orElseThrow(() -> new ItemNotFoundException("Item with ID: " + req.getId() + " not found"));
    item.setArticle(req.getArticle());
    item.setType(req.getType());
    item.setCategory(req.getCategory());
    item.setName(req.getName());
    item.setShortDescription(req.getShortDescription());
    item.setFullDescription(req.getFullDescription());
    item.setImgUrl(req.getImgUrl());
    item.setRegularPrice(req.getRegularPrice());
    item.setSalePrice(req.getSalePrice());
    item.setQuantity(req.getQuantity());
    item.setAvailable(req.isAvailable());
    item.setOnSale(req.isSale());
    item.setDateEdited(LocalDateTime.now());
    saveItem(item);
  }

  public void deleteItem(long id){
    try{
      itemRepository.deleteById(id);
      log.info("Deleted item with ID: " + id);
    }catch(Exception e){
      log.error("Error while deleting item -> " + e);
    }
  }

  private void saveItem(Item item) {
    try {
      itemRepository.save(item);
    } catch (Exception e) {
      log.error("Error occurred while saving item", new RuntimeException("Cathed"));
    }
  }

}
