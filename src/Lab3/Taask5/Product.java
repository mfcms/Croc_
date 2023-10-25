package src.Lab3.Taask5;

class Product {//класс для наследования
    private String name;//название товара
    private double price;//цена
    private String desc;//описание
    private int power;//мощность

    public Product(String name, double price, String desc, int power){
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.power = power;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    public void setPower(int power){
        this.power = power;
    }

    public int getPower(){
        return power;
    }

    public String getDesc(){
        return desc;
    }
    
    public void Charact(){//вывод характеристик
        System.out.println("Product: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Description: " + desc);
        System.out.println("Power: " + power);
    }
}