/**
 * Mapping DTO with DAO using services
 */
package com.example.indatacore.services;

import com.example.indatacore.dto.Account;
import com.example.indatacore.entities.AccountEntity;
import com.example.indatacore.repositories.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Spring Boot will automatically call the run method which implemented from CommandLineRunner after the application context has been loaded.
@Service
public class AccountService implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final static Logger logger =LoggerFactory.getLogger(AccountService.class);
    private final List<Account> accountList = new ArrayList<>();

    public AccountService(final AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public boolean createAccount(Account account){
        AccountEntity accountEntity = new AccountEntity(account.getBalance(), account.getCredit());
        try {
            this.accountRepository.save(accountEntity);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public List<Account> getAccounts(){
        List<AccountEntity> accountEntities = this.accountRepository.findAll();
        return accountEntities.stream()
                .map(accountEntity -> new Account(accountEntity.getBalance(), accountEntity.getCredit()))
                .collect(Collectors.toList());
    }

    @Override
    public void run(String[] args) throws Exception {
        BufferedReader bfr = new BufferedReader(new FileReader("records.csv"));
        String line;
        while ((line = bfr.readLine()) != null){
            String[] account_infos = line.split(",");
            Account account = new Account(Double.valueOf(account_infos[0]), Double.valueOf(account_infos[1]));
            this.accountList.add(account);
        }
        logger.info("Csv file loaded.");
    }
}
