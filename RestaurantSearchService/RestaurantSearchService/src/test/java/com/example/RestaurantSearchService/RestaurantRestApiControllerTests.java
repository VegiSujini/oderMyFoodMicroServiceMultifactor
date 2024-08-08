package com.example.RestaurantSearchService;

import com.example.RestaurantSearchService.Model.Customer;
import com.example.RestaurantSearchService.Model.MenuItem;
import com.example.RestaurantSearchService.Model.Restaurant;
import com.example.RestaurantSearchService.Repository.CustomerRepository;
import com.example.RestaurantSearchService.Repository.MenuItemRepository;
import com.example.RestaurantSearchService.Repository.RestaurantRepository;
import com.example.RestaurantSearchService.ServiceImpl.CustomerServiceImpl;
import com.example.RestaurantSearchService.ServiceImpl.MenuItemServiceImpl;
import com.example.RestaurantSearchService.ServiceImpl.RestaurantServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)

public class RestaurantRestApiControllerTests {

    @Autowired
    private CustomerServiceImpl customerServiceimpl;
    @MockBean
    private CustomerRepository customerRepository;

    @Test
    public void registerCustomerTest()
    {
        Customer customer=new Customer("sujini","sujini@gmail.com","vegi");
        when(customerRepository.save(customer)).thenReturn(customer);
        assertEquals(customer,customerServiceimpl.saveCustomer(customer));
    }
    @Test
    public  void getCustomerByIdTest()
    {
        Long customerId= 25L;
        when(customerRepository.findByCustomerId(customerId)).thenReturn(Stream.of(new Customer("sujini","sujini@gmail.com","vegi")).collect(Collectors.toList()));

        assertEquals(1,customerServiceimpl.getCustomerById(customerId).size());
    }


    @Autowired
    private RestaurantServiceImpl restaurantServiceimpl;
    @MockBean
    private RestaurantRepository restaurantRepository;

    @Test
    public void getRestaurantsTest()
    {
        Long restaurantId= 100L;
        when(restaurantRepository.findByRestaurantId(restaurantId)).thenReturn(Stream.of(new Restaurant("Rajampet",100,"Italian",1000,"New Grand Arya"))
                .collect(Collectors.toList()));
        assertEquals(1,restaurantServiceimpl.getRestaurantById(restaurantId).size());
    }
    @Test
    public  void searchRestaurantByLocationTest()
    {
        String location="rajampet";
        when(restaurantRepository.findByLocation(location)).thenReturn(Stream.of(new Restaurant("Rajampet",100,"Italian",1000,"New Grand Arya"))
                .collect(Collectors.toList()));
        assertEquals(1,restaurantServiceimpl.getRestaurantByLocation(location).size());
    }

    @Test
    public  void searchRestaurantByDistanceTest()
    {
        int distance=100;
        when(restaurantRepository.findByDistance(distance)).thenReturn(Stream.of(new Restaurant("Rajampet",100,"Italian",1000,"New Grand Arya"))
                .collect(Collectors.toList()));
        assertEquals(1,restaurantServiceimpl.getRestaurantByDistance(distance).size());
    }
    @Test
    public  void searchRestaurantByCuisineTest()
    {
        String cuisine="Indian";
        when(restaurantRepository.findByCuisine(cuisine)).thenReturn(Stream.of(new Restaurant("Rajampet",100,"Italian",1000,"New Grand Arya"))
                .collect(Collectors.toList()));
        assertEquals(1,restaurantServiceimpl.getRestaurantByCuisine(cuisine).size());
    }
    @Test
    public  void searchRestaurantByBudgetTest()
    {
        double budget=1000;
        when(restaurantRepository.findByBudget(budget)).thenReturn(Stream.of(new Restaurant("Rajampet",100,"Italian",1000,"New Grand Arya"))
                .collect(Collectors.toList()));
        assertEquals(1,restaurantServiceimpl.getRestaurantByBudget(budget).size());
    }
    @Test
    public  void searchRestaurantByNameTest()
    {
        String name="KFC";
        when(restaurantRepository.findByRestaurantName(name)).thenReturn(Stream.of(new Restaurant("Rajampet",100,"Italian",1000,"New Grand Arya"))
                .collect(Collectors.toList()));
        assertEquals(1,restaurantServiceimpl.getRestaurantByName(name).size());
    }


    @MockBean
    private MenuItemRepository menuItemRepository;
    @Autowired
    private MenuItemServiceImpl menuItemServiceImpl;

    @Test
    public void getMenuItemsTest()
    {
        Long restaurantId= 100L;
        when(menuItemRepository.findAllByRestaurantId(restaurantId)).thenReturn(Stream.of(new MenuItem("Starters","Both veg and nonveg",1000))
                .collect(Collectors.toList()));
        assertEquals(1,menuItemServiceImpl.findAllByRestaurantId(restaurantId).size(),"Is Ok");
    }

    @Test
    public void createMenuItemTest()
    {
        MenuItem menuItem=new MenuItem("Starters","Both veg and nonveg",1000);

        when(menuItemRepository.save(menuItem)).thenReturn(menuItem);
        assertEquals(menuItem,menuItemServiceImpl.createMenuItem(menuItem));
    }
}
