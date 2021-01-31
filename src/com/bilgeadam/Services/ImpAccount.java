package com.bilgeadam.Services;

import com.bilgeadam.Entity.Account;
import com.bilgeadam.Entity.AccountActivity;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImpAccount implements IDataWrite<Account> {
    private static final String FILE_PATH ="Account.bin";


    @Override
    public List<Account> findAll() {
        List<Account> accountList = null;
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            accountList = (ArrayList<Account>) inputStream.readObject();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return accountList;

    }

    @Override
    public void save(Account account) {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))){
            List<Account> accountActivityList = findAll();
            if(accountActivityList !=null){
                accountActivityList.add(account);
            }else{
                accountActivityList = new ArrayList<>(Arrays.asList(account));
            }
            outputStream.writeObject(accountActivityList);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
