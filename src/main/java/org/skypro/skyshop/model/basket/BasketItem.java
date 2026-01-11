package org.skypro.skyshop.model.basket;

import lombok.AllArgsConstructor;
import org.skypro.skyshop.model.product.Product;

public record BasketItem(Product product, Integer count) {
}
