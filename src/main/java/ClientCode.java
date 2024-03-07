import config.ItemConfiguration;
import model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ClientCode {

    private static Map<String, Item> availableItemMap;


    static {
        ItemConfiguration.init();
        availableItemMap = ItemConfiguration.availableItems;
    }
    /*public static void main(String[] args) {
        List<String> shoppingBag = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean addItem = true;
        while(addItem){
            System.out.println("Select the Item you would like to buy");
            System.out.println("1. Apples 2. Bananas 3. Melons, 4. Lime 5. Exit");
            int item = scanner.nextInt();
            switch (item) {
                case 1:
                    shoppingBag.add("apple");
                    break;
                case 2:
                    shoppingBag.add("banana");
                    break;
                case 3:
                    shoppingBag.add("melon");
                    break;
                case 4:
                    shoppingBag.add("lime");
                    break;
                default:
                    addItem = false;
            }

        }
        System.out.println("Shopping Bag items are: " + shoppingBag);

        System.out.println("Total price: "+calculatePrice(availableItemMap,prepareOrderItem(shoppingBag)));


    }*/

    public  Map<String, Long> prepareOrderItem(List<String> shoppingBag){
        return  shoppingBag.stream().collect(Collectors.groupingBy(Function.identity() , Collectors.counting()));
    }

    public  String calculatePrice(Map<String, Item> availableItemMap, Map<String, Long> orderItems){
        double result = 0.0;
        for (Map.Entry<String, Long> orderEntry: orderItems.entrySet()){
           result+= availableItemMap.get(orderEntry.getKey()).calculatePrice(availableItemMap.get(orderEntry.getKey()).getUnitPrice(),orderEntry.getValue().intValue());
        }

        return result / 100.0 + " £";
    }
}
