package java12.service;

import java12.entities.Customer;
import java12.entities.Reservation;

import java.time.LocalDate;
import java.util.SplittableRandom;

public interface ReservationService {
    String save (Reservation reservation);
    Reservation bronCustomer (Long id, Long customerId);


}
