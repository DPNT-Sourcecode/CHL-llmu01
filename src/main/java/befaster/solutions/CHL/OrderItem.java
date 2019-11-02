package befaster.solutions.CHL;

import java.util.Objects;
import java.util.Optional;

public class OrderItem {

    private Item purchasedItem;
    private int purchasedQuantity;
    private int price;

    public OrderItem(Item purchasedItem, int purchasedQuantity) {
        this.purchasedItem = purchasedItem;
        this.purchasedQuantity = purchasedQuantity;
    }

    public void incrementQuantity() {
        purchasedQuantity = purchasedQuantity + 1;
    }

    public int computePrice() {
        if(purchasedItem.getPriceBasedOffer().isPresent()) {
            PriceBasedOffer priceBasedOffer = purchasedItem.getPriceBasedOffer().get();

           if (purchasedQuantity == priceBasedOffer.getOfferQuantity()) {
               return priceBasedOffer.getOfferPrice();
           } else if (purchasedQuantity > priceBasedOffer.getOfferQuantity()) {
               int offerApplicableQuantity =  purchasedQuantity / priceBasedOffer.getOfferQuantity();
               int normalPriceQuantity = purchasedQuantity % priceBasedOffer.getOfferQuantity();

               return offerApplicableQuantity * priceBasedOffer.getOfferPrice()
                       + normalPriceQuantity * purchasedItem.getBasePrice();
           }
        }

        price = purchasedQuantity * purchasedItem.getBasePrice();
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return purchasedQuantity == orderItem.purchasedQuantity &&
                price == orderItem.price &&
                Objects.equals(purchasedItem, orderItem.purchasedItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchasedItem, purchasedQuantity, price);
    }

    public Optional<Item> applyFreebie() {

        return Optional.<Item>empty();
    }
}
