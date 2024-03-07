package config;

import model.Item;
import pricing.BasePrice;
import pricing.OfferPrice;

import java.util.HashMap;
import java.util.Map;

public class ItemConfiguration {
    public static Map<String, Item> availableItems = new HashMap<>();

    public static void init(){
        availableItems.put("apple", new Item("apple", 35, "apple description", new BasePrice()));
        availableItems.put("banana", new Item("banana", 20, "banana description",new BasePrice()));
        availableItems.put("melon", new Item("melon", 50, "melons description",new OfferPrice(2,1)));
        availableItems.put("lime", new Item("lime", 15, "apple description",new OfferPrice(3,2)));
    }

}
