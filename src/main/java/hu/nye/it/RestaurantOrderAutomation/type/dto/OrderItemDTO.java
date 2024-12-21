package hu.nye.it.RestaurantOrderAutomation.type.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Ez egy rendelés elemet, vagyis egy ételt és annak a mennyiségét ábrázlja.
 * Ezt adjuk vissza a frontendnek.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemDTO {
    private FoodDTO food;
    private Integer quantity;


    /**
     * Növeli a mennyiséget
     */
    public void increaseQuantity() {
        this.quantity++;
    }

    /**
     * Csökkenti a mennyiséget
     */
    public void decreaseQuantity() {
        this.quantity--;
    }
}