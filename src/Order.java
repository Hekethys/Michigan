import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private int itemCount;
    private double itemCost;
    private double shippingCost;
    private List<OrderObserver> observers;

    public Order(int id) {
        this.id = id;
        this.itemCount = 0;
        this.itemCost = 0.0;
        this.shippingCost = 10.0;
        this.observers = new ArrayList<>();
    }

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public double getTotalPrice() {
        return itemCost + shippingCost;
    }

    public int getCount() {
        return itemCount;
    }

    public void addItem(double price) {
        itemCount++;
        itemCost += price;
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Order ID: " + id + ", Item Count: " + itemCount+ ", Item Cost: " + itemCost + ", Shipping Cost: " + shippingCost+", Total Price: " + getTotalPrice();
    }
}
