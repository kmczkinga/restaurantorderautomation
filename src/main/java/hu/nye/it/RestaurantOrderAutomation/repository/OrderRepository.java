package hu.nye.it.RestaurantOrderAutomation.repository;

import hu.nye.it.RestaurantOrderAutomation.type.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Adatbázis kommunikációt biztosít az Order táblával
 */
@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
}
