package com.bilgeadam.Entity;

import com.bilgeadam.enums.LoginEnum;

import java.time.LocalDateTime;

public class LoginLog {
    private String identityNumber;
    private String transactionTime;
    private LoginEnum loginStatus;

    public LoginLog() {
    }

    public LoginLog(String identityNumber, String transactionTime, LoginEnum loginStatus) {
        this.identityNumber = identityNumber;
        this.transactionTime = transactionTime;
        this.loginStatus = loginStatus;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public LoginEnum getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(LoginEnum loginStatus) {
        this.loginStatus = loginStatus;
    }
}
