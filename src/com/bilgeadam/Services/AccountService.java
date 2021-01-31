package com.bilgeadam.Services;

import com.bilgeadam.Entity.Account;

import java.util.List;

public class AccountService {
    private static IDataWrite iDataWrite;

    public AccountService() {
        iDataWrite = new ImpAccount();
    }

    public Account findAccountByAccountNumber(String accountNumber){
        List<Account> accountList = iDataWrite.findAll();
        Account account = null;
        if(accountList !=null){
            account = accountList.stream().filter(a -> a.getAccountNumber().equals(accountNumber)).findFirst().orElse(null);
        }
        return account;
    }
}
