package com.example.RestaurantSearchService.Common;

import com.example.RestaurantSearchService.Model.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
    private Restaurant restaurant;
    private  String orderItemsName;
    private int quantity;
    private Long restaurantId;
}
