package app.facade.account;

import app.entities.Account;
import app.entities.dto.AccountRes;

public interface AccountResMap {
    Account dtoCResToCustomer(AccountRes accountRes);
    AccountRes customerToDtoRes(Account account);
}
