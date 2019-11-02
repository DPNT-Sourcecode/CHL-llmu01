package befaster.solutions.CHL;

import java.util.Objects;

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
        if(purchasedItem.getSpecialOffer().isPresent()) {
            SpecialOffer specialOffer = purchasedItem.getSpecialOffer().get();
           if (purchasedQuantity == specialOffer.getOfferQuantity()){
               return specialOffer.getOfferPrice();
           } else if (purchasedQuantity > specialOffer.getOfferQuantity()) {
               int offerApplicableQuantity =  purchasedQuantity / specialOffer.getOfferQuantity();
               int normalPriceQuantity = purchasedQuantity % specialOffer.getOfferQuantity();

               return offerApplicableQuantity * specialOffer.getOfferPrice()
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
}
