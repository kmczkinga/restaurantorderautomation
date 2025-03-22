package hu.nye.it.RestaurantOrderAutomation.repository;

import hu.nye.it.RestaurantOrderAutomation.type.model.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Adatbázis kommunikációt biztosít a Tables táblával
 */
@Repository
public interface TableRepository extends JpaRepository<Tables, Integer> {
}
