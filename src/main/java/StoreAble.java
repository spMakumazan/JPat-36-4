public interface StoreAble {
    boolean addItem(Item item, int amount);

    void setToZero();

    boolean takeItem(Item item, int amount);
}
