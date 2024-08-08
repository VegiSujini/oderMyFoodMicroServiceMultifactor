package com.example.RestaurantSearchService.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long restaurantId;
    private Long customerId;
    private String location;
    private int distance;
    private String cuisine;
    private double budget;
    private String restaurantName;

    public Restaurant(String location, int distance, String cuisine, double budget, String restaurantName) {
        this.location = location;
        this.distance = distance;
        this.cuisine = cuisine;
        this.budget = budget;
        this.restaurantName = restaurantName;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", location='" + location + '\'' +
                ", distance=" + distance +
                ", cuisine='" + cuisine + '\'' +
                ", budget=" + budget +
                ", restaurantName='" + restaurantName + '\'' +
                '}';
    }
}
