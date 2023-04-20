package Step1;

import java.util.*;

public class Goods {
    private List<String> names;
    private List<Integer> prices;
    private Map<Integer,String> products;
    public Goods()
    {
        names=new ArrayList<>();
        names.add("Кола");
        names.add("Чипсы");
        names.add("Кириешки");
        names.add("Фанта");
        names.add("Альпен-Голд");
        prices=new ArrayList<>();
        prices.add(20);
        prices.add(30);
        prices.add(15);
        prices.add(26);
        prices.add(21);
        products=new HashMap<>();
    }

    public Map<Integer,String> storageOfProducts()
    {
        int n=names.size();
        while(n>0)
        {
            int num = getRandomNumber(n); //random number for names
            int num2=getRandomNumber(n);//random number for prices
            products.put(prices.get(num2),names.get(num));
            names.remove(names.get(num));
            prices.remove(prices.get(num2));
            n=names.size();
        }
       return products;
    }
    private static int getRandomNumber(int num)
    {
        Random random=new Random();
        return random.nextInt(num);
    }


}
