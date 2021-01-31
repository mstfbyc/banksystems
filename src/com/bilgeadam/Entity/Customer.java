package com.bilgeadam.Entity;

import java.io.Serializable;

public class Customer implements Serializable {

    private static final long serialVersionUID = -2361598587884738498L;
    private String name;
    private String surname;
    private String identityNumber;
    private String password;
    private Account account;


    public Customer() {
    }

    public Customer(String name, String surname, String identityNumber, String password) {

        this.name = name;
        this.surname = surname;
        this.identityNumber = identityNumber;
        this.password = password;
        setAccount(new Account(10_000.00,identityNumber));
    }

    public Customer(String name, String surname, String identityNumber, String password, Account account) {
        this.name = name;
        this.surname = surname;
        this.identityNumber = identityNumber;
        this.password = password;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
