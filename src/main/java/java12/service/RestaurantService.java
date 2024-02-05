package java12.service;

import java12.entities.Restaurant;

public interface RestaurantService {
    String save (Restaurant restaurant);
    String asSignCompanyToAddress(Long restId, Long reserId);
}
