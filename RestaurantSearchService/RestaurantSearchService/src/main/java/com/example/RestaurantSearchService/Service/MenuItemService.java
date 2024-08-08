package com.example.RestaurantSearchService.Service;

import com.example.RestaurantSearchService.Model.MenuItem;

import java.util.List;

public interface MenuItemService{
    List<MenuItem> findAllByRestaurantId(Long rid);
  MenuItem createMenuItem(MenuItem menuItem);
    MenuItem findByMenuName(String name);

}
