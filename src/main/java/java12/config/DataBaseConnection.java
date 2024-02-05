package java12.config;

import jakarta.persistence.EntityManagerFactory;
import java12.entities.Customer;
import java12.entities.Reservation;
import java12.entities.Restaurant;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class DataBaseConnection {
    public static EntityManagerFactory entityManagerFactory (){
        Properties properties = new Properties();
        properties.put(Environment.JAKARTA_JDBC_DRIVER, "org.postgresql.Driver");
        properties.put(Environment.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/admin");
        properties.put(Environment.JAKARTA_JDBC_USER, "postgres");
        properties.put(Environment.JAKARTA_JDBC_PASSWORD, "1234");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL, "true");
        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Restaurant.class);
        configuration.addAnnotatedClass(Reservation.class);
        configuration.addAnnotatedClass(Customer.class);
        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
    }
}
