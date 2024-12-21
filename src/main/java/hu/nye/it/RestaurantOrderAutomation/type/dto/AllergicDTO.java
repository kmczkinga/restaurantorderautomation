package hu.nye.it.RestaurantOrderAutomation.type.dto;

import hu.nye.it.RestaurantOrderAutomation.type.model.Allergic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Egy allergiát ábrázol.
 * Ezt adjuk vissza a frondendnek.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllergicDTO {
    private Integer id;
    private String name;

    public AllergicDTO(final Allergic allergic) {
        this.id = allergic.getId();
        this.name = allergic.getName();
    }
}
