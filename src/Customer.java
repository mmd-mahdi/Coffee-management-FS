import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    String name ;
    String phoneNumber;
    ArrayList<Item> orderLog;

    public Customer() {
        this.orderLog = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name+"("+phoneNumber+")";
    }
    public String toData(){
//        for (Item item:orderLog
//             ) {
//
//        }
        String result = "[]";
        if (orderLog.isEmpty()) {
            return name+ "%" +phoneNumber + "%" + result;
        }else
            return name+ "%" +phoneNumber + "%" + orderLog;
    }
}
