package befaster.solutions.CHL;

import com.google.common.collect.Lists;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderItemTest {

    @Test
    public void computePriceOfOrderItem() {
        Item item = new Item('A', 50);
        OrderItem orderItem = new OrderItem(item, 1);

        assertThat(orderItem.computePrice()).isEqualTo(50);
    }

    @Test
    public void computePriceWithMultipleQuantity() {
        Item item = new Item('A', 50);
        OrderItem orderItem = new OrderItem(item, 2);

        assertThat(orderItem.computePrice()).isEqualTo(100);
    }

    @Test
    public void computePriceWithSpecialOfferMatchingPurchasedQuantity() {
        PriceBasedOffer priceBasedOffer = new PriceBasedOffer(3, 130);
        Item item = new Item('A', 50, priceBasedOffer);
        OrderItem orderItem = new OrderItem(item, 3);

        assertThat(orderItem.computePrice()).isEqualTo(130);
    }

    @Test
    public void computePriceWhenPurchasedQuantityIsLessThanOfferQuantity() {
        PriceBasedOffer priceBasedOffer = new PriceBasedOffer(3, 130);
        Item item = new Item('A', 50, priceBasedOffer);
        OrderItem orderItem = new OrderItem(item, 2);

        assertThat(orderItem.computePrice()).isEqualTo(100);
    }

    @Test
    public void computePriceWhenPurchasedQuantityIsGreaterThanOfferQuantity() {
        PriceBasedOffer priceBasedOffer = new PriceBasedOffer(3, 130);
        Item item = new Item('A', 50, priceBasedOffer);
        OrderItem orderItem = new OrderItem(item, 4);

        assertThat(orderItem.computePrice()).isEqualTo(180);
    }

    @Test
    public void computePriceWhenMultipleOffersAreApplicable() {
        PriceBasedOffer priceBasedOffer = new PriceBasedOffer(3, 130);
        Item item = new Item('A', 50, priceBasedOffer);
        OrderItem orderItem = new OrderItem(item, 8);

        assertThat(orderItem.computePrice()).isEqualTo(360);
    }

    @Test
    public void useBestMatchingOfferForComputation() {
        PriceBasedOffer offer1 = new PriceBasedOffer(5, 200);
        PriceBasedOffer offer2 = new PriceBasedOffer(3, 130);

        Item item = new Item('A', 50);
        item.setPriceBasedOffers(Lists.newArrayList(offer2, offer1));
        OrderItem orderItem = new OrderItem(item, 9);

        assertThat(orderItem.computePrice()).isEqualTo(380);
    }

    @Test
    public void applyFreebieOffer() {
        Item freeItem = new Item('B', 0);
        FreebieOffer freebieOffer = new FreebieOffer(2, freeItem);
        Item source = new Item('A', 50, freebieOffer);

        OrderItem orderItem = new OrderItem(source, 2);

        assertThat(orderItem.computePrice()).isEqualTo(100);
        assertThat(orderItem.applyFreebie()).isPresent().hasValue(freeItem);
    }

    @Test
    public void freebieOfferIsNotAppliedWhenQuantityDoesNotMatch() {
        Item freeItem = new Item('B', 0);
        FreebieOffer freebieOffer = new FreebieOffer(2, freeItem);
        Item source = new Item('A', 50, freebieOffer);

        OrderItem orderItem = new OrderItem(source, 1);

        assertThat(orderItem.computePrice()).isEqualTo(50);
        assertThat(orderItem.applyFreebie()).isEmpty();
    }
}

