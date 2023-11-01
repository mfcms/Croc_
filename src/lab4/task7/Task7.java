package src.lab4.task7;

import java.time.LocalDateTime;

import src.lab3.task5.Fridge;
import src.lab3.task5.Product;
import src.lab3.task5.RobotVac;
import src.lab3.task5.Stove;

import java.math.BigDecimal;

public class Task7 {
    public class Main {
        public static void main(String[] args) throws Exception {
            Fridge fridge = new Fridge("Mini Fridge", new BigDecimal(22000.99), "A compact fridge", 220, false, -18);
            Stove stove = new Stove("Electric Stove", new BigDecimal(20000.99), "An electric stove", 220, "Electrical");
            RobotVac robot = new RobotVac("Smart Robot Vacuum", new BigDecimal(15000.99),
                    "An autonomous vacuum cleaner with smart features", 220, 120);
            Product[] products = { fridge, stove, robot };

            Order order1 = new Order("Matt Smith", "9216289764", LocalDateTime.of(2023, 10, 25, 15, 30, 12),
                    LocalDateTime.of(2023, 10, 26, 15, 30, 40),
                    LocalDateTime.of(2023, 10, 27, 10, 45, 20),
                    products);

            System.out.println(order1.getOrderNumber());
            System.out.println(order1.checkOrder(LocalDateTime.of(2023,11,1,10,20,11)));
        }
    }
}
