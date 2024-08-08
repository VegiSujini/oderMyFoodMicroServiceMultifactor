package com.example.RestaurantSearchService.Repository;

import com.example.RestaurantSearchService.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

     public List<Restaurant> findByLocation(String location);

    public List<Restaurant> findByDistance(int distance);
   public List<Restaurant> findByCuisine( String cuisine);
   public List<Restaurant>findByBudget(double budget);
   public List<Restaurant> findByRestaurantName(String restaurantName);
    public List< Restaurant> findByRestaurantId(Long rid);

}
