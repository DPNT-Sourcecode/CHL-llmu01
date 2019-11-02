package befaster.solutions.CHL;

import java.util.Objects;

public class PriceBasedOffer {

    private int offerQuantity;
    private int offerPrice;

    public PriceBasedOffer(int offerQuantity, int offerPrice) {
        this.offerQuantity = offerQuantity;
        this.offerPrice = offerPrice;
    }

    public int getOfferQuantity() {
        return offerQuantity;
    }

    public int getOfferPrice() {
        return offerPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceBasedOffer that = (PriceBasedOffer) o;
        return offerQuantity == that.offerQuantity &&
                offerPrice == that.offerPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerQuantity, offerPrice);
    }
}

