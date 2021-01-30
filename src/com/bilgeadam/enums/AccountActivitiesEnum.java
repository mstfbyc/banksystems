package com.bilgeadam.enums;

import java.util.Arrays;

public enum AccountActivitiesEnum {

    WITHDRAW("Para çekme",1),
    DEPOSIT("Para Yatırma",2),
    TRANSFER("EFT/HAVALE",3);

    String value;
    Integer code;

    public String getValue() {
        return value;
    }

    public Integer getCode() {
        return code;
    }

    AccountActivitiesEnum(String value, Integer code) {
        this.value = value;
        this.code = code;
    }

    public static AccountActivitiesEnum findByCode(Integer code){
        return Arrays.stream(values()).filter(value -> value.getCode().equals(code)).findFirst().orElse(null);
    }
}
