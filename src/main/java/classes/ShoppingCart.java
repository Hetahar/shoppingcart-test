package classes;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List <Item> items;

    public ShoppingCart() {
        this.items = new ArrayList();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public int calculateTotal() {
        int total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
}
