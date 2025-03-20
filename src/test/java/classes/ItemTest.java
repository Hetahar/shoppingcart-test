package classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void getPrice() {
        Item item = new Item(10);
        assertEquals(10, item.getPrice());

        Item item2 = new Item(20);
        assertEquals(20, item2.getPrice());
    }
}