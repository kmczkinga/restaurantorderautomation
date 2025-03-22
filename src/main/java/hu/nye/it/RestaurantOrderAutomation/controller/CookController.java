package hu.nye.it.RestaurantOrderAutomation.controller;

import hu.nye.it.RestaurantOrderAutomation.service.OrderService;
import hu.nye.it.RestaurantOrderAutomation.service.OrderStore;
import hu.nye.it.RestaurantOrderAutomation.service.TableService;
import hu.nye.it.RestaurantOrderAutomation.type.dto.OrderDTO;
import hu.nye.it.RestaurantOrderAutomation.type.model.Tables;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A szakács oldali hívások fogadásáért felelős.
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/cook")
public class CookController {

    private final OrderService orderService;

    private final OrderStore orderStore;

    private final TableService tableService;


    /**
     * Visszaadja az összes rendelést.
     */
    @GetMapping
    public String view(Model model) {
        List<OrderDTO> orders = orderService.list().stream().map(OrderDTO::new).toList();
        model.addAttribute("orders", orders);
        return "cook";
    }

    /**
     * A megadott orderId-jű rendelést átteszi elkészítettbe.
     */
    @PostMapping("/set-prepared")
    public String setPrepared(@RequestParam("orderId") int orderId, @RequestHeader("referer") String referer) {
        orderService.setPrepared(orderId);
        return "redirect:" + referer;
    }

    /**
     * A megadott orderId-jű rendeléshez tartozó asztalokat felszabadítja.
     * A rendelést kitörli, majd betölti az orderStore-ban a nem foglalt táblákat.
     * (Erre azért volt szükség, mivel ha 2 rendelés van, az egyik törlése után visszamegyünk a rendelésbe,
     * akkor betölti az asztalokat. Majd ha visszamegyünk a szakács nézetre, kitöröljük a másikat,
     * majd visszamegyünk a rendelésbe és az asztalokhoz, akkor a nemrégiben felszabadított asztalok
     * nem kerülnek vissza. Az újabb betöltéssel ezt megakadályozzuk.)
     */
    @PostMapping("/delete")
    public String delete(@RequestParam("orderId") int orderId, @RequestHeader("referer") String referer) {
        tableService.freeTables(orderService.load(orderId));
        orderService.delete(orderId);
        final List<Tables> tables = tableService.getAllNotOccupiedTables();
        orderStore.setTables(tables);
        return "redirect:" + referer;
    }


}
