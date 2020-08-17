package app.controller;

import app.entities.Account;
import app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/account")
    List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @PostMapping("/accountReplenish")
    boolean replenishAccountBalance(@RequestBody Long id, @RequestBody Double sum){
        return accountService.replenishAccountBalance(id, sum);
    }

    @PostMapping("/accountTakeOff")
    boolean takeOffFromAccountBalance(@RequestBody Long id, @RequestBody Double sum){
        return accountService.takeOffFromAccountBalance(id, sum);
    }

    @PostMapping("/accountTransfer")
    boolean transferMoneyFromAccountToAccount(@RequestBody Long id1, @RequestBody Long id2, @RequestBody Double sum){
        return accountService.transferMoneyFromAccountToAccount(id1, id2, sum);
    }
}
