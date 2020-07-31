package app.controller;

import app.entities.Account;
import app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/account")
    List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @PostMapping("/accountReplenish")
    boolean replenishAccountBalance(Long id, Double sum){
        return accountService.replenishAccountBalance(id, sum);
    }

    @PostMapping("/accountTakeOff")
    boolean takeOffFromAccountBalance(Long id, Double sum){
        return accountService.takeOffFromAccountBalance(id, sum);
    }

    @PostMapping("/accountTakeOff")
    boolean transferMoneyFromAccountToAccount(Long id1, Long id2, Double sum){
        return accountService.transferMoneyFromAccountToAccount(id1, id2, sum);
    }
}
