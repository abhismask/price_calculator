import config.ItemConfiguration;
import model.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
public class ClientCodeTest {

   private List<String> shoppingBag;
    private static Map<String, Item> availableItemMap;
   private ClientCode clientCode;
    @Before
   public void setUp() {
        clientCode = new ClientCode();
        ItemConfiguration.init();
        availableItemMap = ItemConfiguration.availableItems;
    }

    @Test
    public void test_calculateSingleBasicItemCost() {
        shoppingBag = new ArrayList<>();
        shoppingBag.add("apple");
        Map<String, Long> orderItems = clientCode.prepareOrderItem(shoppingBag);
        String result = clientCode.calculatePrice(availableItemMap, orderItems);
        assertEquals("0.35 £", result);
    }

    @Test
    public void test_calculateMultipleOnlyBasePriceStrategyItemCost() {
        shoppingBag = new ArrayList<>();
        shoppingBag.add("apple");
        shoppingBag.add("banana");
        Map<String, Long> orderItems = clientCode.prepareOrderItem(shoppingBag);
        String result = clientCode.calculatePrice(availableItemMap, orderItems);
        assertEquals("0.55 £", result);
    }

    @Test
    public void test_calculatedSingleOfferPriceStrategyItemCostWithExactBundleSize() {
        shoppingBag = new ArrayList<>();
        shoppingBag.add("melon");
        shoppingBag.add("melon");
        Map<String, Long> orderItems = clientCode.prepareOrderItem(shoppingBag);
        String result = clientCode.calculatePrice(availableItemMap, orderItems);
        assertEquals("0.5 £", result);
    }

    @Test
    public void test_calculatedSingleOfferPriceStrategyItemCostWithMoreThanBundleSize() {
        shoppingBag = new ArrayList<>();
        shoppingBag.add("melon");
        shoppingBag.add("melon");
        shoppingBag.add("melon");
        shoppingBag.add("melon");
        shoppingBag.add("melon");
        Map<String, Long> orderItems = clientCode.prepareOrderItem(shoppingBag);
        String result = clientCode.calculatePrice(availableItemMap, orderItems);
        assertEquals("1.5 £", result);
    }

    @Test
    public void test_calculatedSingleMixedStrategyItemCost() {
        shoppingBag = new ArrayList<>();
        shoppingBag.add("apple");
        shoppingBag.add("banana");
        shoppingBag.add("melon");
        shoppingBag.add("lime");
        Map<String, Long> orderItems = clientCode.prepareOrderItem(shoppingBag);
        String result = clientCode.calculatePrice(availableItemMap, orderItems);
        assertEquals("1.2 £", result);
    }

    @Test
    public void test_calculatedMixedStrategyItemCost() {
        shoppingBag = new ArrayList<>();
        shoppingBag.add("apple");
        shoppingBag.add("banana");
        shoppingBag.add("banana");
        shoppingBag.add("melon");
        shoppingBag.add("melon");
        shoppingBag.add("melon");
        shoppingBag.add("lime");
        shoppingBag.add("lime");
        shoppingBag.add("lime");
        shoppingBag.add("lime");
        shoppingBag.add("lime");
        Map<String, Long> orderItems = clientCode.prepareOrderItem(shoppingBag);
        String result = clientCode.calculatePrice(availableItemMap, orderItems);
        assertEquals("2.35 £", result);
    }

}
