package app.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity{
    private String companyName;
    private String address;
    @ManyToMany
    private List<Customer> customers = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Employer{" +
                "companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", customers=" + customers +
                ", id=" + id +
                '}';
    }
}
