package app.entities.dto;

import app.entities.AbstractEntity;
import app.entities.Account;
import app.entities.Employer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class CustomerReq {
    private String name;
    @JsonIgnore
    private String password;
    @Email
    private String email;
    private String phoneNumber;
    @Min(18)
    private Integer age;
    private List<Account> accounts = new ArrayList<>();
    private List<Employer> employers = new ArrayList<>();
}
