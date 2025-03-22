package hu.nye.it.RestaurantOrderAutomation.type.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Egy ételt ábrázol az adatbázisban.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Food {

    /**
     * Elsődleges kulcs
     */
    @Id
    private Integer id;

    /**
     * Étel neve
     */
    private String name;

    /**
     * Étel típusa  (leves, főétel, desszert)
     */
    private String type;

    /**
     * Étel ára
     */
    private Integer price;

    /**
     * Étel képe
     */
    private String image;

    /**
     * Összekapcsolja az Allergic és Food táblát Több-a-többhöz kapcsolattal.
     */
    @ManyToMany
    @JoinTable(name = "food_allergic",
            joinColumns = @JoinColumn(name = "food_id"),
            inverseJoinColumns = @JoinColumn(name = "allergic_id"))
    private List<Allergic> allergic = new ArrayList<>();
}
