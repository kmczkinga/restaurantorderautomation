package hu.nye.it.RestaurantOrderAutomation.controller;

import hu.nye.it.RestaurantOrderAutomation.service.FoodService;
import hu.nye.it.RestaurantOrderAutomation.service.OrderStore;
import hu.nye.it.RestaurantOrderAutomation.type.dto.FoodDTO;
import hu.nye.it.RestaurantOrderAutomation.type.model.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class FoodController {

    private final FoodService foodService;
    private final OrderStore orderStore;

    /**
     * Üdvözlő oldal betöltése.
     */
    @GetMapping
    public String welcome() {
        return "welcome";
    }

    /**
     * Leves oldal betöltése.
     * Az oldalhoz betölti a szervíz osztályból az összes levest, amit FoodDTO osztályjá átalakít.
     */
    @GetMapping("/soup")
    public String listSoups(Model model) {
        final List<FoodDTO> foods = foodService.findAllSoups().stream().map(FoodDTO::new).toList();
        model.addAttribute("foods", foods);
        return "soup";
    }

    /**
     * Főétel oldal betöltése.
     * Az oldalhoz betölti a szervíz osztályból az összes főételt, amit FoodDTO osztályjá átalakít.
     */
    @GetMapping("/main-meal")
    public String listMainMeals(Model model) {
        final List<FoodDTO> foods = foodService.findAllMainMeals().stream().map(FoodDTO::new).toList();
        model.addAttribute("foods", foods);
        return "main-meal";
    }

    /**
     * Desszert oldal betöltése.
     * Az oldalhoz betölti a szervíz osztályból az összes desszertet, amit FoodDTO osztályjá átalakít.
     */
    @GetMapping("/dessert")
    public String listDesserts(Model model) {
        final List<FoodDTO> foods = foodService.findAllDesserts().stream().map(FoodDTO::new).toList();
        model.addAttribute("foods", foods);
        return "dessert";
    }

    /**
     * Rendelés áttekintése oldal betöltése.
     * Az orderStore-ból betölti az összes ételt és az összesített árat.
     */
    @GetMapping("/order")
    public String viewOrderStore(Model model) {
        model.addAttribute("foods", orderStore.getFoods());
        model.addAttribute("total", orderStore.getTotal());
        return "order";
    }

    /**
     * A megadott foodId alapján hozzáadja az ételt a rendeléshez, vagyis az orderStore-hoz.
     * Majd átírányít a megadott oldalra, jelen esetben marad az oldalon, ahol ezt meghívták.
     */
    @PostMapping("/add-to-order")
    public String addToOrderStore(@RequestParam Integer foodId, @RequestHeader("referer") String referer) {
        Food food = foodService.findById(foodId);
        orderStore.addFood(new FoodDTO(food));
        return "redirect:" + referer;
    }

    /**
     * A megadott foodId alapján eltávolítja az ételt a rendelésből, vagyis az orderStore-ból.
     * Majd átírányít a megadott oldalra, jelen esetben marad az oldalon, ahol ezt meghívták.
     */
    @PostMapping("/remove-from-order")
    public String removeFromOrderStore(@RequestParam Integer foodId, @RequestHeader("referer") String referer) {
        Food food = foodService.findById(foodId);
        orderStore.removeFood(new FoodDTO(food));
        return "redirect:" + referer;
    }
}
