package app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Customer extends AbstractEntity{
    private String name;
    @JsonIgnore
    private String password;
    @Email
    private String email;
    private String phoneNumber;
    @Min(18)
    private Integer age;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Customer_ID")
//    @JsonManagedReference
    private List<Account> accounts = new ArrayList<>();
    @ManyToMany
    private List<Employer> employers = new ArrayList<>();
}
