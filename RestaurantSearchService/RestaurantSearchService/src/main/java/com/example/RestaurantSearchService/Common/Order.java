package com.example.RestaurantSearchService.Common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long orderId;
    private Long restaurantId;
    private  String orderItemsName;
    private int quantity;

   public String getOrderItemsName()
    {
        return orderItemsName;
    }
    public int getQuantity()
    {
        return quantity;
    }

}
