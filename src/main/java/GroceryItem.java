public class GroceryItem extends Item {
    public GroceryItem(String name, double price) {
        super(name, price);
        this.setCategory("Grocery");
    }
}
