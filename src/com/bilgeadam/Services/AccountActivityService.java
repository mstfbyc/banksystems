package com.bilgeadam.Services;

import com.bilgeadam.Entity.Account;

public class AccountActivityService {

    public void depositMoney(Account account, Double amount){
        account.setBalance(account.getBalance()+amount);

    }
    public void withdrawMoney(Double amount){

    }
    public void moneyTransfer(Double amount){

    }

}
