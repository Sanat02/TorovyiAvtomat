package Step1;

import java.util.*;

public class Automate {
    private int coins;
    private Goods goods;
    private Map<Integer, String> products;
    private Map<Integer,String> map1;

    public Automate() {
        goods = new Goods();
        products = new HashMap<>();
        products = goods.storageOfProducts();
        map1=new HashMap<>();
        map1.put(1,"Закинуть монет");
        map1.put(2,"Выйти");
    }

    public void startAction() {
        System.out.println("__________Start__________");
        printGoods();
        coins=0;
        String com=qOrA();
        if(com.equals("a")) {
            continueAction();
        }
        else
        {
            finishAction();
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
        System.out.print("Монет на сумму:");
        String value = in.nextLine();
        boolean isvalid = returnValidNumber(value);
        while (!isvalid) {
            System.out.println("Неправильное значение!Введите заново:");
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
    private int getMinValue()
    {
        int min=9999;
        for(Map.Entry<Integer,String> entry:products.entrySet())
        {
            min=Math.min(min,entry.getKey());
        }
        return min;
    }
    private void printOption()
    {
        System.out.println("Общ.монет:"+coins);
        for(Map.Entry entry:map1.entrySet())
        {
            int n= (int) entry.getKey();
            if(n<=2) {
                System.out.printf("%s - %s%n", entry.getKey(), entry.getValue());
            }
            else
            {
                System.out.printf("%s - Купить '%s'%n", entry.getKey(), entry.getValue());
            }
        }
    }
    private  void finishAction()
    {
        System.out.println("__________End__________");
    }
    private void continueAction()
    {
        Scanner in=new Scanner(System.in);
        coins = Integer.parseInt(retrieveCoins());

        int s=1;
        while (s==1) {

            while(coins<getMinValue())
            {
                System.out.printf("У вас %s  монет .Ничего не купишь,добавьте еще монеты:%n",coins);
                coins+=Integer.parseInt(retrieveCoins());

            }
            int i=3;

            for(Map.Entry<Integer,String> entry:products.entrySet())
            {
                if( entry.getKey()<=coins)
                {
                    map1.put(i, entry.getValue());
                    i++;
                }
            }
            printOption();
            int num = in.nextInt();
            s = performOption(num);

        }
        finishAction();
    }
    private int performOption(int num)
    {
        if(num==1)
        {
            coins+=Integer.parseInt(retrieveCoins());
            return 1;
        }
        else if(num==2)
        {
            return -1;
        }
        else
        {
            for(Map.Entry<Integer,String> entry:products.entrySet())
            {
                if(entry.getValue().equals(map1.get(num)))
                {
                    System.out.println("Вы купили:"+entry.getValue());
                    coins=coins-entry.getKey();
                }
            }
            return 1;
        }
    }
}
