import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Order {
    private String name;
    private int numberOfPeople;
    private double totalCost = 0;
    private int tipPercentage;
    private ArrayList<String[]> items = new ArrayList<>();

    public void orderFood(String order, Scanner scan, Menu menu) {
        Main.clearScreen();
        int numberOfItems;
        String itemName;
        double itemCost;

        // Check if this is right after they pick order in the menu screen
        if (order.equals("first")) {
            System.out.print("Waiter: What is your name? ");
            name = scan.nextLine();

            System.out.print("Waiter: How many people are in your group? ");
            numberOfPeople = scan.nextInt();
            scan.nextLine();
            Main.clearScreen();
        }

        while (!order.equals("-2")) {
            menu.printMenu();
            System.out.print("Waiter: " + ((order.equals("false")) ?
                    "Sorry, I didn't understand. Please say it again: " :
                    "What would you like to order? "));
            order = scan.nextLine();

            double price = menu.getPrice(order);

            // Custom order option
            if (order.equals("7")) {
                System.out.print("Waiter: What is the name of the item? ");
                itemName = scan.nextLine();

                System.out.print("Waiter: How many items? ");
                numberOfItems = scan.nextInt();
                scan.nextLine();

                System.out.print("Waiter: How much does each cost? $");
                itemCost = scan.nextDouble();
                scan.nextLine();
                totalCost += itemCost * numberOfItems;

                items.add(new String[]{itemName, String.format("%.2f", itemCost * numberOfItems), Integer.toString(numberOfItems)});
                orderFood("true", scan, menu);
                break;

            // User finished ordering
            } else if (order.equals("-1")) {
                Main.clearScreen();
                System.out.println("Waiter: Alright! Tip will be much appreciated! :D");
                System.out.print("Please enter how much you would like to tip as a percentage: %");
                tipPercentage = scan.nextInt();
                scan.nextLine();

                if (tipPercentage == 0) {
                    System.out.println("Waiter: Ok.");
                } else if (tipPercentage <= 20) {
                    System.out.println("Waiter: Thank you for the tip! :)");
                } else if (tipPercentage <= 50) {
                    System.out.println("Waiter: Wow! This is a lot, thank you so much! :D");
                } else {
                    System.out.println("Waiter: Are you serious?! Thank you so much! I really appreciate you! <3");
                }

                // Receipt
                System.out.println("\nWaiter: Here is your receipt and food. Enjoy the rest of your day!\n");
                Receipt receipt = new Receipt(name, items, totalCost, tipPercentage, numberOfPeople);
                System.out.println(receipt.getReceipt());
                scan.nextLine();
                break;

            // Leave option
            } else if (order.equals("-2")) {
                System.out.println("Waiter: Bye, have a great day!");
                return;

            // User picks from the default menu
            } else if (Arrays.asList(new String[]{"0", "1", "2", "3", "4", "5", "6"}).contains(order)) {
                System.out.print("Waiter: How many do you want to order? ");
                numberOfItems = scan.nextInt();
                scan.nextLine();

                totalCost += price * numberOfItems;
                items.add(new String[]{menu.getName(order), String.format("%.2f", price * numberOfItems), Integer.toString(numberOfItems)});
                orderFood("true", scan, menu);
                break;

            // User inputs something else
            } else {
                orderFood("false", scan, menu);
                break;
            }
        }
    }
}
