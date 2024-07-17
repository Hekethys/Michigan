public class Client {
    public static void main(String[] args) {
        Order order = new Order(1);

        PriceObserver priceObserver = new PriceObserver();
        QuantityObserver quantityObserver = new QuantityObserver();

        order.attach(priceObserver);
        order.attach(quantityObserver);

        order.addItem(50);
        order.addItem(60);
        order.addItem(30);
        order.addItem(40);
        order.addItem(70);

        System.out.println(order);

        order.addItem(80);
        System.out.println(order);
    }
}
