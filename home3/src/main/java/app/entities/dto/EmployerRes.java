package app.entities.dto;

import app.entities.AbstractEntity;
import app.entities.Customer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class EmployerRes extends AbstractEntity {
    private String companyName;
    private String address;
    private List<Customer> customers = new ArrayList<>();

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
