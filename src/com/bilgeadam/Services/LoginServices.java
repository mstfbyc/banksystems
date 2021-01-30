package com.bilgeadam.Services;

import com.bilgeadam.Entity.Customer;

public class LoginServices {
    CustomerService customerService;

    public LoginServices() {
        customerService = new CustomerService();
    }

    /**
     * Burası Account.bin Dosyasından okur. Password ve TC kimlik Eşleşiyorsa True döner
     * @param identityNumber
     * @param password
     * @return
     */
    public Boolean login(String identityNumber, String password){

        Customer customer = customerService.findByIdentityNumber(identityNumber);
        if(customer !=null && identityNumber.equals(customer.getIdentityNumber()) && password.equals(customer.getPassword())){
            return true;
        }
        return false;
    }
}
