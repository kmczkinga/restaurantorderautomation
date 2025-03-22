package hu.nye.it.RestaurantOrderAutomation.controller;

import hu.nye.it.RestaurantOrderAutomation.service.OrderStore;
import hu.nye.it.RestaurantOrderAutomation.service.TableService;
import hu.nye.it.RestaurantOrderAutomation.type.model.Tables;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Az asztal kiválasztós oldal hívásai fogadásáért felelős.
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/table")
public class TableController {
    private final TableService tableService;
    private final OrderStore orderStore;

    /**
     * Rendelés áttekintése oldal betöltése.
     * Az orderStore-ból betölti az összes ételt és az összesített árat.
     */
    @GetMapping
    public String viewTables(Model model) {
        if (orderStore.getTables().isEmpty()) {
            final List<Tables> tables = tableService.getAllNotOccupiedTables();
            orderStore.setTables(tables);
        }
        model.addAttribute("tables", orderStore.getTables());
        return "tables";
    }
}
