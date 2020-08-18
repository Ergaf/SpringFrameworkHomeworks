package app.facade.account;

import app.entities.Account;
import app.entities.Customer;
import app.entities.dto.AccountReq;
import app.entities.dto.CustomerReq;

public interface AccountReqMap {
    Account dtoCResToCustomer(AccountReq accountReq);
    AccountReq customerToDtoRes(Account account);
}
