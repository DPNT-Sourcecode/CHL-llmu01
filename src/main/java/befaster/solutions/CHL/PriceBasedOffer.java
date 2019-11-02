package befaster.solutions.CHL;

import java.util.Objects;

public class SpecialOffer {

    private int offerQuantity;
    private int offerPrice;

    public SpecialOffer(int offerQuantity, int offerPrice) {
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
        SpecialOffer that = (SpecialOffer) o;
        return offerQuantity == that.offerQuantity &&
                offerPrice == that.offerPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerQuantity, offerPrice);
    }
}
