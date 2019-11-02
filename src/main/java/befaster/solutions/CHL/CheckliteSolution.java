package befaster.solutions.CHL;

import com.google.common.collect.Lists;

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

        applyFreebieOffers(orderItems);

        return calculateTotalPrice(orderItems.values());
    }

    private void applyFreebieOffers(Map<Character, OrderItem> orderItems) {
        List<Item> freebieItems = new LinkedList<>();
        for (OrderItem orderItem : orderItems.values()) {
            orderItem.applyFreebie().map(freebieItems::addAll);
        }
        freebieItems.forEach(item -> {
            if (orderItems.containsKey(item.getName())) {
                OrderItem orderItem = orderItems.get(item.getName());
                orderItem.decrementQuantity();
            }
        });
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
        PriceBasedOffer offerA2 = new PriceBasedOffer(5, 200);
        Item itemA = new Item('A', 50);
        itemA.setPriceBasedOffers(Lists.newArrayList(offerA, offerA2));
        priceTable.put(itemA.getName(), itemA);

        PriceBasedOffer offerB = new PriceBasedOffer(2, 45);
        Item itemB = new Item('B', 30, offerB);
        priceTable.put(itemB.getName(), itemB);

        Item itemC = new Item('C', 20);
        priceTable.put(itemC.getName(), itemC);

        Item itemD = new Item('D', 15);
        priceTable.put(itemD.getName(), itemD);

        Item itemE = new Item('E', 40);
        FreebieOffer offerE = new FreebieOffer(2, new Item(itemB.getName(), 0));
        itemE.setFreebieOffer(offerE);
        priceTable.put(itemE.getName(), itemE);

        Item itemF = new Item('F', 10);
        FreebieOffer offerF = new FreebieOffer(2, new Item(itemF.getName(), 0));
        itemF.setFreebieOffer(offerF);
        priceTable.put(itemF.getName(), itemF);
    }
}



