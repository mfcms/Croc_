package karma.lab3.task5;

import java.math.BigDecimal;

public class RobotVac extends Product {
    public RobotVac(String name, BigDecimal price, String description, int power, int batteryRuntime) {
        super(name, price, description, power);
        this.batteryRuntime = batteryRuntime;
    }

    private int batteryRuntime;// время работы батареи в минутах

    public int getBatteryRuntime() {
        return batteryRuntime;
    }

    public void setBatteryRuntime(int batteryRuntime) {
        this.batteryRuntime = batteryRuntime;
    }

    @Override
    public void printFullDescription() {
        super.printFullDescription();
        System.out.println("Battery Runtime: " + batteryRuntime + " minutes");
    }
}
