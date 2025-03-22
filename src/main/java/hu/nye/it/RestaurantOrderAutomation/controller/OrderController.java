package hu.nye.it.RestaurantOrderAutomation.controller;

import hu.nye.it.RestaurantOrderAutomation.service.*;
import hu.nye.it.RestaurantOrderAutomation.type.dto.FoodDTO;
import hu.nye.it.RestaurantOrderAutomation.type.model.Food;
import hu.nye.it.RestaurantOrderAutomation.type.model.Orders;
import hu.nye.it.RestaurantOrderAutomation.type.model.PaymentMethod;
import hu.nye.it.RestaurantOrderAutomation.type.model.Tables;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A rendelés áttekintése oldal hívásai fogadásáért felelős.
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderStore orderStore;
    private final FoodService foodService;
    private final PaymentService paymentService;
    private final OrderService orderService;
    private final TableService tableService;

    /**
     * Rendelés áttekintése oldal betöltése.
     * Az orderStore-ból betölti az összes ételt és az összesített árat.
     */
    @GetMapping
    public String viewOrderStore(Model model) {
        List<PaymentMethod> paymentMethods = paymentService.getPaymentMethods();
        model.addAttribute("foods", orderStore.getFoods());
        model.addAttribute("total", orderStore.getTotal());
        model.addAttribute("tables", orderStore.getOccupiedTables());
        model.addAttribute("paymentMethods", paymentMethods);
        return "order";
    }

    /**
     * A megadott foodId alapján hozzáadja az ételt a rendeléshez, vagyis az orderStore-hoz.
     * Majd átírányít a megadott oldalra, jelen esetben marad az oldalon, ahol ezt meghívták.
     */
    @PostMapping("/food/add")
    public String addFoodToOrderStore(@RequestParam Integer foodId, @RequestHeader("referer") String referer) {
        Food food = foodService.findById(foodId);
        orderStore.addFood(new FoodDTO(food));
        return "redirect:" + referer;
    }

    /**
     * A megadott foodId alapján eltávolítja az ételt a rendelésből, vagyis az orderStore-ból.
     * Majd átírányít a megadott oldalra, jelen esetben marad az oldalon, ahol ezt meghívták.
     */
    @PostMapping("/food/remove")
    public String removeFoodFromOrderStore(@RequestParam Integer foodId, @RequestHeader("referer") String referer) {
        Food food = foodService.findById(foodId);
        orderStore.removeFood(new FoodDTO(food));
        return "redirect:" + referer;
    }

    /**
     * A megadott foodId alapján hozzáadja az asztalt a rendeléshez, vagyis az orderStore-hoz.
     * Majd átírányít a megadott oldalra, jelen esetben marad az oldalon, ahol ezt meghívták.
     */
    @PostMapping("/table/add")
    public String addTableToOrderStore(@RequestParam Integer tableId, @RequestHeader("referer") String referer) {
        Tables table = orderStore.getTableById(tableId);
        orderStore.addTable(table);
        return "redirect:" + referer;
    }

    /**
     * A megadott foodId alapján eltávolítja az asztalt a rendelésből, vagyis az orderStore-ból.
     * Majd átírányít a megadott oldalra, jelen esetben marad az oldalon, ahol ezt meghívták.
     */
    @PostMapping("/table/remove")
    public String removeTableFromOrderStore(@RequestParam Integer tableId, @RequestHeader("referer") String referer) {
        Tables table = orderStore.getTableById(tableId);
        orderStore.removeTable(table);
        return "redirect:" + referer;
    }


    /**
     * Leadja a rendelést, az orderStore-t letisztítja (nullázza a tárolt adatokat),
     * majd a rendelésben lefoglalt asztalokat lefoglalja.
     */
    @PostMapping("/confirm")
    public String confirmOrder(@RequestParam("paymentId") int paymentId, Model model) {
        paymentService.selectPaymentMethod(paymentId);
        final Orders order = orderService.save(orderStore.getAsOrder());
        model.addAttribute("orderId", order.getId());
        orderStore.clearStore();
        tableService.occupyTables(order);
        return "order-confirm";
    }
}
