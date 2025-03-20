import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testCountPrice() {
        assertEquals(20, Main.countPrice(4, 5));
        assertEquals(0, Main.countPrice(0, 5));
        assertEquals(0, Main.countPrice(4, 0));
        assertEquals(100, Main.countPrice(10, 10));
    }
}