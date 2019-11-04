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
            System.out.println("looking up item=" + item);
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

        addItemToPriceTable('C', 20);

        addItemToPriceTable('D', 15);

        Item itemE = new Item('E', 40);
        FreebieOffer offerE = new FreebieOffer(2, new Item(itemB.getName(), 0));
        itemE.setFreebieOffer(offerE);
        priceTable.put(itemE.getName(), itemE);

        Item itemF = new Item('F', 10);
        FreebieOffer offerF = new FreebieOffer(3, new Item(itemF.getName(), 0));
        itemF.setFreebieOffer(offerF);
        priceTable.put(itemF.getName(), itemF);

        addItemToPriceTable('G', 20);

        Item itemH = new Item('H', 10);
        itemH.setPriceBasedOffers(newArrayList(getPriceBasedOffer(5, 45),
                getPriceBasedOffer(10, 80)));
        priceTable.put(itemH.getName(), itemH);

        addItemToPriceTable('I', 35);

        addItemToPriceTable('J', 60);

        Item itemK = new Item('K', 80);
        itemK.setPriceBasedOffers(newArrayList(getPriceBasedOffer(2, 150)));
        priceTable.put(itemK.getName(), itemK);

        addItemToPriceTable('L', 90);

        Item itemM = new Item('M', 15);
        priceTable.put(itemM.getName(), itemM);

        Item itemN = new Item('N', 40);
        itemN.setFreebieOffer(new FreebieOffer(3, new Item(itemM.getName(), 0)));
        priceTable.put(itemN.getName(), itemN);

        addItemToPriceTable('O', 10);

        Item itemP = new Item('P', 50);
        itemP.setPriceBasedOffers(newArrayList(getPriceBasedOffer(5, 200)));
        priceTable.put(itemP.getName(), itemP);

        Item itemQ = new Item('Q', 30);
        itemQ.setPriceBasedOffers(newArrayList(getPriceBasedOffer(3, 80)));
        priceTable.put(itemQ.getName(), itemQ);

        Item itemR = new Item('R', 50);
        itemR.setFreebieOffer(new FreebieOffer(3, new Item(itemQ.getName(), 0)));
        priceTable.put(itemR.getName(), itemR);

        addItemToPriceTable('S', 30);

        addItemToPriceTable('T', 20);

        Item itemU = new Item('U', 40);
        itemU.setFreebieOffer(new FreebieOffer(4,
                new Item(itemU.getName(), 0)));
        priceTable.put(itemU.getName(), itemU);

        Item itemV = new Item('V', 50);
        itemV.setPriceBasedOffers(newArrayList(
                getPriceBasedOffer(2, 90),
                getPriceBasedOffer(3, 130)
        ));
        priceTable.put(itemV.getName(), itemV);

        addItemToPriceTable('W', 20);

        addItemToPriceTable('X', 90);

        addItemToPriceTable('Y', 10);

        addItemToPriceTable('Z', 50);

    }

    private void addItemToPriceTable(char x, int i) {
        Item item = new Item(x, i);
        priceTable.put(item.getName(), item);
    }

    private PriceBasedOffer getPriceBasedOffer(int offerQuantity, int offerPrice) {
        return new PriceBasedOffer(offerQuantity, offerPrice);
    }
}

