import java.util.ArrayList;

public class Item{
    String name;
    double price;
    ArrayList<Ingredient> ingredients;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString(){
        return name;
    }
    public String menuType(){
        return name + " ----- " + price ;
    }

}
