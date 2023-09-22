import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    // Variables
    int numberOfPeople = 0;

    // Custom Item Order
    private int numberOfItems;
    private ArrayList<String[]> items = new ArrayList<>();
    private double totalCost = 0;

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
        for (String[] food : menu) {
            if (food[0].equals(foodId)) {
                return Double.parseDouble(food[2]);
            }
        }
        return 0;
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

    void orderFood(String order, Scanner scan, Menu menu) {
        Main.clearScreen();
        double tipPercentage;
        String itemName;
        double itemCost;

        if (order == "") {
            System.out.print("Waiter: How many people are in your group? ");
            numberOfPeople = scan.nextInt();
            scan.nextLine();
            System.out.println();
        }


        while (!order.equals("-2")) {
            menu.printMenu();
            System.out.print("Waiter: " + ((order.equals("false")) ?
                    "Sorry, I didn't understand. Please say it again: " :
                    "What would you like to order? "));
            order = scan.nextLine();

            double price = menu.getPrice((order.equals("7")) ? "0" : order);
            switch (order) {
                case "0":
                    // Testing
//                    System.out.println(Arrays.toString(items.get(0)));
//                    System.out.println(Arrays.toString(items.get(1)));
//                    System.out.println(numberOfItems);
//                    System.out.println(numberOfPeople);
//                    System.out.println(totalCost);
                    break;
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":
                    System.out.print("Waiter: What is the name of the item? ");
                    itemName = scan.nextLine();

                    System.out.print("Waiter: How much does it cost? $");
                    itemCost = scan.nextDouble();
                    totalCost += itemCost;
                    scan.nextLine();

                    numberOfItems++;
                    items.add(new String[]{itemName, String.format("%.2f", itemCost)});
                    orderFood("true", scan, menu);
                    return;
                case "-1":

                    return;
                case "-2":
                    System.out.println("Waiter: Have a great day!");
                    return;
                default:
                    orderFood("false", scan, menu);
                    return;
            }
        }
    }
}
