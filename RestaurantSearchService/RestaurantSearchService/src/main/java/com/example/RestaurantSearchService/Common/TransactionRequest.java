package com.example.RestaurantSearchService.Common;

import com.example.RestaurantSearchService.Model.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
    private Restaurant restaurant;
    private Order order;
}
