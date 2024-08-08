package com.example.RestaurantSearchService.ServiceImpl;

import com.example.RestaurantSearchService.Common.Order;
import com.example.RestaurantSearchService.Common.TransactionRequest;
import com.example.RestaurantSearchService.Common.TransactionResponse;
import com.example.RestaurantSearchService.Model.Restaurant;
import com.example.RestaurantSearchService.Repository.RestaurantRepository;
import com.example.RestaurantSearchService.Service.RestaurantService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
private RestaurantRepository restaurantRepository;
@Autowired
   private RestTemplate template;
private Logger log= LoggerFactory.getLogger(RestaurantServiceImpl.class);
    @Override
    public TransactionResponse createRestaurant(TransactionRequest request) throws JsonProcessingException {
        Restaurant restaurant=request.getRestaurant();
        Order order=request.getOrder();
        order.setRestaurantId(order.getRestaurantId());
        order.setOrderItemsName(order.getOrderItemsName());
        order.setQuantity(order.getQuantity());

        log.info("RestaurantService request : {}",new ObjectMapper().writeValueAsString(request));

        //rest call
    Order orderResponse=template.postForObject("http://ORDERMANAGEMENT-SERVICE/order/placingorder",order,Order.class);

        log.info("Order Service response from RestaurantService rest call : {}",new ObjectMapper().writeValueAsString(orderResponse));
        restaurantRepository.save(restaurant);
        assert orderResponse != null;
        return new TransactionResponse(restaurant,orderResponse.getOrderItemsName(),orderResponse.getQuantity(), orderResponse.getRestaurantId());
    }

    @Override
    public List<Restaurant> getRestaurantByLocation(String location) {

        return restaurantRepository.findByLocation(location);
    }

    @Override
    public List<Restaurant> getRestaurantByDistance(int distance) {
        return restaurantRepository.findByDistance(distance);
    }

    @Override
    public List<Restaurant> getRestaurantByCuisine(String cuisine) {
        return restaurantRepository.findByCuisine(cuisine);
    }

    @Override
    public List<Restaurant> getRestaurantByBudget(double budget) {
        return restaurantRepository.findByBudget(budget);
    }

    @Override
    public List<Restaurant> getRestaurantByName(String restaurantName) {
        return restaurantRepository.findByRestaurantName(restaurantName);
    }
    @Override
    public List<Restaurant> getRestaurantById(@PathVariable Long rid)
    {
        return restaurantRepository.findByRestaurantId(rid);
    }
}
