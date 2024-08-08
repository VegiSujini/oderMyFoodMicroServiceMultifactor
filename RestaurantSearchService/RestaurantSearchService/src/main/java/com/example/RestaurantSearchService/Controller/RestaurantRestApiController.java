package com.example.RestaurantSearchService.Controller;

import com.example.RestaurantSearchService.Common.TransactionRequest;
import com.example.RestaurantSearchService.Common.TransactionResponse;
import com.example.RestaurantSearchService.Model.Customer;
import com.example.RestaurantSearchService.Model.MenuItem;
import com.example.RestaurantSearchService.Model.Restaurant;
import com.example.RestaurantSearchService.ServiceImpl.CustomerServiceImpl;
import com.example.RestaurantSearchService.ServiceImpl.MenuItemServiceImpl;
import com.example.RestaurantSearchService.ServiceImpl.RestaurantServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantRestApiController {

    CustomerServiceImpl customerServiceImpl;

    RestaurantServiceImpl restaurantServiceImpl;
    MenuItemServiceImpl menuItemServiceImpl;

    public RestaurantRestApiController(CustomerServiceImpl customerServiceImpl, RestaurantServiceImpl restaurantServiceImpl, MenuItemServiceImpl menuItemServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
        this.restaurantServiceImpl = restaurantServiceImpl;
        this.menuItemServiceImpl = menuItemServiceImpl;
    }

    @PostMapping("/customer")
    public Customer registerCustomer(@RequestBody Customer customer)
    {
        return customerServiceImpl.saveCustomer(customer);
    }
    @GetMapping("/customer/{id}")
    public List<Customer> getCustomer(@PathVariable Long id)
    {
        return customerServiceImpl.getCustomerById(id);
    }
    @PostMapping("/restaurants")
    @ResponseStatus(value = HttpStatus.CREATED)
    public TransactionResponse createRestaurant(@RequestBody TransactionRequest request) throws JsonProcessingException//
    {

       return restaurantServiceImpl.createRestaurant(request);
    }
    @GetMapping("/restaurant/{rid}")
    public List<Restaurant> getRestaurants(@PathVariable Long rid)
    {
        return restaurantServiceImpl.getRestaurantById(rid);
    }
    @GetMapping("/location/{location}")
    public List<Restaurant> searchRestaurantByLocation(@PathVariable String location)
    {
        return restaurantServiceImpl.getRestaurantByLocation(location);
    }
    @GetMapping("/distance/{distance}")
    public  List<Restaurant> searchRestaurantByDistance(@PathVariable int distance)
    {
        return restaurantServiceImpl.getRestaurantByDistance(distance);
    }
    @GetMapping("/cuisine/{cuisine}")
    public List< Restaurant> searchRestaurantByCuisine(@PathVariable String cuisine)
    {
        return restaurantServiceImpl.getRestaurantByCuisine(cuisine);
    }
    @GetMapping("/budget/{budget}")
    public  List<Restaurant> searchRestaurantByBudget(@PathVariable double budget)
    {
        return restaurantServiceImpl.getRestaurantByBudget(budget);
    }
    @GetMapping("/restaurantName/{restaurantName}")
    public  List<Restaurant> searchRestaurantByName(@PathVariable String restaurantName)
    {
        return restaurantServiceImpl.getRestaurantByName(restaurantName);
    }


    @PostMapping("/restaurant/{rid}/menuItems")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MenuItem createMenuItem(@RequestBody MenuItem menuItem)
    {
       return  menuItemServiceImpl.createMenuItem(menuItem);
    }
    @GetMapping("/restaurant/{rid}/menuItems")
    public List<MenuItem> getMenuItems(@PathVariable Long rid)
    {
        return menuItemServiceImpl.findAllByRestaurantId(rid);
    }

}
