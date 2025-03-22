package hu.nye.it.RestaurantOrderAutomation.repository;

import hu.nye.it.RestaurantOrderAutomation.type.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Adatbázis kommunikációt biztosít a Payment táblával
 */
@Repository
public interface PaymentRepository extends JpaRepository<PaymentMethod, Integer> {
}
