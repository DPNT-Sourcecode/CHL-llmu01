package befaster.solutions.CHL;

import java.util.*;
import static com.google.common.collect.Lists.newArrayList;

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
        itemA.setPriceBasedOffers(newArrayList(offerA, offerA2));
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
        FreebieOffer offerF = new FreebieOffer(3, new Item(itemF.getName(), 0));
        itemF.setFreebieOffer(offerF);
        priceTable.put(itemF.getName(), itemF);

        Item itemG = new Item('G', 20);
        priceTable.put(itemG.getName(), itemG);

        Item itemH = new Item('H', 10);
        itemH.setPriceBasedOffers(newArrayList(getPriceBasedOffer(5, 45),
                getPriceBasedOffer(10, 80)));
        priceTable.put(itemH.getName(), itemH);

        Item itemJ = new Item('J', 60);
        priceTable.put(itemJ.getName(), itemJ);

        Item itemK = new Item('H', 10);
        itemK.setPriceBasedOffers(newArrayList(getPriceBasedOffer(2, 150)));
        priceTable.put(itemK.getName(), itemK);

        Item itemL = new Item('L', 90);
        priceTable.put(itemL.getName(), itemL);

        Item itemM = new Item('M', 90);
        priceTable.put(itemL.getName(), itemL);

    }

    private PriceBasedOffer getPriceBasedOffer(int offerQuantity, int offerPrice) {
        return new PriceBasedOffer(offerQuantity, offerPrice);
    }
}
