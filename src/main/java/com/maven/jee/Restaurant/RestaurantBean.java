package com.maven.jee.Restaurant;
import javax.ejb.*;
import javax.inject.Inject;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)

public class RestaurantBean {
    @Inject
    private RestaurantDao restaurantsDao;

    public List<Restaurant> getRestaurant() {
        return restaurantsDao.getRestaurant();
    }
    public List<Restaurant> getSpicy() {
        return restaurantsDao.getSpicy();
    }

    public boolean addRestaurants(Restaurant restaurants) {
        return restaurantsDao.addRestaurants(restaurants);
    }

    public boolean updateRestaurant(int id, Restaurant restaurants) {
        return restaurantsDao.updateRestaurants(id, restaurants);
    }

    public boolean deleteRestaurants(int id) {
        return restaurantsDao.deleteRestaurants(id);
    }
}




