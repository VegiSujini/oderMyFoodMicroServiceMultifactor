package com.example.RestaurantSearchService.Service;

import com.example.RestaurantSearchService.Model.Customer;


import java.util.List;

public interface CustomerService {

    public Customer saveCustomer(Customer customer);


   List<Customer> getCustomerById(Long id);
}
