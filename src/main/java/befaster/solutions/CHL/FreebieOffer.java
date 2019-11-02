package befaster.solutions.CHL;

public class FreebieOffer {

    private int offerQuantity;
    private Item freebieItem;

    public FreebieOffer(int offerQuantity, Item freebieItem) {
        this.offerQuantity = offerQuantity;
        this.freebieItem = freebieItem;
    }

    public Item getFreebieItem() {
        return freebieItem;
    }

    public int getOfferQuantity() {
        return offerQuantity;
    }
}

