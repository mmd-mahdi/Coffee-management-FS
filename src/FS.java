// Java Program to Save a String to a File
// Using Files.write() method

// Importing required classes

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

// Main class
public class FS {
    private final Shop shop;

    private final String filePath;

    public FS(Shop shop, String filePath) {
        this.shop = shop;
        this.filePath = filePath;
    }
    public void  write(){
        writeDataString(dataToString());
    }
    public void read(){
        String dataString = readToString();

//        if (dataString.length()<=31)

            Queue<String> tokenizedData = getTokens(dataString,"&");
            ArrayList<Customer> customerList = customerListReader(tokenizedData.remove());
            Storage storage = storageReader(tokenizedData.remove());
            ArrayList<Item> log = stringToOrderLog(tokenizedData.remove());
            double salary = salaryReader(tokenizedData.remove());
            shop.setCustomers(customerList);
            shop.setStorage(storage);
            shop.setSalary(salary);
            shop.setOrderLog(log);



    }
    private String dataToString(){
        StringBuilder content = new StringBuilder();
        String customerString =customerDataTostring();
        content.append(customerString).append("&\n");
        String storageString = storageDataTostring();
        content.append(storageString).append("&\n");
        String salarySting =String.valueOf(shop.getSalary());
        String logString = logToString();
        content.append(logString).append("\n&\n");
        content.append(salarySting);
        return content.toString();
    }
    private String logToString(){
        if (shop.getOrderLog().isEmpty())
            return "[]";
        else
            return shop.getOrderLog().toString();
    }
    private String storageDataTostring(){
        StringBuilder result = new StringBuilder();
        ArrayList<Ingredient> storage = shop.getStorage().data;
        for (Ingredient ingredient: storage) {
            result.append(ingredient.toData()).append("\n");

        }
        return result.toString();
    }
    private String customerDataTostring(){
        StringBuilder result = new StringBuilder();
        ArrayList<Customer> customerList = shop.getCustomers();
        for (Customer customer: customerList) {

                result.append(customer.toData()).append("\n");

        }
      return result.toString();
    }

    private void writeDataString(String str) {
        Path path
                = Paths.get(filePath);

        // Custom string as an input


        // Converting string to byte array
        // using getBytes() method
        byte[] arr = str.getBytes();

        // Try block to check for exceptions
        try {
            // Now calling Files.write() method using path
            // and byte array
            Files.write(path, arr);
        }

        // Catch block to handle the exceptions
        catch (IOException ex) {
            // Print message as exception occurred when
            // invalid path of local machine is passed
            System.out.print("Invalid Path");
        }
    }


    private Storage storageReader(String input){
        Storage result = new Storage();
        Queue<String> tokenizedData = getTokens(input,"\n");
        for (Ingredient ingredient : result.data) {
            ingredient.setAmount(Double.parseDouble(tokenizedData.remove()));
        }
        return result;
        }
    private double salaryReader(String input){
        return Double.parseDouble(input);
    }
    private ArrayList<Customer> customerListReader(String input){
        ArrayList<Customer> customers = new ArrayList<>();
        Queue<String> tokenizedData = getTokens(input,"\n");
        //System.out.println(tokenizedData);
        for (String token:tokenizedData) {
            Queue<String> tempTable = getTokens(token,"%");
            Customer tempCustomer = new Customer();
            tempCustomer.name = tempTable.remove();
            tempCustomer.phoneNumber = tempTable.remove();
            tempCustomer.orderLog = stringToOrderLog(tempTable.remove());
            //System.out.println(tempCustomer);
            customers.add(tempCustomer);
           // System.out.println(customers);
        }
        return customers;
    }
    private ArrayList<Item> stringToOrderLog(String string){
        ArrayList<Item> result = new ArrayList<>();
        String temp =strip(string);

        //System.out.println(temp);
            Queue<String> tokenizedData = getTokens(temp,",");
            for (String str: tokenizedData) {
                if (!Objects.equals(str,"null")&&!Objects.equals(str,"")){
                    result.add(shop.getMenu().findNameInMenu(str));
                }
            }
           // result.remove(null);
            return result;


    }

    private   String  readToString(){
        Path path = Path.of(filePath);
        String fileContent = "";

        try {

            byte[] bytes = Files.readAllBytes(Paths.get(path.toUri()));
            fileContent = new String (bytes);


        } catch (IOException e) {

            //handle exception
        }
        return fileContent;
    }
    private Queue<String> getTokens(String str, String delim) {
        Queue<String> tokens = new LinkedList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, delim );
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }
        return tokens;
    }
    private  String strip(String str)
    {
        str = str.replaceAll("\\s+","");
        str = str.replaceAll("\\n+","");
        // Removing first and last character
        // of a string using substring() method
        str = str.substring(1, str.length() - 1);

        // Return the modified string
        return str;
    }
}
