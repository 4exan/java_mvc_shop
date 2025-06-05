package ua.dev.shopservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false)
  private String article;

  private String type;

  private String category;

  @Column(nullable = false, length = 100)
  private String name;

  @Column(name = "short_description")
  private String shortDescription;

  @Column(name = "full_description")
  private String fullDescription;

  @Column(name = "img_url")
  private String imgUrl;

  @Column(nullable = false, name = "regular_price")
  private BigDecimal regularPrice;

  @Column(nullable = false, name = "sale_price")
  private BigDecimal salePrice;

  @Column(nullable = false)
  private int quantity;

  @Column(name = "date_created")
  private LocalDateTime dateCreated;

  @Column(name = "date_edited")
  private LocalDateTime dateEdited;

  @Column(name = "on_sale")
  private boolean onSale;

  @Column(name = "is_available")
  private boolean isAvailable;

  @Override
  public boolean equals(Object o) {
    if (o == null || o.getClass() != getClass()) {
      return false;
    } else {
      Item item = (Item) o;
      return item.getArticle() == this.getArticle();
    }
  }

  @Override
  public int hashCode() {
    return article.hashCode();
  }

}
