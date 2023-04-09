import java.util.HashMap;
import java.util.Map;

public class Store implements StoreAble {
    private final int totalCapacity;
    private Map<Item, Integer> storage;
    private int capacity;

    public Store(int totalCapacity) {
        storage = new HashMap<>();
        this.totalCapacity = totalCapacity;
        capacity = totalCapacity;
    }

    @Override
    public boolean addItem(Item item, int amount) {
        if (capacity == 0) {
            System.out.println("Склад магазина заполнен");
            return false;
        } else if (amount > capacity) {
            System.out.println("В магазин нельзя добавить такое количество товара\n" +
                    "На складе осталось места на " + capacity + " единиц товара");
            return false;
        } else if (storage.containsKey(item)) {
            storage.put(item, storage.get(item) + amount);
            capacity -= amount;
            return true;
        } else {
            storage.put(item, amount);
            capacity -= amount;
            return true;
        }
    }

    @Override
    public void setToZero() {
        storage.clear();
        capacity = totalCapacity;
    }

    @Override
    public boolean takeItem(Item item, int amount) {
        if (capacity == totalCapacity) {
            System.out.println("Склад магазина пуст");
            return false;
        } else if (!storage.containsKey(item)) {
            System.out.println("На складе нет такого товара");
            return false;
        } else if (storage.get(item) < amount) {
            System.out.printf("На складе осталось %d единиц товара\n", storage.get(item));
            return false;
        } else {
            storage.put(item, storage.get(item) - amount);
            capacity += amount;
            return true;
        }
    }

    public void printProductList() {
        if (!storage.isEmpty()) {
            for (Map.Entry<Item, Integer> entry : storage.entrySet()) {
                System.out.println(entry.getKey() + " (на складе: " + entry.getValue() + ")");
            }
        } else {
            System.out.println("В магазине нечего продавать!");
        }
    }

    public <T> void printSortedProductList(Filter<T> filter, T parameter) {
        Map<Item, Integer> newProducts = filter.filter(storage, parameter);
        if (!newProducts.isEmpty()) {
            for (Map.Entry<Item, Integer> entry : newProducts.entrySet()) {
                System.out.println(entry.getKey() + " (на складе: " + entry.getValue() + ")");
            }
        } else {
            System.out.println("В магазине нет товаров, удовлетворяющих условиям поиска!");
        }
    }
}
