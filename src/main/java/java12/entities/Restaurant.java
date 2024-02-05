package java12.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.security.AlgorithmConstraints;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@ToString
@SequenceGenerator(name = "base_id_gen",sequenceName = "restaurant_seq",allocationSize = 1)
public class Restaurant extends BaseEntity{

    private String name;
    private String capacity;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    public Restaurant(String name, String capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}
