/**
 * DTO :
 * Account class
 */
package com.example.indatacore.dto;

import java.io.Serializable;

public class Account implements Serializable {

    private Long id;
    private Double balance;
    private Double credit;

    public Account() {}

    public Account(Double balance, Double credit) {
        this.balance = balance;
        this.credit = credit;
    }

    public Long getId() {
        return id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

}


