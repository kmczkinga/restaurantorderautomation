package hu.nye.it.RestaurantOrderAutomation.repository;

import hu.nye.it.RestaurantOrderAutomation.type.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

    /**
     * A megadott típus alapján adja vissza az ételeket.
     */
    List<Food> findByType(String type);
}
