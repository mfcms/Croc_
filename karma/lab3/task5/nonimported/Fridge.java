package karma.lab3.task5.nonimported;

import java.math.BigDecimal;

import karma.lab3.task5.Product;

public class Fridge extends Product {
    private boolean hasFreezer;// есть ли морозилка
    private double temperature;// температура

    public Fridge(String name, BigDecimal price, String description, int power, boolean hasFreezer, double temperature) {
        super(name, price, description, power);
        this.hasFreezer = hasFreezer;
        this.temperature = temperature;
    }

    public boolean getHasFreezer() {
        return hasFreezer;
    }

    public void setHasFreezer(boolean hasFreezer) {
        this.hasFreezer = hasFreezer;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public void printFullDescription() {
        super.printFullDescription();
        System.out.println("Inner Temperature: " + temperature + "°C");
        System.out.println("Has Freezer: " + hasFreezer);
    }
}
