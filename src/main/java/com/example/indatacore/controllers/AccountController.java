/**
 * Account REST controller
 */
package com.example.indatacore.controllers;

import com.example.indatacore.dto.Account;
import com.example.indatacore.services.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(final AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/csv_accounts")
    List<Account> listAccounts(){
        return this.accountService.getAccountList();
    }


    @GetMapping("/accounts")
    List<Account> getAccounts(){
        return this.accountService.getAccounts();
    }

    @PostMapping("/create_account")
    Account createAccount(@RequestBody Account account){
        if (this.accountService.createAccount(account)){
            return account;
        }
        return null;
    }

    @PostMapping("/create_random_account")
    Account createRandomAccount(){
        Account account = new Account(new Random().nextDouble(), new Random().nextDouble());
        if (this.accountService.createAccount(account)){
            return account;
        }
        return null;
    }
}
