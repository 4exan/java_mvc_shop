package ua.dev.shopservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateItemRequest {
  private long id;
  private String article;
  private String category;
  private String type;
  private String name;
  private String shortDescription;
  private String fullDescription;
  private String imgUrl;
  private BigDecimal regularPrice;
  private BigDecimal salePrice;
  private int quantity;
  private boolean available;
  private boolean sale;
}
