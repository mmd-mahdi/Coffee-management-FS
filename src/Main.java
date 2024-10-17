import java.util.*;

public class Main {
    public static void main(String[] args) {
        String str = "lil this is mohammad ali keley";
        Queue<String> list = getTokens(str);
        commandReader(str);
//        System.out.println(list.remove());

    }

    public static Queue<String> getTokens(String str) {
        Queue<String> tokens = new LinkedList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, " ");
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }
        return tokens;
    }
    public static void commandReader(String command){
        Queue<String> commandQueue = getTokens(command);
        String token =commandQueue.remove();
        switch (token){
            case "shop":
                System.out.println(token);
                break;
            case "customer":
                System.out.println(token);
                break;
            default:
                System.out.println("'" + token +"' is not recognized as a command"  );
        }
    }
}