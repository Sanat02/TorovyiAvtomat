package Step1;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Automate {
    private int coins;
    private Goods goods;
    private Map<Integer, String> products;

    public Automate() {
        goods = new Goods();
        products = new HashMap<>();
        products = goods.storageOfProducts();
    }

    public void startAction() {
        System.out.println("__________Start__________");
        printGoods();
        coins=0;
        String com=qOrA();
        if(com.equals("a")) {
            coins = Integer.parseInt(retrieveCoins());
            System.out.println("Your coins:" + coins);
        }
        else
        {
            System.out.println("__________End__________");
        }

    }

    public boolean returnValidNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String retrieveCoins() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter coins:");
        String value = in.nextLine();
        boolean isvalid = returnValidNumber(value);
        while (!isvalid) {
            System.out.println("Invalid value enter again!");
            value = in.nextLine();
            isvalid = returnValidNumber(value);
        }
        return value;
    }


    private void printGoods() {
       System.out.println("В автомате доступны:");
       for(Map.Entry<Integer,String> entry:products.entrySet())
       {
           System.out.printf("[%s] - %s%n",entry.getKey(),entry.getValue());
       }
    }
    private String qOrA()
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Монет на сумму:"+coins);
        System.out.printf("%s - %s%n%s - %s%n",">a","Закинуть монет",">q","Выйти");
        String command=in.nextLine().toLowerCase(Locale.ROOT);
        while(!command.equals("a")&&!command.equals("q"))
        {
            System.out.println("Неправильное значение!Введите заново:");
            command=in.nextLine();
        }
        return command;
    }
}
