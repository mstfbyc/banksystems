package com.bilgeadam.Entity;

import com.bilgeadam.enums.LoginEnum;

import java.time.LocalDateTime;

public class LoginLog {
    private Account account;
    private LocalDateTime transactionTime;
    private LoginEnum loginStatus;

    public LoginLog() {
    }

    public LoginLog(Account account, LocalDateTime transactionTime, LoginEnum loginStatus) {
        this.account = account;
        this.transactionTime = transactionTime;
        this.loginStatus = loginStatus;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public LoginEnum getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(LoginEnum loginStatus) {
        this.loginStatus = loginStatus;
    }
}
