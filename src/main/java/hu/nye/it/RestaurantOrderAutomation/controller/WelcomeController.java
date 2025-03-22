package hu.nye.it.RestaurantOrderAutomation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Az üdvözlő oldal felöli hívások fogadásáért felelős.
 */
@Controller
@RequestMapping
public class WelcomeController {

    /**
     * Üdvözlő oldal betöltése.
     */
    @GetMapping
    public String welcome() {
        return "welcome";
    }
}