package java12.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java12.config.DataBaseConnection;
import java12.entities.Reservation;
import java12.entities.Restaurant;
import java12.service.RestaurantService;
import org.hibernate.HibernateException;

public class RestaurantImpl implements RestaurantService {
    EntityManagerFactory entityManagerFactory = DataBaseConnection.entityManagerFactory();

    @Override
    public String save(Restaurant restaurant) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(restaurant);
            entityManager.getTransaction().commit();
        }catch (HibernateException e){
            if (entityManager.getTransaction().isActive())entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
        return "Saved !";
    }

    public String asSignCompanyToAddress(Long restId, Long reserId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Restaurant restaurant = entityManager.find(Restaurant.class, restId);
        Reservation reservation = entityManager.find(Reservation.class, reserId);
        restaurant.getReservations().add(reservation);
        entityManager.merge(restaurant);
        entityManager.getTransaction().commit();
        entityManager.close();

        return "Successful! ";
    }
}
