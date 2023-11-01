package karma.lab3.task5;

import java.math.BigDecimal;

public abstract class Product {// класс для наследования
    private String name;// название товара
    private BigDecimal price;// цена
    private String description;// описание
    private int power;// мощность

    public Product(String name, BigDecimal price, String description, int power) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.power = power;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void printFullDescription() {// вывод характеристик
        System.out.println("Product: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Description: " + description);
        System.out.println("Power: " + power);
    }
}