package com.example.RestaurantSearchService.Repository;

import com.example.RestaurantSearchService.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer,Long>{

   List<Customer> findByCustomerId(Long customerId);
}
