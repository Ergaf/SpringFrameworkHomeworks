package app.entities.dto;

import app.entities.AbstractEntity;
import app.entities.Account;
import app.entities.Employer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class CustomerRes extends AbstractEntity {
    private String name;
    @JsonIgnore
    private String password;
    @Email
    private String email;
    private String phoneNumber;
    @Null
    private Integer age;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Customer_ID")
    private List<Account> accounts = new ArrayList<>();
    @ManyToMany
    private List<Employer> employers = new ArrayList<>();
}
