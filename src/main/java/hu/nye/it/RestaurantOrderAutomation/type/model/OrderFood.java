package hu.nye.it.RestaurantOrderAutomation.type.model;

import hu.nye.it.RestaurantOrderAutomation.type.dto.OrderItemDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Egy rendeléshez tartozó ételt és azok mennyiségét ábrázolja
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderFood {

    /**
     * Elsődleges kulcs. Automatikusan generálódik táblába beszúráskor
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Étel neve
     */
    private String foodName;

    /**
     * Étel mennyisége a rendelésben
     */
    private Integer quantity;

    /**
     * Az ehhez tartozó rendelés. A ManyToOne kapcsolja össze az Orders tábléval.
     */
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order;

    public OrderFood(OrderItemDTO orderItemDTO) {
        this.foodName = orderItemDTO.getFood().getName();
        this.quantity = orderItemDTO.getQuantity();
    }
}
