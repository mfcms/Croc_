package karma.lab3.task5;

import java.math.BigDecimal;

public abstract class Product {// класс для наследования
    private String name;// название товара
    private BigDecimal price;// цена
    private String desc;// описание
    private int power;// мощность
    private boolean Guar;// наличие гарантии для импортных товаров
    private String country;// страна производителя для импортных товаров

    public Product(String name, BigDecimal price, String desc, int power) { // не импортный товар
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.power = power;
    }

    public Product(String name, BigDecimal price, String desc, int power, boolean Guar, String country) {// импортный
                                                                                                         // товар
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.power = power;
        this.Guar = Guar;
        this.country = country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public String getDesc() {
        return desc;
    }

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

    public void Charact() {// вывод характеристик
        System.out.println("Product: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Description: " + desc);
        System.out.println("Power: " + power);
    }
}