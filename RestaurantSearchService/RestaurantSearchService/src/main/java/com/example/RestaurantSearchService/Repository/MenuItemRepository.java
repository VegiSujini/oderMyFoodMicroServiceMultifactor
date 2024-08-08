package com.example.RestaurantSearchService.Repository;

import com.example.RestaurantSearchService.Model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MenuItemRepository extends JpaRepository<MenuItem,Long> {

public List<MenuItem> findAllByRestaurantId(Long rid);

 MenuItem findByMenuName(@Param("restaurantName") String name);
}
