/**
 * Account model
 */
package com.example.indatacore.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AccountEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Double balance;
    private Double credit;

    public AccountEntity() {
        super();
    }

    public AccountEntity(Double balance, Double credit) {
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
