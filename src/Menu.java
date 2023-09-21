public class Menu {
    String[][] menu = {
            {"0", "Spicy McCrispy", "4.79"},
            {"1", "Big Mac", "5.58"},
            {"2", "6-Piece Chicken McNuggets", "2.50"},
            {"3", "Quarter Pounder with Cheese", "3.79"},
            {"4", "Egg McMuffin", "2.79"},
            {"5", "2 Sausage Burrito", "2.39"},
            {"6", "Medium Iced Coffee", "1.79"},
    };

    double getPrice(String foodId) {
        for (String[] food : menu) {
            if (food[0].equals(foodId)) {
                return Double.parseDouble(food[2]);
            }
        }
        return 0;
    }

    // [1]: Big Mac  $5.58
    void printMenu() {
        for (String[] food : menu) {
            System.out.printf("[%1$s]: %2$s  $%3$.2f%n", food[0], food[1], Double.parseDouble(food[2]));
        }
    }

}
