package hu.nye.it.RestaurantOrderAutomation.type.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Egy asztalt ábrázol az adatbázisban.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tables {

    /**
     * Elsődleges kulcs
     */
    @Id
    private Integer id;

    /**
     * Székek/helyek száma
     */
    private Integer numberOfSeats;

    /**
     * Le van-e foglalva/használva van, vagy sem.
     */
    private Boolean occupied;
}
