package com.bilgeadam.Entity;

import java.io.Serializable;

public class Account implements Serializable {

    private static final long serialVersionUID = -5132270605922318961L;
    private Double balance;
    private String accountNumber;

    public Account() {
    }

    public Account(Double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Hesap Bilgisi" +
                "\tBakiye=" + balance +
                "\t Hesap Numarası='" + accountNumber +
                '\n';
    }
}
