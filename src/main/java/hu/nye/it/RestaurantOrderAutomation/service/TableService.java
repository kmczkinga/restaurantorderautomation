package hu.nye.it.RestaurantOrderAutomation.service;

import hu.nye.it.RestaurantOrderAutomation.repository.TableRepository;
import hu.nye.it.RestaurantOrderAutomation.type.model.OrderTable;
import hu.nye.it.RestaurantOrderAutomation.type.model.Orders;
import hu.nye.it.RestaurantOrderAutomation.type.model.Tables;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * Asztalokkal kapcsolatos logikák
 */
@Service
@RequiredArgsConstructor
public class TableService {

    private final TableRepository tableRepository;

    /**
     * Visszaadja a szabad asztalokat
     */
    public List<Tables> getAllNotOccupiedTables() {
        return tableRepository.findAll().stream().filter(table -> !table.getOccupied()).toList();
    }

    /**
     * Lefoglalja az asztalokat a megfelelő id-kkal, amelyek az orderben benne vannak
     */
    public void occupyTables(Orders order) {
        for (OrderTable orderTable : order.getTables()) {
            setTableOccupancy(orderTable.getTableId(), true);
        }
    }

    /**
     * Felszabadítja az asztalokat a megfelelő id-kkal, amelyek az orderben benne vanal
     */
    public void freeTables(Orders order) {
        for (OrderTable orderTable : order.getTables()) {
            setTableOccupancy(orderTable.getTableId(), false);
        }
    }

    /**
     * Lekéri a megadott asztalt, majd azt vagy lefoglalja, vagy felszabadítja
     */
    private void setTableOccupancy(int tableId, boolean occupancy) {
        final Optional<Tables> tablesOptional = tableRepository.findById(tableId);
        if (tablesOptional.isPresent()) {
            Tables table = tablesOptional.get();
            table.setOccupied(occupancy);
            tableRepository.save(table);
        }
    }
}
