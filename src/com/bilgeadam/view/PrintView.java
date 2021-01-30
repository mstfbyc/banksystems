package com.bilgeadam.view;

public class PrintView {
    public static void selectLogin() {
        System.out.println("************************************");
        System.out.println("Giriş için 1 \nYeni Müsteri Kaydı için: 2 \n Çıkış için q'a basınız...");
    }
    public static void login(){
        System.out.println("************************************");
        System.out.println("Lütfen Giriş için bilgilerinisi doldudrun.");
    }
    public static void printIdentityNumber(){
        System.out.println("TC kimlik numaranızı giriniz: ");
    }

    public static void printPassword(){
        System.out.println("Paralonuzu giriniz: ");
    }

    public static void printNewPassword(){
        System.out.println("Yeni Paralonuzu giriniz: ");
    }
    public static void printReplayNewPassword(){
        System.out.println("Yeni Paralonuzu tekrar giriniz giriniz: ");
    }
    public static void printExitPressQ(){
        System.out.println("Paralonuzu giriniz: ");
    }
    public static void printInvalidKey(){
        System.out.println("Geçersiz bir tuşa bastınız....");
    }
}
