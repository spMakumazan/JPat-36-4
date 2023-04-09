import java.util.HashMap;
import java.util.Map;

public class Basket implements StoreAble {

    private Store store;
    private Map<Item, Integer> basket;

    public Basket(Store store) {
        this.store = store;
        basket = new HashMap<>();
    }

    @Override
    public boolean addItem(Item item, int amount) {
        if (store.takeItem(item, amount)) {
            if (basket.containsKey(item)) {
                basket.put(item, basket.get(item) + amount);
            } else {
                basket.put(item, amount);
            }
            return true;
        }
        return false;
    }

    @Override
    public void setToZero() {
        if (!basket.isEmpty()) {
            for (Map.Entry<Item, Integer> entry : basket.entrySet()) {
                store.addItem(entry.getKey(), entry.getValue());
            }
            basket.clear();
        }
    }

    public void buy() {
        basket.clear();
    }

    @Override
    public boolean takeItem(Item item, int amount) {
        store.addItem(item, amount);
        if (basket.get(item) == amount) {
            basket.remove(item);
        } else {
            basket.put(item, basket.get(item) - amount);
        }
        return true;
    }

    public void createAnOrder() {
        if (!basket.isEmpty()) {
            double sum = 0.00;
            for (Map.Entry<Item, Integer> entry : basket.entrySet()) {
                System.out.printf("%-10s %6.2f %4d %10.2f\n", entry.getKey().getName(), entry.getKey().getPrice(),
                        entry.getValue(), entry.getKey().getPrice() * entry.getValue());
                sum += entry.getKey().getPrice() * entry.getValue();
            }
            System.out.printf("%-10s %22.2f\n", "Итого", sum);
        } else {
            System.out.println("Корзина пуста!");
        }
    }
}
