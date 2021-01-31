package com.bilgeadam.Services;

import com.bilgeadam.Entity.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerService {
    private  static IDataWrite iDataWrite ;

    public CustomerService() {
        iDataWrite = new ImpCustomer();
    }

    /**
     * TC Kimlik Numarası ile Müşteri bulup döner.
     * @param identityNumber
     * @return
     */
    public Customer findByIdentityNumber(String identityNumber){
        List<Customer> customerList = iDataWrite.findAll();
        Customer result = null;
        if(customerList !=null){
            result = customerList.stream().filter(c -> c.getIdentityNumber().equals(identityNumber)).findFirst().orElse(null);
        }
        return result;
    }

    public void save(Customer customer){
        iDataWrite.save(customer);
    }


}
