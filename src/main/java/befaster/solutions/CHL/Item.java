package befaster.solutions.CHL;

import java.util.Objects;
import java.util.Optional;

public class Item {

    private Character name;
    private int basePrice;

    private Optional<SpecialOffer> specialOffer;

    public Item(Character name, int basePrice, Optional<SpecialOffer> specialOffer) {
        this.name = name;
        this.basePrice = basePrice;
        this.specialOffer = specialOffer;
    }

    public Character getName() {
        return name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public Optional<SpecialOffer> getSpecialOffer() {
        return specialOffer;
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
