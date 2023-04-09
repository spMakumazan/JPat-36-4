public class Main {
    public static void main(String[] args) {
        System.out.println("Создадим магазин и добавим в него товары");
        Store store = new Store(1000);

        Item sugar = new GroceryItem("Sugar", 50.45);
        store.addItem(sugar, 58);

        Item buckwheat = new GroceryItem("Buckwheat", 60.28);
        store.addItem(buckwheat, 67);

        Item coffee = new GroceryItem("Coffee", 200.27);
        store.addItem(coffee, 155);

        Item tea = new GroceryItem("Tea", 150.88);
        store.addItem(tea, 104);

        Item salt = new GroceryItem("Salt", 20.22);
        store.addItem(salt, 162);

        Item banana = new Fruit("Banana", 60.66);
        store.addItem(banana, 74);

        Item orange = new Fruit("Orange", 45.47);
        store.addItem(orange, 182);

        Item apple = new Fruit("Apple", 47.92);
        store.addItem(apple, 113);

        Item cucumber = new Item("Cucumber", "Vegetables", 58.83);
        store.addItem(cucumber, 35);

        store.addItem(sugar, 48);

        System.out.println();
        System.out.println("Посмотрим на список товаров магазина");
        store.printProductList();

        System.out.println();
        System.out.println("Отдельно список бакалейных товаров:");
        store.printSortedProductList(new CategoryFilter(), "Grocery");

        System.out.println();
        System.out.println("Список товаров с ценой меньше 100.00 рублей:");
        store.printSortedProductList(new MaxPriceFilter(), 100.00);

        System.out.println();
        System.out.println("Добавим товары в корзину");
        Basket basket = new Basket(store);
        basket.addItem(sugar, 10);
        basket.addItem(apple, 20);
        basket.addItem(cucumber, 5);

        System.out.println();
        System.out.println("Сформируем чек");
        basket.createAnOrder();

        System.out.println();
        System.out.println("Вернем половину яблок в магазин");
        basket.takeItem(apple, 10);

        System.out.println();
        System.out.println("Посмотрим, что получилось в итоге");
        basket.createAnOrder();

        System.out.println();
        System.out.println("Совершаем покупку и смотрим остатки товаров в магазине");
        basket.buy();
        store.printProductList();
    }
}
