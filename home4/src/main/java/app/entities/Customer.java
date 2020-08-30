package app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Getter
//@Setter
//@ToString
public class Customer extends AbstractEntity{
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private Integer age;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Customer_ID")
//    @JsonManagedReference
    private List<Account> accounts = new ArrayList<>();
    @ManyToMany
    private List<Employer> employers = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(List<Employer> employers) {
        this.employers = employers;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                ", accounts=" + accounts +
                ", employers=" + employers +
                ", id=" + id +
                ", createdDate='" + createdDate + '\'' +
                ", lastModifiedDate='" + lastModifiedDate + '\'' +
                '}';
    }
}
