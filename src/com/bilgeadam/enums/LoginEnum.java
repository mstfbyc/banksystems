package com.bilgeadam.enums;

import java.util.Arrays;

public enum LoginEnum {
    LOGIN_SUCCESSFUL("Başarılı",1),
    LOGIN_UNSUCCESSFUL("Başarısız",0);
    String value;
    Integer code;

    public String getValue() {
        return value;
    }

    public Integer getCode() {
        return code;
    }

    LoginEnum(String value, Integer code) {
        this.value = value;
        this.code = code;
    }

    public static LoginEnum findByCode(Integer code){
        return Arrays.stream(values()).filter(value -> value.getCode().equals(code)).findFirst().orElse(null);
    }
}
