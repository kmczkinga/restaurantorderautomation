package hu.nye.it.RestaurantOrderAutomation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantOrderAutomationApplication {

       /**
        * Main függvény.
        * Elindítás után lefuttatja a /resources/schema.sql és /resources/data.sql fájlokat
        */
	public static void main(String[] args) {
		SpringApplication.run(RestaurantOrderAutomationApplication.class, args);
	}

}
