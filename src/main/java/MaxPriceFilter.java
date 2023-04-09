import java.util.HashMap;
import java.util.Map;

public class MaxPriceFilter implements Filter<Double> {
    @Override
    public Map<Item, Integer> filter(Map<Item, Integer> storage, Double maxPrice) {
        Map<Item, Integer> newStorage = new HashMap<>();
        for (Map.Entry<Item, Integer> entry : storage.entrySet()) {
            if (entry.getKey().getPrice() <= maxPrice) {
                newStorage.put(entry.getKey(), entry.getValue());
            }
        }
        return newStorage;
    }
}
