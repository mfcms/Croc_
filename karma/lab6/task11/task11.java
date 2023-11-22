package karma.lab6.task11;
import java.util.*;

public class task11 {
    public static void main(String[] args) {
        MenuPlanner feastManager = new MenuPlanner();

        // создание блюд
        Dish dish1 = new Dish("Картофельное пюре", Arrays.asList("картофель", "масло", "соль"), Category.HOT, 90, 85);
        Dish dish2 = new Dish("Цезарь", Arrays.asList("салат", "курица", "помидоры", "соус"), Category.SNACK, 95, 90);
        Dish dish3 = new Dish("Тирамису", Arrays.asList("бисквит", "маскарпоне", "кофе", "какао"), Category.DESERT, 92, 88);

        // добавление поваров
        feastManager.addChef("Повар 1", Arrays.asList(dish1, dish2));
        feastManager.addChef("Повар 2", Arrays.asList(dish2, dish3));

        List<String> notAvailableIngredients = Arrays.asList("салат", "курица", "помидоры");
        int maxDishes = 2;
        List<Dish> menu = feastManager.generateMenu(notAvailableIngredients, maxDishes);
        List<Dish> finalMenu = feastManager.filterMenu(menu);

        // Вывод сгенерированного меню
        System.out.println("Generated Menu:");
        for (Dish dish : finalMenu) {
            System.out.println(dish.getName());
        }

        // Удаление повара и его блюд
        feastManager.removeChef("Повар 1");
    }
}