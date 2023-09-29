import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    // {"id", "name", "price"}
    String[][] menu = {
            {"0", "Spicy McCrispy", "4.79"},
            {"1", "Big Mac", "5.58"},
            {"2", "6-Piece Chicken McNuggets", "2.50"},
            {"3", "Quarter Pounder with Cheese", "3.79"},
            {"4", "Egg McMuffin", "2.79"},
            {"5", "2 Sausage Burrito", "2.39"},
            {"6", "Medium Iced Coffee", "1.79"},
            {"7", "Custom", "???"}
    };

    double getPrice(String foodId) {
        if (foodId.equals("7")) {
            return 0;
        }

        for (String[] food : menu) {
            if (food[0].equals(foodId)) {
                return Double.parseDouble(food[2]);
            }
        }

        return 0;
    }

    String getName(String index) {
        return menu[Integer.parseInt(index)][1];
    }

    // [1]: Big Mac  $5.58
    void printMenu() {
        System.out.println("Menu");
        for (String[] food : menu) {
            System.out.printf("[%1$s]: %2$s  $%3$s%n", food[0], food[1], food[2]);
        }
        System.out.println("[-1]: Done");
        System.out.println("[-2]: Leave\n");
    }
}
