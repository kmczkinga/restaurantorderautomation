package hu.nye.it.RestaurantOrderAutomation.type.dto;

import hu.nye.it.RestaurantOrderAutomation.type.model.Food;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Ez egy ételt ábrázol.
 * Ezt adjuk vissza a frontendnek.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {
    private Integer id;
    private String name;
    private String type;
    private Integer price;
    private String image;
    private List<AllergicDTO> allergic;
    private Integer quantity;

    public FoodDTO(final Food food) {
        this.id = food.getId();
        this.name = food.getName();
        this.type = food.getType();
        this.price = food.getPrice();
        this.image = food.getImage();
        this.allergic = food.getAllergic().stream().map(AllergicDTO::new).toList();
        this.quantity = 1;
    }
}
