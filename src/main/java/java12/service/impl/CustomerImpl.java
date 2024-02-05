package java12.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java12.config.DataBaseConnection;
import java12.entities.Customer;
import java12.service.CustomerService;
import org.hibernate.HibernateException;

public class CustomerImpl implements CustomerService {
    EntityManagerFactory entityManagerFactory = DataBaseConnection.entityManagerFactory();
    @Override
    public String save(Customer customer) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
        }catch (HibernateException e){
            if (entityManager.getTransaction().isActive())entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
        return customer.getName();
    }


}
