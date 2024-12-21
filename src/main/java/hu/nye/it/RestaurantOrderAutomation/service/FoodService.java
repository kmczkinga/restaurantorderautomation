package hu.nye.it.RestaurantOrderAutomation.service;

import hu.nye.it.RestaurantOrderAutomation.repository.FoodRepository;
import hu.nye.it.RestaurantOrderAutomation.type.model.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private static final String SOUP = "Leves";
    private static final String MAIN_MEAL = "Főétel";
    private static final String DESSERT = "Desszert";

    private final FoodRepository foodRepository;

    /**
     * Visszaadja az összes levest az adatbázisból.
     */
    public List<Food> findAllSoups() {
        return foodRepository.findByType(SOUP);
    }

    /**
     * Visszaadja az összes főételt az adatbázisból.
     */
    public List<Food> findAllMainMeals() {
        return foodRepository.findByType(MAIN_MEAL);
    }

    /**
     * Visszaadja az összes desszertet az adatbázisból.
     */
    public List<Food> findAllDesserts() {
        return foodRepository.findByType(DESSERT);
    }

    /**
     * Megkeresi az ételt a megadott id alapján.
     */
    public Food findById(final Integer id) {
        return foodRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Food not found with id"));
    }
}
