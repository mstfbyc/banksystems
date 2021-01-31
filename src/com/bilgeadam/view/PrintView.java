package com.bilgeadam.view;

import com.bilgeadam.utils.ConsoleColors;

public class PrintView {
    public static final String TABLE_FRAME = "*********************************************************";
    public static final String TABLE_EMPTY_ROW = "*\t\t\t\t\t\t\t\t\t\t\t\t\t\t*";
    public static final String TABLE_ROW_START = "*\t\t";

    public static void selectLogin() {
        System.out.println(ConsoleColors.GREEN+TABLE_FRAME);
        System.out.println(ConsoleColors.GREEN+TABLE_EMPTY_ROW);
        System.out.println(ConsoleColors.GREEN+TABLE_ROW_START+ ConsoleColors.BLUE +"Giriş için"+ConsoleColors.RED+" 1"+ConsoleColors.GREEN+"\t\t\t\t\t\t\t\t\t*");
        System.out.println(ConsoleColors.GREEN+TABLE_EMPTY_ROW);
        System.out.println(ConsoleColors.GREEN+TABLE_ROW_START+ConsoleColors.BLUE+"Yeni Müsteri Kaydı için: " +ConsoleColors.RED+"2  "+ConsoleColors.GREEN+"\t\t\t\t\t*");
        System.out.println(ConsoleColors.GREEN+TABLE_EMPTY_ROW);
        System.out.println(ConsoleColors.GREEN+TABLE_ROW_START+ConsoleColors.BLUE+"Çıkış için : " +ConsoleColors.RED+"q  "+ConsoleColors.GREEN+"\t\t\t\t\t\t\t\t*");
        System.out.println(ConsoleColors.GREEN+TABLE_EMPTY_ROW);
        System.out.println(ConsoleColors.GREEN+TABLE_FRAME);
        System.out.print(ConsoleColors.BLUE+"Lütfen Yapmak istediğiniz işlemi seçiniz: ");

    }

    public static void singupScreen(){
        System.out.println(ConsoleColors.GREEN+TABLE_FRAME);
        System.out.println(ConsoleColors.GREEN+TABLE_EMPTY_ROW);
        System.out.println(ConsoleColors.GREEN+TABLE_ROW_START+ ConsoleColors.BLUE +"Kayıt oluşturmadan çıkmak için: "+ConsoleColors.RED+"q   "
                +ConsoleColors.GREEN+"\t\t\t*");
        System.out.println(ConsoleColors.GREEN+TABLE_EMPTY_ROW);
        System.out.println(ConsoleColors.GREEN+TABLE_FRAME);
        System.out.print(ConsoleColors.GREEN+"Çıkış için q devam etmek için ENTER basın: "+ConsoleColors.RED);
    }

    public static void enterName(){
        System.out.print(ConsoleColors.BLUE+"Lütfen isminizi giriniz:");
    }
    public static void enterSurname(){
        System.out.print(ConsoleColors.BLUE+"Lütfen soyisminizi giriniz:");
    }
    public static void login(){
        System.out.println(ConsoleColors.GREEN+TABLE_FRAME);
        System.out.println(ConsoleColors.RED+"Lütfen Giriş için bilgilerinisi doldudrun.");
    }
    public static void printIdentityNumber(){
        System.out.print(ConsoleColors.BLUE+"TC kimlik numaranızı giriniz:");
    }
    public static void printNewPassword(){
        System.out.print(ConsoleColors.BLUE+"Yeni Paralonuzu giriniz: ");
    }
    public static void printReplayNewPassword(){
        System.out.print(ConsoleColors.BLUE+"Yeni Paralonuzu tekrar giriniz giriniz: ");
    }
    public static void printInvalidPassword(){

        System.out.print(ConsoleColors.RED+"Paralo ve parola tekrarı uyuşmamaktır.\n");
    }
    public static void printInvalidKey(){
        System.out.println(ConsoleColors.RED+"Geçersiz bir tuşa bastınız....\n");
    }

    public static void printInvalidLogin(){
        System.out.println(ConsoleColors.RED+"Parola veya Şifreniz Hatalı");
    }

    public static void printEnterPassword(){
        System.out.print(ConsoleColors.BLUE+"Paralonuzu giriniz:");
    }

}
