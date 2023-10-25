package src.Lab3.Taask5;

import java.util.Set;

class Fridge extends Product {
    private boolean freez;//есть ли морозилка
    private double FrTemp;//температура
    public Fridge(String name, double price, String desc, int power, boolean freez, double FrTemp) {
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
    
