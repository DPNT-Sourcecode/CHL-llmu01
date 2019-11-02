package befaster.solutions.CHL;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CheckliteSolution {

    private Map<Character, Item> priceTable = new HashMap<>();

    public CheckliteSolution() {
        initialisePriceTable();
    }

    public Integer checklite(String skus) {
        if (skus == null) return -1;
        if (skus.trim().isEmpty()) return 0;

        char[] items = skus.toCharArray();

        Map<Character, OrderItem> orderItems = new HashMap<>();
        for (Character item: items) {
            if (priceTable.containsKey(item)) {
                addItemToOrder(orderItems, item);
            } else {
                return -1;
            }
        }

        return calculateTotalPrice(orderItems);
    }

    private void addItemToOrder(Map<Character, OrderItem> orderItems, Character item) {
        OrderItem itemToAdd = new OrderItem(priceTable.get(item), 1);

        if (orderItems.containsKey(item)) {
            orderItems.get(item).incrementQuantity();
        } else {
            orderItems.put(item, itemToAdd);
        }
    }

    private int calculateTotalPrice(Map<Character, OrderItem> orderItems) {
        return orderItems.values().stream().mapToInt(OrderItem::computePrice).sum();
    }

    private void initialisePriceTable() {
        SpecialOffer offerA = new SpecialOffer(3, 130);
        Item itemA = new Item('A', 50, Optional.of(offerA));
        priceTable.put(itemA.getName(), itemA);

        SpecialOffer offerB = new SpecialOffer(2, 45);
        Item itemB = new Item('B', 30, Optional.of(offerB));
        priceTable.put(itemB.getName(), itemB);

        Item itemC = new Item('C', 20, Optional.empty());
        priceTable.put(itemC.getName(), itemC);
        Item itemD = new Item('D', 15, Optional.empty());
        priceTable.put(itemD.getName(), itemD);
    }
}
