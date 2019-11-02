package befaster.solutions.CHL;

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
}

