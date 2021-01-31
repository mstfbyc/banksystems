package com.bilgeadam.Services;

import com.bilgeadam.Entity.Account;
import com.bilgeadam.Entity.AccountActivity;
import com.bilgeadam.enums.AccountActivitiesEnum;
import com.bilgeadam.view.PrintView;

import java.time.LocalDateTime;

public class ActivityService {
    private IDataWrite iDataWrite;

    public ActivityService() {
        this.iDataWrite = new ImpAccountActivity();
    }

    public void depositMoney(Account account, Double amount){
        AccountActivity activity = new AccountActivity(LocalDateTime.now(), AccountActivitiesEnum.DEPOSIT,account,amount);
        account.setBalance(account.getBalance()+amount);
        iDataWrite.save(activity);
    }

    public void withdrawMoney(Account account, Double amount){
        AccountActivity activity = new AccountActivity(LocalDateTime.now(), AccountActivitiesEnum.WITHDRAW,account,amount);
        if(account.getBalance()>amount){
            account.setBalance(account.getBalance()-amount);
            iDataWrite.save(activity);
        }else{
            PrintView.printInsufficientBalance();
        }


    }
    public void moneyTransfer(Account senderAccount, Account receiverAcoount, Double amount){
        AccountActivity senderActivity = new AccountActivity(LocalDateTime.now(), AccountActivitiesEnum.TRANSFER,senderAccount,amount);
        AccountActivity receiverActivity = new AccountActivity(LocalDateTime.now(), AccountActivitiesEnum.DEPOSIT,senderAccount,amount);
        if(senderAccount.getBalance()>amount){
            senderAccount.setBalance(senderAccount.getBalance()-amount);
            receiverAcoount.setBalance(receiverAcoount.getBalance()+amount);
            iDataWrite.save(senderAccount);
            iDataWrite.save(receiverAcoount);
        }else{
            PrintView.printInsufficientBalance();
        }
    }

}
