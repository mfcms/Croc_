package src.Lab3.Taask5;

public class Task5 {
    public class Main {
        public static void main(String[] args) {
            //создание экземпляров товаров
            Fridge fridge = new Fridge("Mini Fridge", 22000.99, "A compact fridge", 220, false, -18);
            Stove stove = new Stove("Electric Stove", 20000.99, "An electric stove", 220, "Electrical");
            RobotVac robot  = new RobotVac("Smart Robot Vacuum", 15000.99, "An autonomous vacuum cleaner with smart features", 220, 120);
    
            //создание массива с позициями товаров
            Product[] products = {fridge, stove, robot};
    
            //вывод характеристик каждого товара
            for (Product product : products) {
                product.Charact();
                System.out.println();
            }
        }
    }
    
}
