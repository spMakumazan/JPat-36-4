import java.util.Map;

public interface Filter<T> {
    Map<Item, Integer> filter(Map<Item, Integer> storage, T parameter);
}
