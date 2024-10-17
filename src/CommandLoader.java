import java.util.*;


public class CommandLoader {
    public CommandLoader(Shop shop) {
        this.shop = shop;

        //this.eventHandler = new EventHandler(shop,customers);
    }
    //private final EventHandler eventHandler;

    private Shop shop ;
    boolean terminalState = true;
    private   Queue<String> getTokens(String str) {
        Queue<String> tokens = new LinkedList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, " ");
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }
        return tokens;
    }
    public void commandTerminal(){
        Scanner scanner = new Scanner(System.in);
//        FS fs = new FS(this,"D:\\Programing\\java\\Coffee-Shop\\src\\customerList.txt");
//        fs.read();
        while (terminalState){
            System.out.print(">>>");
            String command = scanner.nextLine();
            Queue<String> commandQueue = getTokens(command);
            commandReader(commandQueue);
        }

    }
    private void commandReader(Queue<String> commandQueue){

        String token =commandQueue.remove();

        switch (token){
            case "shop":
                shopCommand(commandQueue);
                break;
            case "customer":
                customerCommand(commandQueue);
                break;
            case "storage":
                storageCommand(commandQueue);
                break;
            default:
                System.out.println("'" + token +"' is not recognized as a command"  );
        }
    }
    public  void shopCommand(Queue<String> commandQueue){
        String token =commandQueue.remove();
        switch (token){
            case "salary":
                shop.showSalary();
                break;
            case "menu":
                shop.showMenu();
                break;
            case "customerList":
                shop.showCustomerList();
                break;
            case "orderLog":
                shop.showOrderLog();
                break;
            case "open":
                System.out.println("project by Mohammad Mahdi Mostofian Zadeh \n" +
                        "and \n" +
                        "Seyedeh Faezeh Hashemi");
                shop.open();
                break;
            case "close":
                shop.close();
                terminalState = false;
                shop.showSalary();
                break;
            default:
                System.out.println("'" + token +"' is not recognized as a command"  );

        }

    }
    public  void customerCommand(Queue<String> commandQueue){
        String token =commandQueue.remove();
        switch (token){
            case "add":
                shop.addCustomer(commandQueue.remove(),commandQueue.remove());
                break;
            case "edit":
                shop.editCustomerInfo(commandQueue.remove(),commandQueue.remove(),commandQueue.remove());
                break;
            case "delete":
                shop.deleteCustomer(commandQueue.remove());
                break;
            case "info":
                shop.showCustomerInfo(commandQueue.remove());
                break;
            case "order":
                shop.order(commandQueue.remove(), commandQueue.remove());
                break;
            default:
                System.out.println("'" + token +"' is not recognized as a command");
        }
    }
    public void storageCommand(Queue<String> commandQueue){
        String token =commandQueue.remove();
        switch (token){
            case "status":
                shop.getStorage().showStatus();
                break;
            case "buy":
                shop.setSalary(shop.getSalary()-shop.getStorage().buyIngredient(commandQueue.remove(),Double.parseDouble(commandQueue.remove())));
                break;
            default:
                System.out.println("'" + token +"' is not recognized as a command");
        }
    }


    public static void main(String[] args) {
        Shop shop = new Shop();
        CommandLoader commandLoader = new CommandLoader(shop);
        commandLoader.commandTerminal();
    }
}
