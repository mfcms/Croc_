package karma.lab3.task5.imported;

import java.math.BigDecimal;

import karma.lab3.task5.Import;
import karma.lab3.task5.nonimported.RobotVac;

public class ImportedRobotVac extends RobotVac implements Import{

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

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public void printFullDescription() {
        super.printFullDescription();
        System.out.println("Guarantee: " + guarantee);
        System.out.println("Country: " + country);
    }
}
