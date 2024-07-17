public class QuantityObserver implements OrderObserver {
    @Override
    public void update(Order order) {
        if (order.getCount() > 5) {
            order.addItem(-10);
        } else {
            order.addItem(10);
        }
    }
}
