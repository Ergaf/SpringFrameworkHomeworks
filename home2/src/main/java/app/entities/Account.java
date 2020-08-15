package app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
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

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Account account = (Account) o;
//        return id == account.id &&
//                Double.compare(account.balance, balance) == 0 &&
//                Objects.equals(number, account.number) &&
//                currency == account.currency &&
//                Objects.equals(customer, account.customer);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, number, currency, balance, customer);
//    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", currency=" + currency +
                ", balance=" + balance +
//                ", customer=" + customer +
                '}';
    }
}
