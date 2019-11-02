package befaster.solutions.CHL;

import java.util.*;

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

        List<Item> freebieItems = new LinkedList<>();
        for (OrderItem orderItem : orderItems.values()) {
            orderItem.applyFreebie().map(freebieItems::add);
        }

        freebieItems.forEach(item -> {
            OrderItem orderItem = orderItems.get(item.getName());
            orderItem.decrementQuantity();
        });

        return calculateTotalPrice(orderItems.values());
    }

    private void addItemToOrder(Map<Character, OrderItem> orderItems, Character item) {
        OrderItem itemToAdd = new OrderItem(priceTable.get(item), 1);

        if (orderItems.containsKey(item)) {
            orderItems.get(item).incrementQuantity();
        } else {
            orderItems.put(item, itemToAdd);
        }
    }

    private int calculateTotalPrice(Collection<OrderItem> orderItems) {
        return orderItems.stream().mapToInt(OrderItem::computePrice).sum();
    }

    private void initialisePriceTable() {
        PriceBasedOffer offerA = new PriceBasedOffer(3, 130);
        Item itemA = new Item('A', 50, offerA);
        priceTable.put(itemA.getName(), itemA);

        PriceBasedOffer offerB = new PriceBasedOffer(2, 45);
        Item itemB = new Item('B', 30, offerB);
        priceTable.put(itemB.getName(), itemB);

        Item itemC = new Item('C', 20);
        priceTable.put(itemC.getName(), itemC);
        Item itemD = new Item('D', 15);
        priceTable.put(itemD.getName(), itemD);

        Item itemE = new Item('E', 40);
        FreebieOffer freebieOffer = new FreebieOffer(2, new Item(itemB.getName(), 0));
        itemE.setFreebieOffer(freebieOffer);
        priceTable.put(itemE.getName(), itemE);
    }
}
