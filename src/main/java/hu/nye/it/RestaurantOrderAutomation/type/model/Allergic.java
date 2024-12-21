package hu.nye.it.RestaurantOrderAutomation.type.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Egy allergiát ábrázol az adatbázisban.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Allergic {

    @Id
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "allergic")
    private List<Food> foods = new ArrayList<>();
}
