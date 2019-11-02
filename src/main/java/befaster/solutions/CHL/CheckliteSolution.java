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

        Set<OrderItem> orderItems = new HashSet<>();
        for (Character item: items) {
            char upperCase = Character.toUpperCase(item);

            if (priceTable.containsKey(upperCase)) {
                orderItems.add(new OrderItem(priceTable.get(upperCase), 1));
            }
        }

        return orderItems.stream().mapToInt(OrderItem::computePrice).sum();
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
