/*
package shoping;

import model.Item;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private Map<Item, Integer> itemQuantities;

    public Cart() {
        itemQuantities = new LinkedHashMap<Item, Integer>();
    }

    public int total() {
        int result = 0;
        for (Item item : itemQuantities.keySet()) {
            result += item.priceForQuantity(itemQuantities.get(item));
        }
        return result;
    }

    public void add(Item itemToBuy) {
        add(itemToBuy, 1);
    }

    public void add(Item item, int currentQuantity) {

        int previousQuantity = 0;
        if(itemQuantities.containsKey(item))
            {
                previousQuantity = itemQuantities.get(item);
                itemQuantities.put(item, previousQuantity + previousQuantity);
            }
        }

    @Override
    public String toString() {
        String line = "--------------------------------\n";
        StringBuffer sb = new StringBuffer();
        sb.append(line);
        for (Item each : itemQuantities.keySet()) {
            sb.append(String.format("%-24s % 7.2f\n", each.description(), each.unitPrice() / 100.0));
        }
        sb.append(line);
        sb.append(String.format("%24s% 8.2f", "TOTAL:", total() / 100.0));
        return sb.toString();
    }
}

*/
