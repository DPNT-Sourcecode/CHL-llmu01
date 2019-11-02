package befaster.solutions.CHL;

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
               
           }
        }

        price = purchasedQuantity * purchasedItem.getBasePrice();
        return price;
    }
}

