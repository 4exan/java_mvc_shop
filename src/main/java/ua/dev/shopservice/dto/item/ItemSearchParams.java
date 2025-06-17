package ua.dev.shopservice.dto.item;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemSearchParams{
    private String article;
    private String name;
    private String type;
    private String category;
    private BigDecimal fromPrice;
    private BigDecimal toPrice;
}