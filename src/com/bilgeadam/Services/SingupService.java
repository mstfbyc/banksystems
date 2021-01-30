package com.bilgeadam.Services;

import com.bilgeadam.Entity.Customer;

public class SingupService {
    private CustomerService customerService;
    public SingupService() {
        customerService = new CustomerService();
    }

    public void singup(Customer customer){
        Customer result = customerService.findByIdentityNumber(customer.getIdentityNumber());
        if(result ==null){
            customerService.save(customer);
        }else{
            System.out.println("Bu Kimlik numarasına ait bir müşteri kaydı bulunmaktadır.");
        }

    }
}
