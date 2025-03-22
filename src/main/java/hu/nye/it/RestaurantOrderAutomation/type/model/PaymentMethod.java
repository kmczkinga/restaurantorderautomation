package hu.nye.it.RestaurantOrderAutomation.type.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Fizetőeszközt ábrázol
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PaymentMethod {

    /**
     * Elsődleges kulcs
     */
    @Id
    private Integer id;

    /**
     * Fizetőeszköz neve
     */
    private String name;

    /**
     * Fizetőeszköz képe
     */
    private String image;
}
