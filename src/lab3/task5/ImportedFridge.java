package src.lab3.task5;

import java.math.BigDecimal;

public class ImportedFridge extends Fridge {

    public ImportedFridge(String name, BigDecimal price, String desc, int power, boolean freez, double FrTemp,
            boolean Guar, String country) {
        super(name, price, desc, power, freez, FrTemp);
        this.Guar = Guar;
        this.country = country;
    }

    private boolean Guar;// наличие гарантии для импортных товаров
    private String country;// страна производителя для импортных товаров

    public void setGuar(boolean Guar) {
        this.Guar = Guar;
    }

    public boolean getGuar() {
        return Guar;
    }

    void setCountry(String country) {
        this.country = country;
    }

    String getCountry() {
        return country;
    }

    @Override
    public void Charact() {
        super.Charact();
        System.out.println("Guarantee" + Guar);
        System.out.println("Country" + country);
    }

}
