package karma.lab3.task5;

import java.math.BigDecimal;

public class ImportedRobotVac extends RobotVac {

    private boolean guarantee;// наличие гарантии для импортных товаров
    private String country;// страна производителя для импортных товаров

    public ImportedRobotVac(String name, BigDecimal price, String description, int power, int battery, boolean guarantee,
            String country) {
        super(name, price, description, power, battery);
        this.guarantee = guarantee;
        this.country = country;
    }

    public void setGuarantee(boolean guarantee) {
        this.guarantee = guarantee;
    }

    public boolean getGuarantee() {
        return guarantee;
    }

    void setCountry(String country) {
        this.country = country;
    }

    String getCountry() {
        return country;
    }

    @Override
    public void printFullDescription() {
        super.printFullDescription();
        System.out.println("Guarantee: " + guarantee);
        System.out.println("Country: " + country);
    }
}
