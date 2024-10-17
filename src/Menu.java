import java.util.ArrayList;
import java.util.Objects;

public class Menu {
    ArrayList<Item> data;

    public Menu() {
        this.data = new ArrayList<>();
        Item tea = new Item("tea",30000);
        Item espresso = new Item("espresso",35000);
        Item doubleEspresso = new Item("doubleEspresso",35000);
        Item latte = new Item("latte",75000);
        Item cake = new Item("caka" , 35000);
        Item mocha = new Item("mocha",70000);
        Item cappuccino = new Item("cappuccino",40000);

        data.add(tea);
        data.add(espresso);
        data.add(doubleEspresso);
        data.add(latte);
        data.add(cake);
        data.add(mocha);
        data.add(cappuccino);
    }
    @Override
    public String toString(){
        return data.toString() ;
    }
    public Item findNameInMenu(String str){
        Item result = null;
        for (Item item: data) {
            if (Objects.equals(item.name, str)){
                result =item;
                break;
            }
        }
        return result;
    }

}

