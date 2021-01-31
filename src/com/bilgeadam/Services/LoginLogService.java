package com.bilgeadam.Services;

import com.bilgeadam.Entity.LoginLog;
import com.bilgeadam.enums.LoginEnum;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginLogService {
    private static final String LOG_FILE= "log.txt";

    public static void loginLog(String identityNumber, Boolean status){
        writeLogFile(identityNumber, status);
    }

    private List<LoginLog> readLogFile(){
        List<LoginLog> loginLogList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(LOG_FILE)))){

            while (scanner.hasNextLine()){
                LoginLog log = stringtoLoginLog(scanner.nextLine().split(";"));
                loginLogList.add(log);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loginLogList;
    }

    private static LoginLog stringtoLoginLog(String[] temp){
        LoginLog result = new LoginLog();
        result.setIdentityNumber(temp[0]);
        result.setTransactionTime(temp[1]);
        result.setLoginStatus(LoginEnum.findByCode(Integer.valueOf(temp[2])));
        return result;
    }

    private static void writeLogFile(String identityNumber, Boolean status){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String localDateTime = LocalDateTime.now().format(formatter);
        String logStatus;
        if(status){
            logStatus="1";
        }else{
            logStatus="0";
        }
        String log = identityNumber+";"+localDateTime+";"+logStatus+"\n";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE,true))){
            writer.write(log);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
