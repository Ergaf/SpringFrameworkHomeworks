package app.facade.account;

import app.entities.Account;
import app.entities.dto.AccountReq;

public interface AccountReqMap {
    Account dtoCResToCustomer(AccountReq accountReq);
    AccountReq customerToDtoRes(Account account);
}
