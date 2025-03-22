package hu.nye.it.RestaurantOrderAutomation.controller;

import hu.nye.it.RestaurantOrderAutomation.service.FoodService;
import hu.nye.it.RestaurantOrderAutomation.service.OrderStore;
import hu.nye.it.RestaurantOrderAutomation.type.dto.FoodDTO;
import hu.nye.it.RestaurantOrderAutomation.type.dto.OrderItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Az étel oldalak (leves, főétel, desszert) hívásai fogadásáért felelős.
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;
    private final OrderStore orderStore;

    /**
     * Leves oldal betöltése.
     * Az oldalhoz betölti a szervíz osztályból az összes levest, amit FoodDTO osztályjá átalakít.
     */
    @GetMapping("/soup")
    public String listSoups(Model model) {
        final List<FoodDTO> foods = foodService.findAllSoups().stream().map(FoodDTO::new).toList();
        model.addAttribute("foods", countQuantities(foods));
        return "soup";
    }

    /**
     * Főétel oldal betöltése.
     * Az oldalhoz betölti a szervíz osztályból az összes főételt, amit FoodDTO osztályjá átalakít.
     */
    @GetMapping("/main-meal")
    public String listMainMeals(Model model) {
        final List<FoodDTO> foods = foodService.findAllMainMeals().stream().map(FoodDTO::new).toList();
        model.addAttribute("foods", countQuantities(foods));
        return "main-meal";
    }

    /**
     * Desszert oldal betöltése.
     * Az oldalhoz betölti a szervíz osztályból az összes desszertet, amit FoodDTO osztályjá átalakít.
     */
    @GetMapping("/dessert")
    public String listDesserts(Model model) {
        final List<FoodDTO> foods = foodService.findAllDesserts().stream().map(FoodDTO::new).toList();
        model.addAttribute("foods", countQuantities(foods));
        return "dessert";
    }


    /**
     * Megszámolja, hogy az adott ételekből hány db van egy rendelésben.
     */
    private List<FoodDTO> countQuantities(final List<FoodDTO> foods) {
        final List<OrderItemDTO> orders = orderStore.getFoods();
        int quantity;
        for (final FoodDTO food : foods) {
            quantity = 0;
            for (final OrderItemDTO order : orders) {
                if (order.getFood().getId().equals(food.getId())) {
                    quantity = order.getQuantity();
                }
            }
            food.setQuantity(quantity);
        }
        return foods;
    }
}
