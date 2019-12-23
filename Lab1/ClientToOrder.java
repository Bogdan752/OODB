import java.util.Date;

public class ClientToOrder {
    //many-to-many representation of Client has an order
    private int id;
    private Order order;
    private Client client;
    private Date ordersCreateDate;
    private int priceEntireGoodsInCart;

    public ClientToOrder(int id, Order order, Client client) {
        this.id = id;
        this.order = order;
        this.client = client;
        ordersCreateDate = new Date();
    }

    public void addItemToClientsCart(Item item) {
        order.addItemToList(item);
        calculatePrice();
    }

    public void removeFromClientsCart(Item item) {
        order.removeItemFromList(item);
        calculatePrice();
    }

    private void calculatePrice() {
        priceEntireGoodsInCart = order.calculateSum();
    }
}
