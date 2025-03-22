package hu.nye.it.RestaurantOrderAutomation.service;

import hu.nye.it.RestaurantOrderAutomation.type.dto.FoodDTO;
import hu.nye.it.RestaurantOrderAutomation.type.dto.OrderItemDTO;
import hu.nye.it.RestaurantOrderAutomation.type.model.*;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * A rendelés tárolásáért felelős.
 */
@Data
@Service
public class OrderStore {

    private static final String KEZPENZ = "Kézpénz";

    /**
     * Rendelni kívánt ételek
     */
    private List<OrderItemDTO> foods = new ArrayList<>();

    /**
     * Lefoglalható asztalok
     */
    private List<Tables> tables = new ArrayList<>();

    /**
     * Kiválasztott fizetőeszköz
     */
    private PaymentMethod paymentMethod;

    /**
     * Mezők nullázása
     */
    public void clearStore() {
        foods = new ArrayList<>();
        tables = new ArrayList<>();
        paymentMethod = null;
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
     * Visszaadja a megadott id-vel rendelkező asztalt
     */
    public Tables getTableById(int tableId) {
        for (Tables table : tables) {
            if (table.getId().equals(tableId)) {
                return table;
            }
        }
        return null;
    }

    /**
     * Hozzáadja a megadott asztalt a rendeléshez.
     * Megnézi, hogy az asztalt tartalmazza-e a rendelés.
     * Ha nem, akkor hozzáadja az asztalt és lefoglalja.
     */
    public void addTable(Tables newTable) {
        for (Tables table : tables) {
            if (table.getId().equals(newTable.getId())) {
                table.setOccupied(true);
            }
        }
    }

    /**
     * Eltávolítja a rendelésből a megadott asztalt.
     */
    public void removeTable(Tables oldTable) {
        for (Tables table : tables) {
            if (table.getId().equals(oldTable.getId())) {
                table.setOccupied(false);
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

    /**
     * Visszaadja a lefoglalt asztalokat
     */
    public List<Tables> getOccupiedTables() {
        return tables.stream().filter(Tables::getOccupied).toList();
    }

    /**
     * Visszaadja a tárolt mezőket Orders-ként.
     */
    public Orders getAsOrder() {
        return Orders.builder()
                .foods(foods.stream().map(OrderFood::new).toList())
                .tables(getOccupiedTables().stream().map(t -> new OrderTable(t.getId())).toList())
                .paymentMethod(paymentMethod == null ? KEZPENZ : paymentMethod.getName())
                .total(getTotal())
                .prepared(false)
                .build();
    }
}
