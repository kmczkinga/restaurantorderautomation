package hu.nye.it.RestaurantOrderAutomation.service;

import hu.nye.it.RestaurantOrderAutomation.type.dto.FoodDTO;
import hu.nye.it.RestaurantOrderAutomation.type.dto.OrderItemDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * A rendelés tárolásáért felelős.
 */
@Service
public class OrderStore {


    /**
     * A rendelés.
     */
    private final List<OrderItemDTO> foods = new ArrayList<>();

    /**
     * Visszaadja az összes rendelési elemet.
     */
    public List<OrderItemDTO> getFoods() {
        return foods;
    }

    /**
     * Hozzáadja a megadott ételt a rendeléshez.
     * Megnézi, hogy az ételt tartalmazza-e a rendelés.
     * Ha igen, akkor növeli a mennyiségét a rendelésben.
     * Ha nem, akkor hozzáadja az ételt.
     */
    public void addFood(FoodDTO foodDTO) {
        for (OrderItemDTO orderItem : foods) {
            if (orderItem.getFood().getId().equals(foodDTO.getId())) {
                orderItem.increaseQuantity();
                return;
            }
        }
        foods.add(new OrderItemDTO(foodDTO, 1));
    }

    /**
     * Eltávolítja a rendelésből a megadott ételt.
     * Megnézi, hogy az ételt tartalmazza-e a rendelés és a mennyisége nagyobb, mint 1.
     * Ha igen, akkor csökkenti a mennyiségét a rendelésben.
     * Ha nem, akkor eltávolítja az ételt.
     */
    public void removeFood(FoodDTO foodDTO) {
        for (OrderItemDTO orderItem : foods) {
            if (orderItem.getFood().getId().equals(foodDTO.getId())) {
                if (orderItem.getQuantity() > 1) {
                    orderItem.decreaseQuantity();
                    return;
                }
                foods.remove(orderItem);
                return;
            }
        }

    }

    /**
     * Visszaadja az összesített árat a rendelésből.
     */
    public int getTotal() {
        return foods.stream()
                .mapToInt(orderItem -> orderItem.getFood().getPrice() * orderItem.getQuantity())
                .sum();
    }
}
