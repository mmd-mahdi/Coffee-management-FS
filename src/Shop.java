import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Shop {
    private Storage storage ;
    private  final FS fs;
    private ArrayList<Customer> customers ;
    private double salary = 0;
    private Menu menu;
    private  ArrayList<Item>  orderLog;

    public ArrayList<Item> getOrderLog() {
        return orderLog;
    }

    public void setOrderLog(ArrayList<Item> orderLog) {
        this.orderLog = orderLog;
    }

    public Shop() {
        this.storage = new Storage();
        customers = new ArrayList<>();
        orderLog = new ArrayList<>();
        menu = new Menu();
        fs = new FS(this,"D:\\Programing\\java\\Coffee-Shop\\src\\customerList.txt");
    }
    public void  showSalary(){
        System.out.println("total salary : " + salary);
    }
    public void  showCustomerList(){
        int i =1;
        for (Customer  customer : customers) {
            System.out.println( i +" ) "+ customer);
            i++;
        }
    }
    public void showOrderLog(){
        System.out.println(orderLog);
    }
    public void  showMenu(){
        int i =1;
        for (Item  item : menu.data) {
            System.out.println( i +" ) "+ item.menuType());
            i++;
        }
    }
    public void  showStorage(){
        System.out.println("total salary : " + storage.data);
    }

    public Menu getMenu() {
        return menu;
    }

    public void open(){
        fs.read();
    }
    public void close(){
    }




    public  void addCustomer(String customerName ,String customerPhoneNumber ){
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
        customer.name = customerName;
        if (findCustomerByName(customer.name) == null) {
            customer.phoneNumber = customerPhoneNumber;
            customers.add(customer);
            fs.write();
        }else {
            System.out.println("this user name is already taken");
        }
    }
    public void deleteCustomer(String customerName){
        Customer customer = findCustomerByName(customerName);
        if (customerName!= null ){
            customers.remove(customer);
            fs.write();
        }else{
            System.out.println("customer not found");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void showCustomerInfo(String customerName) {
        Customer customer = findCustomerByName(customerName);
        customer.orderLog.remove(null);
        if (customer != null) {
            System.out.println("name : " + customer.name);
            System.out.println("phone number : " + customer.phoneNumber);
            System.out.println("orders : " + customer.orderLog);
        }else{
            System.out.println("customer not found");
        }
    }
    public void editCustomerInfo(String customerName,String selectedField,String newValue){
        Customer customer = findCustomerByName(customerName);

        switch (selectedField){
            case "name":
                customer.name = newValue;
                System.out.println("Customer name changed successfully");
                break;
            case "phoneNumber":
                customer.phoneNumber = newValue;
                System.out.println("Customer phone number changed successfully");
                break;
            default:
                System.out.println(" incorrect input");

        }
    }

    public void order(String customerName ,String chosenItem){
        Customer customer = findCustomerByName(customerName);
        Item orderedItem = menu.findNameInMenu(chosenItem);
        if (orderedItem != null){
            customer.orderLog.add(orderedItem);
            orderLog.add(orderedItem);
            setSalary(getSalary()+orderedItem.price);
            System.out.println(customer.name+ " orderd a \"" + orderedItem.name + "\" successfully" );
        }else {
            System.out.println("no item in menu matches ' " + chosenItem + " '");
        }


    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    private Customer findCustomerByName(String customerName){
        for (Customer customer: customers) {
            if (Objects.equals(customer.name, customerName))
                return customer;
        }
        return null;
    }


}
