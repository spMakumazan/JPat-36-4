import java.util.HashMap;
import java.util.Map;

public class CategoryFilter implements Filter<String> {

    @Override
    public Map<Item, Integer> filter(Map<Item, Integer> storage, String category) {
        Map<Item, Integer> newStorage = new HashMap<>();
        for (Map.Entry<Item, Integer> entry : storage.entrySet()) {
            if (entry.getKey().getCategory().equals(category)) {
                newStorage.put(entry.getKey(), entry.getValue());
            }
        }
        return newStorage;
    }
}
