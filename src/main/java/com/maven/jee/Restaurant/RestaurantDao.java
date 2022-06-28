
package com.maven.jee.Restaurant;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RestaurantDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    UserTransaction userTransaction;

    public List<Restaurant> getRestaurant() {
        return entityManager.createQuery("select menu FROM Restaurant menu", Restaurant.class).getResultList();
    }

    public Restaurant RestaurantWithId(int Id) {
        TypedQuery<Restaurant> req = entityManager.createQuery("select menu FROM Restaurant menu WHERE menu.id = :id", Restaurant.class);
        try {
            Restaurant Menu = req.setParameter("id", Id).getSingleResult();
            if (Menu == null) {
                return null;
            } else {
                return Menu;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public List<Restaurant>  getSpicy(){
        return entityManager.createQuery(" SELECT menu FROM Restaurant menu WHERE menu.spicy =true", Restaurant.class).getResultList();
       
    }
    public boolean addRestaurants(Restaurant restaurant) {
        try {
            userTransaction.begin();
            entityManager.persist(restaurant);
            userTransaction.commit();
            Logger.getGlobal().info(restaurant.toString());
            return true;
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
            return false;
        }
    }

    public boolean deleteRestaurants(int id) {
        try {
            userTransaction.begin();
            entityManager.remove(RestaurantWithId(id));
            userTransaction.commit();
            return true;
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
            return false;
        }
    }

    public boolean updateRestaurants(int id, Restaurant restaurants) {
        try {
            Restaurant restaurantVerif = RestaurantWithId(id);
            if (restaurantVerif == null) {
                return false;
            } else {
                if (restaurants.getTitle() != null) {
                    restaurantVerif.setTitle(restaurants.getTitle());
                }
                if (restaurants.getDescription() != null) {
                    restaurantVerif.setDescription(restaurants.getDescription());
                }
                if (restaurants.getPrice() != null) {
                    restaurantVerif.setPrice(restaurants.getPrice());
                }

                userTransaction.begin();
                entityManager.merge(restaurantVerif);
                userTransaction.commit();
                return true;
            }
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
            return false;
        }
    }
}
