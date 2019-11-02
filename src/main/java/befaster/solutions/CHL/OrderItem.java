package befaster.solutions.CHL;

public class OrderItem {

    private Item purchasedItem;
    private int quantity;
    private int price;

    public OrderItem(Item purchasedItem, int quantity) {
        this.purchasedItem = purchasedItem;
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        quantity = quantity + 1;
    }

    public int computePrice() {
        price = quantity * purchasedItem.getBasePrice();
        return price;
    }
}
