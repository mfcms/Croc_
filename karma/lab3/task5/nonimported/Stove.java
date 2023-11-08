package karma.lab3.task5.nonimported;

import java.math.BigDecimal;

import karma.lab3.task5.Product;

public class Stove extends Product {

    public Stove(String name, BigDecimal price, String description, int power, String fuelType) {
        super(name, price, description, power);
        this.fuelType = fuelType;
    }

    private String fuelType; // тип плиты (газовая, элкетрическая, индукционная)

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuel) {
        this.fuelType = fuel;
    }

    @Override
    public void printFullDescription() {
        super.printFullDescription();
        System.out.println("Fuel Type: " + fuelType);
    }
}
