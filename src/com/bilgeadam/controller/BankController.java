package com.bilgeadam.controller;

import com.bilgeadam.Entity.Account;
import com.bilgeadam.Entity.Customer;
import com.bilgeadam.Services.CustomerService;
import com.bilgeadam.Services.LoginLogService;
import com.bilgeadam.Services.LoginServices;
import com.bilgeadam.Services.SingupService;
import com.bilgeadam.view.PrintView;

import java.util.Scanner;

import static com.bilgeadam.view.PrintView.singupScreen;

public class BankController {


    public static Boolean loginScreen(){
        CustomerService customerService = new CustomerService();
        LoginServices loginServices = new LoginServices();
        Scanner scanner = new Scanner(System.in);
        String identityNumber;
        String password;
        PrintView.printIdentityNumber();
        identityNumber = scanner.nextLine();
        PrintView.printEnterPassword();
        password = scanner.nextLine();
        Boolean result =loginServices.login(identityNumber,password);
        LoginLogService.loginLog(identityNumber,result);
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
                    break;
                }else{
                    PrintView.printInvalidPassword();
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

            PrintView.singupScreen();
            exit = scanner.nextLine();
            if(exit.equalsIgnoreCase("q")){
                status =true;
            }else{
                PrintView.enterName();
                String name = scanner.nextLine();
                PrintView.enterSurname();
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
                    PrintView.printInvalidPassword();
                    status = false;
                }
            }
        }while (!status);
        }


}
