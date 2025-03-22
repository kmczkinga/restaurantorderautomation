package hu.nye.it.RestaurantOrderAutomation.type.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Egy rendelés ábrázol az adatbázisban.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Orders {

    /**
     * Elsődleges kulcs. Táblába beszúráskor automatikusan generálódik.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Választott fizetőeszköz
     */
    private String paymentMethod;

    /**
     * Összesen fizetendő
     */
    private Integer total;

    /**
     * A rendelt ételek
     */
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderFood> foods = new ArrayList<>();

    /**
     * A lefoglalt asztalok
     */
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderTable> tables = new ArrayList<>();

    /**
     * El van-e már készítve, vagy sem. Ez csak a szakács oldalnak érdekes információ
     */
    private Boolean prepared;
}
