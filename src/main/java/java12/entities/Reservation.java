package java12.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@ToString
@SequenceGenerator(name = "base_id_gen",sequenceName = "reservation_seq",allocationSize = 1)
public class Reservation extends BaseEntity {
    private LocalDate date;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Customer customer;
    public Reservation(LocalDate date) {
        this.date = date;
    }
}
