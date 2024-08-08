package com.example.RestaurantSearchService.ServiceImpl;

import com.example.RestaurantSearchService.Model.MenuItem;
import com.example.RestaurantSearchService.Repository.MenuItemRepository;
import com.example.RestaurantSearchService.Service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {
    @Autowired
    private MenuItemRepository menuItemRepository;

    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public List<MenuItem> findAllByRestaurantId(Long rid) {
        return menuItemRepository.findAllByRestaurantId(rid);
    }

    @Override
    public MenuItem createMenuItem(MenuItem menuItem) {

        return menuItemRepository.save(menuItem);
    }

    @Override
    public MenuItem findByMenuName(String menuName) {
        return menuItemRepository.findByMenuName(menuName);
    }


}
