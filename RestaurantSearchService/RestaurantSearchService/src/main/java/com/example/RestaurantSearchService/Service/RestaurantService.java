package com.example.RestaurantSearchService.Service;

import com.example.RestaurantSearchService.Common.TransactionRequest;
import com.example.RestaurantSearchService.Common.TransactionResponse;
import com.example.RestaurantSearchService.Model.Restaurant;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface RestaurantService {
    TransactionResponse createRestaurant(TransactionRequest request) throws JsonProcessingException;
    List< Restaurant> getRestaurantById(Long rid);
   List< Restaurant> getRestaurantByLocation(String location);
    List< Restaurant> getRestaurantByDistance(int distance);
    List< Restaurant> getRestaurantByCuisine(String cuisine);
    List<Restaurant> getRestaurantByBudget(double budget);
    List< Restaurant> getRestaurantByName(String restaurantName);
}
