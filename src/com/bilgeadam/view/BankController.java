package com.bilgeadam.view;

import com.bilgeadam.Entity.Account;
import com.bilgeadam.Entity.Customer;
import com.bilgeadam.Services.CustomerService;
import com.bilgeadam.Services.LoginLogService;
import com.bilgeadam.Services.LoginServices;
import com.bilgeadam.Services.SingupService;

import java.util.Scanner;

public class BankController {


    public static Boolean loginScreen(){
        CustomerService customerService = new CustomerService();
        LoginServices loginServices = new LoginServices();
        Scanner scanner = new Scanner(System.in);
        String identityNumber;
        String password;
        PrintView.printIdentityNumber();
        identityNumber = scanner.nextLine();
        PrintView.printPassword();
        password = scanner.nextLine();
        Customer customer = customerService.findByIdentityNumber(identityNumber);
        Boolean result =loginServices.login(identityNumber,password);
        //TODO: Log servis Kayıt Oluşturacak.
        LoginLogService.loginLog(customer,result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String loginSelect;

        Boolean loginStatus;

        do {
            PrintView.selectLogin();
            loginSelect = scanner.nextLine();
            if(loginSelect.equals("1")){
                loginStatus = loginScreen();
                if(loginStatus){
                    transectionScreen();
                    System.out.println("Giriş Başarılı....");
                    break;
                }else{
                    System.out.println("Parola veya Şifreniz Hatalı");
                }
            }else if(loginSelect.equals("2")){
                singupCustomer();

            }else if(loginSelect.equalsIgnoreCase("q")){
                System.out.println("Program kapatılıyor....");
            }else{
                PrintView.printInvalidKey();
            }

        }while (!loginSelect.equalsIgnoreCase("q"));

    }
    private static void transectionScreen(){


    }
    private static void singupCustomer(){
        SingupService singupService = new SingupService();
        Customer customer;
        Boolean status;
        String exit;
        Scanner scanner = new Scanner(System.in);
        do {

            System.out.println("Kayıt oluşturmadan çıkmak için q basınız...");
            exit = scanner.nextLine();
            if(exit.equalsIgnoreCase("q")){
                status =true;
            }
            System.out.println("*************************************");
            System.out.println("Lütfen İsminizi giriniz: ");
            String name = scanner.nextLine();
            System.out.println("Lütfen Soyisminizi giriniz: ");
            String surname = scanner.nextLine();
            PrintView.printIdentityNumber();
            String identityNumber = scanner.nextLine();
            PrintView.printNewPassword();
            String newPassword = scanner.nextLine();
            PrintView.printReplayNewPassword();
            String replayPassword = scanner.nextLine();
            if(newPassword.equals(replayPassword)){
                customer = new Customer(name,surname,identityNumber,newPassword);
                singupService.singup(customer);
                status = true;
            }else{
                System.out.println("Paralo ve parola tekrarı uyuşmamaktır.");
                status = false;
            }

        }while (!status);
        }


}
