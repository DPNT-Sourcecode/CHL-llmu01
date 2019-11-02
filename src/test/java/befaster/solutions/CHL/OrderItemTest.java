package befaster.solutions.CHL;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderItemTest {

    @Test
    public void computePriceOfOrderItem() {
        Item item = new Item('A', 50, Optional.empty());
        OrderItem orderItem = new OrderItem(item, 1);

        assertThat(orderItem.computePrice()).isEqualTo(50);
    }

    @Test
    public void computePriceWithMultipleQuantity() {
        Item item = new Item('A', 50, Optional.empty());
        OrderItem orderItem = new OrderItem(item, 2);

        assertThat(orderItem.computePrice()).isEqualTo(100);
    }

    @Test
    public void computePriceWithSpecialOfferMatchingPurchasedQuantity() {
        SpecialOffer specialOffer = new SpecialOffer(3, 130);
        Item item = new Item('A', 50, Optional.of(specialOffer));
        OrderItem orderItem = new OrderItem(item, 3);

        assertThat(orderItem.computePrice()).isEqualTo(130);
    }

    @Test
    public void computePriceWhenPurchasedQuantityIsLessThanOfferQuantity() {
        SpecialOffer specialOffer = new SpecialOffer(3, 130);
        Item item = new Item('A', 50, Optional.of(specialOffer));
        OrderItem orderItem = new OrderItem(item, 2);

        assertThat(orderItem.computePrice()).isEqualTo(100);
    }
}