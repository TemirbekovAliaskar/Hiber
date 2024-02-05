package java12.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter @Setter
@NoArgsConstructor
@ToString
@SequenceGenerator(name = "base_id_gen",sequenceName = "customers_seq",allocationSize = 1)
public class Customer  extends BaseEntity{
    private String name;

    @OneToOne(mappedBy = "customer")
    private Reservation reservation;
    public Customer(String name) {
        this.name = name;
    }
}
