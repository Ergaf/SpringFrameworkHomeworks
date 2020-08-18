package app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
public class Account extends AbstractEntity{
    private String number;
    private Currency currency;
    private Double balance = 0.0;
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
////    @JsonBackReference
//    private Customer customer;

    {
        number = UUID.randomUUID().toString();
    }
}
