package karma.lab6.task11;
import java.util.*;

public class MenuPlanner {
    private Map<String, List<Dish>> chefDishesMap;

    public MenuPlanner() {
        this.chefDishesMap = new HashMap<>();
    }

    public void addChef(String chef, List<Dish> dishes) {
        chefDishesMap.put(chef, dishes);
    }

    public void removeChef(String chef) {
        chefDishesMap.remove(chef);
    }

    public List<Dish> generateMenu(List<String> notAvailableIngredients, int maxDishes) {
        List<Dish> possibleDishes = new ArrayList<>();
        for (List<Dish> dishes : chefDishesMap.values()) {
            for (Dish dish : dishes) {
                if (!dish.getIngredients().contains(notAvailableIngredients)) {
                    possibleDishes.add(dish);
                }
            }
        }
        Collections.sort(possibleDishes, (d1, d2) -> {
            if (d1.getKingRating() != d2.getKingRating()) {
                return Integer.compare(d2.getKingRating(), d1.getKingRating());
            } else {
                return Integer.compare(d2.getCourtRating(), d1.getCourtRating());
            }
        });
        return possibleDishes.subList(0, Math.min(maxDishes, possibleDishes.size()));
    }

    public List<Dish> filterMenu(List<Dish> possibleDishs){
        Set<Dish> uniqueSet = new HashSet<>();
        List<Dish> todayMenu = new ArrayList<>();

        for (Dish dish : possibleDishs){
            if (!uniqueSet.contains(dish)){
                uniqueSet.add(dish);
                todayMenu.add(dish);
            }
        }
        return todayMenu;
    }
}