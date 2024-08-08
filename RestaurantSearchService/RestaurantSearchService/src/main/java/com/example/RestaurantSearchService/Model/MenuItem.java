package com.example.RestaurantSearchService.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long menuItemId;
    private Long restaurantId;
    private String menuName;
    private String description;
    private int price;

    public MenuItem(String menuName, String description, int price) {
        this.menuName = menuName;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "menuItemId=" + menuItemId +
              //  ", restaurantId=" + getRestaurantId() +
                ", menuName='" + menuName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}