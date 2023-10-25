package src.Lab3.Taask5;

public class RobotVac extends Product {
    public RobotVac(String name, double price, String desc, int power, int battery) {
        super(name, price, desc, power);
    }

    private int battery;//время работы батареи в минутах

    public int getBatteryRuntime() {
        return battery;
    }

    public void setBatteryRuntime(int battery) {
        this.battery = battery;
    }

    @Override
    public void Charact() {
        super.Charact();
        System.out.println("Battery Runtime: " + battery + " minutes");
    }
}
