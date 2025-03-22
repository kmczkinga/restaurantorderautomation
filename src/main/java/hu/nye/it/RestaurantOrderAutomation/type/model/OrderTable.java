package hu.nye.it.RestaurantOrderAutomation.type.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Egy rendeléshez tartozó asztal foglalást ábrzázol
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderTable {

    /**
     * Elsődleges kulcs. Táblába beszúráskor automatikusan kitöltődik.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Asztal id
     */
    private Integer tableId;

    /**
     * Hozzá tartozó rendelés
     */
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order;

    public OrderTable(Integer tableId) {
        this.tableId = tableId;
    }
}
