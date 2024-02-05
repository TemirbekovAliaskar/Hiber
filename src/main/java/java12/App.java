package java12;

import java12.config.DataBaseConnection;
import java12.entities.Customer;
import java12.entities.Reservation;
import java12.entities.Restaurant;
import java12.service.CustomerService;
import java12.service.ReservationService;
import java12.service.RestaurantService;
import java12.service.impl.CustomerImpl;
import java12.service.impl.ReservationImpl;
import java12.service.impl.RestaurantImpl;

import java.time.LocalDate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
//        DataBaseConnection.entityManagerFactory();
        CustomerService customerService = new CustomerImpl();
        ReservationService reservationService = new ReservationImpl();
        RestaurantService restaurantService = new RestaurantImpl();

//        customerService.save(new Customer("Nurlan"));
//        reservationService.save(new Reservation(LocalDate.of(2024,11,30)));
        reservationService.bronCustomer(1L, 1L);
//        restaurantService.save(new Restaurant("Ala-Too","Bishkek"));
//        restaurantService.asSignCompanyToAddress(1L,1L);



    }
}
