package hu.nye.it.RestaurantOrderAutomation.type.dto;

import hu.nye.it.RestaurantOrderAutomation.type.model.OrderFood;
import hu.nye.it.RestaurantOrderAutomation.type.model.OrderTable;
import hu.nye.it.RestaurantOrderAutomation.type.model.Orders;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Egy rendelést ábrázol.
 * Ezt adjuk vissza a frondendnek.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Integer id;

    private String paymentMethod;

    private Integer total;

    private Boolean prepared;

    private List<OrderFood> foods = new ArrayList<>();

    private List<OrderTable> tables = new ArrayList<>();

    public OrderDTO(Orders orders) {
        this.id = orders.getId();
        this.paymentMethod = orders.getPaymentMethod();
        this.total = orders.getTotal();
        this.prepared = orders.getPrepared();
        this.foods = orders.getFoods();
        this.tables = orders.getTables();
    }
}
