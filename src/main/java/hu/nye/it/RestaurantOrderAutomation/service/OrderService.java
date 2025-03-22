package hu.nye.it.RestaurantOrderAutomation.service;

import hu.nye.it.RestaurantOrderAutomation.repository.OrderRepository;
import hu.nye.it.RestaurantOrderAutomation.type.model.OrderFood;
import hu.nye.it.RestaurantOrderAutomation.type.model.OrderTable;
import hu.nye.it.RestaurantOrderAutomation.type.model.Orders;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Rendeléssel kapcsolatos logikák
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;


    /**
     * Beállítja az Orders.foods és .tables-nek az Order-t. Majd elmenti az Order-t
     * Ez a OneToMany kapcsolat miatt fontos. Nélküle error.
     */
    public Orders save(final Orders orders) {
        for (OrderFood orderFood : orders.getFoods()) {
            orderFood.setOrder(orders);
        }

        for (OrderTable orderTable : orders.getTables()) {
            orderTable.setOrder(orders);
        }
        return orderRepository.save(orders);
    }


    /**
     * Visszaadja az ordert a megadott id alapján. Ha nem találja, akkor runtimeexceptiont dob.
     */
    public Orders load(final Integer orderId) {
        return orderRepository.findById(orderId).orElseThrow(RuntimeException::new);
    }


    /**
     * Visszaadja az összes ordert.
     */
    public List<Orders> list() {
        return orderRepository.findAll();
    }


    /**
     * Lekéri a megadott id-vel rendelkező ordert, és ha van ilyen, akkor átteszi elkészített állapotba.
     */
    public void setPrepared(final Integer orderId) {
        final Optional<Orders> ordersOptional = orderRepository.findById(orderId);
        if (ordersOptional.isPresent()) {
            final Orders order = ordersOptional.get();
            order.setPrepared(true);
            orderRepository.save(order);
        }
    }


    /**
     * Kitörli a megadott id-vel rendelkező ordert.
     */
    public void delete(final Integer orderId) {
        orderRepository.deleteById(orderId);
    }
}
