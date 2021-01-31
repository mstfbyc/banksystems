package com.bilgeadam.Services;

import com.bilgeadam.Entity.AccountActivity;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImpAccountActivity implements IDataWrite<AccountActivity>{
    private static final String FILE_PATH ="accountActivities.bin";
    @Override
    public List<AccountActivity> findAll() {
        List<AccountActivity> accountActivityList = null;
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            accountActivityList = (ArrayList<AccountActivity>) inputStream.readObject();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return accountActivityList;

    }

    @Override
    public void save(AccountActivity accountActivity) {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))){
            List<AccountActivity> accountActivityList = findAll();
            if(accountActivityList !=null){
                accountActivityList.add(accountActivity);
            }else{
                accountActivityList = new ArrayList<>(Arrays.asList(accountActivity));
            }
            outputStream.writeObject(accountActivityList);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
