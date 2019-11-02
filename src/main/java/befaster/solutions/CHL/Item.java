package befaster.solutions.CHL;

import java.util.Objects;
import java.util.Optional;

public class Item {

    private Character name;
    private int basePrice;

    private PriceBasedOffer priceBasedOffer;
    private FreebieOffer freebieOffer;

    public Item(Character name, int basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public Item(Character name, int basePrice, PriceBasedOffer priceBasedOffer) {
        this.name = name;
        this.basePrice = basePrice;
        this.priceBasedOffer = priceBasedOffer;
    }

    public Character getName() {
        return name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public Optional<PriceBasedOffer> getPriceBasedOffer() {
        return Optional.ofNullable(priceBasedOffer);
    }

    public void setPriceBasedOffer(PriceBasedOffer priceBasedOffer) {
        this.priceBasedOffer = priceBasedOffer;
    }

    public void setFreebieOffer(FreebieOffer freebieOffer) {
        this.freebieOffer = freebieOffer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

