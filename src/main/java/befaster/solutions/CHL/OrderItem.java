package befaster.solutions.CHL;

import java.util.List;
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

    public void decrementQuantity() {
        if (purchasedQuantity > 0) {
            purchasedQuantity = purchasedQuantity - 1;
        }
    }

    public int computePrice() {
        return compute(purchasedQuantity);
    }

    private int compute(int remainingQuantity) {
        Optional<PriceBasedOffer> matchingOffer = findMatchingOffer(remainingQuantity, purchasedItem.getPriceBasedOffers());
        if (matchingOffer.isPresent()) {
            PriceBasedOffer priceBasedOffer = matchingOffer.get();
            int offerApplicableQuantity = purchasedQuantity / priceBasedOffer.getOfferQuantity();
            int normalPriceQuantity = purchasedQuantity % priceBasedOffer.getOfferQuantity();

            return offerApplicableQuantity * priceBasedOffer.getOfferPrice()
                    + compute(normalPriceQuantity);
        } else {
            return price = purchasedQuantity * purchasedItem.getBasePrice();
        }
    }

    private Optional<PriceBasedOffer> findMatchingOffer(int purchasedQuantity, Optional<List<PriceBasedOffer>> offers) {
        return offers.flatMap(priceBasedOffers -> priceBasedOffers.stream()
                .filter(element -> purchasedQuantity >= element.getOfferQuantity()).findAny());
    }

    public Optional<Item> applyFreebie() {
        if(purchasedItem.getFreebieOffer().isPresent()) {
            FreebieOffer freebieOffer = purchasedItem.getFreebieOffer().get();

            if (purchasedQuantity == freebieOffer.getOfferQuantity()) {
                return Optional.of(freebieOffer.getFreebieItem());
            }
        }
        return Optional.empty();
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
}


