package app.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Employer extends AbstractEntity{
    private String companyName;
    private String address;
    @ManyToMany
    private List<Customer> customers = new ArrayList<>();
}
