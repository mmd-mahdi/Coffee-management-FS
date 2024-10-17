import java.util.ArrayList;

public class Storage{
    ArrayList<Ingredient> data;

    public Storage() {
        data = new ArrayList<>();
        Ingredient coffee = new Ingredient("coffee",30000);
        Ingredient tea = new Ingredient("tea",4000);
        Ingredient sugar = new Ingredient("sugar",10000);
        Ingredient milk = new Ingredient("milk",10000);
        Ingredient chocolate = new Ingredient("chocolate",10);
        Ingredient cake = new Ingredient("cake",10);

        data.add(coffee);
        data.add(tea);
        data.add(sugar);
        data.add(milk);
        data.add(chocolate);
        data.add(cake);

    }
    public double buyIngredient(String ingredient ,double amount){
        switch (ingredient){
            case "coffee":
                data.get(0).increaseAmount(amount);
                return data.get(0).getCost() * amount;

            case "tea":
                data.get(1).increaseAmount(amount);
                return data.get(1).getCost() * amount;

            case "sugar":
                data.get(2).increaseAmount(amount);
                return data.get(2).getCost() * amount;

            case "milk":
                data.get(3).increaseAmount(amount);
                return data.get(3).getCost() * amount;

            case "chocolate":
                data.get(4).increaseAmount(amount);
                return data.get(4).getCost() * amount;

            case "cake":
                data.get(5).increaseAmount(amount);
                return data.get(5).getCost() * amount;

            default:
                System.out.println("no item matches '" + ingredient + "'");
                return 0;

        }
    }
    public void showStatus(){
        for (Ingredient ingredient: data){
            System.out.println(ingredient+ " : "+ingredient.getAmount());
        }
    }


}
