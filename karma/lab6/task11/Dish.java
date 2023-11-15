package karma.lab6.task11;
import java.util.*;

public class Dish {
    String name;
    List<String> ingridients;
    Category type;
    int kingrating;
    int courtrating;
    
    
    public Dish (String name, List<String> ingridients, Category type, int kingrating, int courttrating){
        this.name = name;
        this.ingridients = ingridients;
        this.type = type;
        this.kingrating = kingrating;
        this.courtrating = courttrating;
    }
    
    public List<String> getIngredients(){
        return ingridients;
    }
    
    public void setIngredients(List<String> ingridietns){
        this.ingridients = ingridietns;
    }
    
    public String getName(){
        return name;
    }
    
    public int getKingRating() {
        return kingrating;
    }
    
    public void setKingRating(short kingrating) {
        this.kingrating = kingrating;
    }
    public int getCourtRating() {
        return courtrating;
    }

    public void setCourtRating(short courtrating) {
        this.courtrating = courtrating;
    }

}
