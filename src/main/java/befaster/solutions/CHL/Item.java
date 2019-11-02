package befaster.solutions.CHL;

import java.util.*;

public class Item {

    private Character name;
    private int basePrice;

    private List<PriceBasedOffer> priceBasedOffers;
    private FreebieOffer freebieOffer;

    public Item(Character name, int basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public Item(Character name, int basePrice, PriceBasedOffer priceBasedOffers) {
        this.name = name;
        this.basePrice = basePrice;
        this.priceBasedOffers = Collections.singletonList(priceBasedOffers);
    }

    public Item(Character name, int basePrice, FreebieOffer freebieOffer) {
        this.name = name;
        this.basePrice = basePrice;
        this.freebieOffer = freebieOffer;
    }

    public Character getName() {
        return name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public Optional<List<PriceBasedOffer>> getPriceBasedOffers() {
        return Optional.ofNullable(priceBasedOffers);
    }
    public Optional<FreebieOffer> getFreebieOffer() {
        return Optional.ofNullable(freebieOffer);
    }

    public void setPriceBasedOffers(List<PriceBasedOffer> priceBasedOffers) {
        this.priceBasedOffers = priceBasedOffers;
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
