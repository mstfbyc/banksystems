package com.bilgeadam.Entity;

import com.bilgeadam.enums.AccountActivitiesEnum;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AccountActivity implements Serializable {

    private static final long serialVersionUID = -4181258601967045777L;
    private LocalDateTime transactionTime;
    private AccountActivitiesEnum transactionType;
    private Account account;
    private Double amount;

    public AccountActivity() {
    }

    public AccountActivity(LocalDateTime transactionTime, AccountActivitiesEnum transactionType, Account account, Double amount) {
        this.transactionTime = transactionTime;
        this.transactionType = transactionType;
        this.account = account;
        this.amount = amount;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public AccountActivitiesEnum getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(AccountActivitiesEnum transactionType) {
        this.transactionType = transactionType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Hesap Hareketi:" +
                "\t işlem Tarihi = " + transactionTime +
                ", işlem Tipi =" + transactionType.getValue() +
                ", Hesap=" + account +
                ", Tutar=" + amount;
    }
}
