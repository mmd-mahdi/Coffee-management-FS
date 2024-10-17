public class Ingredient {
    private String name;
    private double cost;
    private double amount = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Ingredient(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return name;
    }
    public String toData(){
        return String.valueOf(amount);
    }
    public void increaseAmount(double amount){
        setAmount(getAmount()+amount);
    }
}
