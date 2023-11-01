package karma.lab3.task5;

import java.math.BigDecimal;

public class Stove extends Product {

    public Stove(String name, BigDecimal price, String desc, int power, String fuel) {
        super(name, price, desc, power);
    }

    private String fuel;// тиип плиты(газовая, элкетрическая, индукционная)

    public String getFuelType() {
        return fuel;
    }

    public void setFuelType(String fuel) {
        this.fuel = fuel;
    }

    @Override
    public void Charact() {
        super.Charact();
        System.out.println("Fuel Type: " + fuel);
    }

}
