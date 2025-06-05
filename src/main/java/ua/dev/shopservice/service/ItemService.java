package ua.dev.shopservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.dev.shopservice.dto.CreateItemRequest;
import ua.dev.shopservice.model.Item;
import ua.dev.shopservice.repository.ItemRepository;

@Service
public class ItemService {
    
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public void createNewItem(CreateItemRequest req){
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
        itemRepository.save(item);
    }

}
