import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<Restaurant>();

    public Restaurant findRestaurantByName(String restaurantName) throws RestaurantNotFoundException {
           ListIterator<Restaurant> iterator = restaurants.listIterator();
           while (iterator.hasNext()) {
               Restaurant restaurant = iterator.next();
               if (restaurant.getName().equalsIgnoreCase(restaurantName))
                   return restaurant;
           }
           throw new RestaurantNotFoundException("Error: Restaurant cound not be found");
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws RestaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
