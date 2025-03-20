package classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    ShoppingCart cart = new ShoppingCart();

    @BeforeEach
    void setUp() {
        Item item = new Item(10);
        Item item2 = new Item(20);
        cart.addItem(item);
        cart.addItem(item2);
    }

    @Test
    void addItem() {
        Item item = new Item(10);
        cart.addItem(item);
        assertEquals(3, cart.items.size());
    }

    @Test
    void calculateTotal() {
        assertEquals(30, cart.calculateTotal());
    }
}