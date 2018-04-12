package tarkvaratehnika.restaurant;

import org.springframework.stereotype.Service;
import tarkvaratehnika.foodCategory.FoodCategory;

import java.util.List;

@Service
public class RestaurantService {


    private RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        // here you can do some validations etc before saving the user
        return restaurantRepository.save(restaurant);
    }

    Restaurant addFoodCategory(FoodCategory foodCategory, Restaurant restaurant) {
        List<FoodCategory> foodCategories = restaurant.getFoodCategories();
        foodCategories.add(foodCategory);
        foodCategory.setRestaurant(restaurant);
        restaurant.setFoodCategories(foodCategories);
        return restaurantRepository.save(restaurant);
    }


    List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    Restaurant getRestaurantById(long restaurantId) {
        return restaurantRepository.findOne(restaurantId);
    }
}
