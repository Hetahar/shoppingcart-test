import classes.Item;
import classes.ShoppingCart;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a language: ");
        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Japanese");
        System.out.println("4. Swedish");

        int choice = scanner.nextInt();
        Locale locale;

        switch (choice) {
            case 1:
                System.out.println("You selected English.");
                locale = new Locale("en", "US");
                break;
            case 2:
                System.out.println("You selected Finnish.");
                locale = new Locale("fi", "FI");
                break;
            case 3:
                System.out.println("You selected Japanese.");
                locale = new Locale("ja", "JP");
                break;
            case 4:
                System.out.println("You selected Swedish.");
                locale = new Locale("sv", "SE");
                break;
            default:
                System.out.println("Invalid language.");
                locale = new Locale("en", "US");
                break;
        }

        ResourceBundle rb;
        try {
            rb = ResourceBundle.getBundle("prompts", locale);
        } catch (Exception e) {
            System.out.println("Invalid language.");
            rb = ResourceBundle.getBundle("prompts", new Locale("en", "US"));
        }

        System.out.println(rb.getString("number"));
        int number = scanner.nextInt();
        int totalPrice = 0;

        for (int i = 1; i <= number; i++) {
            System.out.println(rb.getString("price"));
            int price = scanner.nextInt();
            Item item = new Item(price);
            System.out.println(rb.getString("amount"));
            int amount = scanner.nextInt();

            for (int j = 0; j < amount; j++) {
                cart.addItem(item);
            }
        }
        totalPrice = cart.calculateTotal();
        System.out.println(rb.getString("total") + totalPrice);
    }
}
