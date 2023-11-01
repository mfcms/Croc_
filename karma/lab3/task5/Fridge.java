package karma.lab3.task5;

import java.math.BigDecimal;

public class Fridge extends Product {
    private boolean freez;// есть ли морозилка
    private double FrTemp;// температура

    public Fridge(String name, BigDecimal price, String desc, int power, boolean freez, double FrTemp) {
        super(name, price, desc, power);
        this.freez = freez;
        this.FrTemp = FrTemp;
    }

    public boolean hasFreez() {
        return freez;
    }

    public void setFreezer(boolean freez) {
        this.freez = freez;
    }

    public double getFrTemp() {
        return FrTemp;
    }

    public void setFrTemp(double FrTemp) {
        this.FrTemp = FrTemp;
    }

    @Override
    public void Charact() {
        super.Charact();
        System.out.println("Has Freezer: " + freez);
        System.out.println("Freezer Temperature: " + FrTemp + "°C");
    }
}
