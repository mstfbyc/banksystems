package com.bilgeadam.controller;

import com.bilgeadam.Entity.Account;
import com.bilgeadam.Entity.AccountActivity;
import com.bilgeadam.Entity.Customer;
import com.bilgeadam.Services.*;
import com.bilgeadam.view.PrintView;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BankController {
    private  static Scanner scanner = new Scanner(System.in);
    private static CustomerService customerService = new CustomerService();
    private static ActivityService activityService = new ActivityService();
    private static AccountService accountService = new AccountService();
    private static ImpAccountActivity accountActivity = new ImpAccountActivity();


    public static LoginResult loginScreen(){

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
        return new LoginResult(result,identityNumber);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String loginSelect;

        Boolean loginStatus;

        do {
            PrintView.selectLogin();
            loginSelect = scanner.nextLine();
            if(loginSelect.equals("1")){
                LoginResult loginResult = loginScreen();
                if(loginResult.getStatus()){
                    transectionScreen(customerService.findByIdentityNumber(loginResult.identityNumber));
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
    private static void transectionScreen(Customer customer){
        Double amount;
        boolean status = true;

        do {
            PrintView.screenTransactionsList();
            String selected =scanner.nextLine();
            if(selected.equals("q")){
                status = false;
            }else if(selected.equals("1")){
                PrintView.screenDeposit();
                amount = scanner.nextDouble();
                activityService.depositMoney(customer.getAccount(),amount );
            }else if(selected.equals("2")){
                PrintView.screenWhitdraw();
                amount = scanner.nextDouble();
                activityService.withdrawMoney(customer.getAccount(),amount );
            }else if(selected.equals("3")){
                PrintView.screenTransferAmount();
                amount = scanner.nextDouble();
                PrintView.screenTransferAcccount();
                String indentityNumber = scanner.nextLine();
                Account sender =customer.getAccount();
                Account receiver = customerService.findByIdentityNumber(indentityNumber).getAccount();
                if(receiver !=null){
                    activityService.moneyTransfer(sender,receiver,amount);
                }else{
                    PrintView.screenInvalidTransferAccount();
                }
            }else if(selected.equals(("4"))){
                List<AccountActivity>  accountActivityList = accountActivity.findAll().stream()
                        .sorted(Comparator.comparing(AccountActivity::getTransactionTime)).collect(Collectors.toList());
                System.out.println();
                accountActivityList.stream().forEach(System.out::println);

            }else{
                PrintView.printInvalidKey();
            }
        }while (status);



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

        private void transactionsList(Customer customer){

        }

        public static class LoginResult{
        Boolean status;
        String identityNumber;

            public LoginResult(Boolean status, String identityNumber) {
                this.status = status;
                this.identityNumber = identityNumber;
            }

            public Boolean getStatus() {
                return status;
            }

            public void setStatus(Boolean status) {
                this.status = status;
            }

            public String getIdentityNumber() {
                return identityNumber;
            }

            public void setIdentityNumber(String identityNumber) {
                this.identityNumber = identityNumber;
            }
        }



}
