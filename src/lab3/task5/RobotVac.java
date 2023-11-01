package src.lab3.task5;

import java.math.BigDecimal;

public class RobotVac extends Product {
    public RobotVac(String name, BigDecimal price, String desc, int power, int battery) {
        super(name, price, desc, power);
        this.battery = battery;
    }

    private int battery;// время работы батареи в минутах

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
