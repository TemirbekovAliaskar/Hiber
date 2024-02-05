package java12.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java12.config.DataBaseConnection;
import java12.entities.Customer;
import java12.entities.Reservation;
import java12.service.ReservationService;
import org.hibernate.HibernateException;

import java.time.LocalDate;

public class ReservationImpl implements ReservationService {
    EntityManagerFactory entityManagerFactory = DataBaseConnection.entityManagerFactory();

    @Override
    public String save(Reservation reservation) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(reservation);
            entityManager.getTransaction().commit();
        }catch (HibernateException e){
            if (entityManager.getTransaction().isActive())entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
        return "Saved !";
    }

    @Override
    public Reservation bronCustomer(Long id, Long customerId) {
        EntityManager entityManager  = entityManagerFactory.createEntityManager();
        Reservation reservation = null;
        try {
            entityManager.getTransaction().begin();
            reservation = entityManager.find(Reservation.class, id);
            Customer customer = entityManager.find(Customer.class,customerId);
            reservation.setCustomer(customer);
            entityManager.persist(reservation);
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        return reservation;
    }


}
