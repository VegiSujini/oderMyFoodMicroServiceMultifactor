package com.example.RestaurantSearchService.ServiceImpl;


import com.example.RestaurantSearchService.Model.Customer;
import com.example.RestaurantSearchService.Repository.CustomerRepository;
import com.example.RestaurantSearchService.Service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerServiceImpl implements CustomerService {
@Autowired
public CustomerRepository customerRepository;


    @Override
    public Customer saveCustomer(Customer customer) {
        Customer customer1=customerRepository.save(customer);
        return customer1;
    }

    @Override
    public List<Customer> getCustomerById(Long id) {
        return customerRepository.findByCustomerId(id);
    }

}
