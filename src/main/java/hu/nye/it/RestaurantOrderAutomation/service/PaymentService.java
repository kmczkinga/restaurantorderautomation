package hu.nye.it.RestaurantOrderAutomation.service;

import hu.nye.it.RestaurantOrderAutomation.repository.PaymentRepository;
import hu.nye.it.RestaurantOrderAutomation.type.model.PaymentMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * Fizetési eszközzel kapcsolatos logikák
 */
@Service
@RequiredArgsConstructor
public class PaymentService {

    private final OrderStore orderStore;

    private final PaymentRepository paymentRepository;


    /**
     * Visszaadja az összes fizetőeszköz lehetőséget.
     */
    public List<PaymentMethod> getPaymentMethods() {
        return paymentRepository.findAll();
    }

    /**
     * Beállítja az orderStoreban a kiválasztott fizetőeszközt.
     */
    public void selectPaymentMethod(int paymentId) {
        Optional<PaymentMethod> paymentMethodOptional = paymentRepository.findById(paymentId);
        paymentMethodOptional.ifPresent(orderStore::setPaymentMethod);
    }
}
