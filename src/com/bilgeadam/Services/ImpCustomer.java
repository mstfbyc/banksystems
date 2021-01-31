package com.bilgeadam.Services;

import com.bilgeadam.Entity.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImpCustomer implements IDataWrite<Customer>{

    public List<Customer> findAll(){
        List<Customer> customerList = null;
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Customer.bin"))) {
            customerList = (ArrayList<Customer>) inputStream.readObject();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return customerList;
    }
    public void save(Customer customer){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Customer.bin"))){
            List<Customer> customerList = findAll();
            if(customerList !=null){
                customerList.add(customer);
            }else{
                customerList = new ArrayList<>(Arrays.asList(customer));
            }
            outputStream.writeObject(customerList);


        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
