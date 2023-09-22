import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scan = new Scanner(System.in);

        // Variables
        String input = "";

        // Main Program
        menuScreen(input, scan, menu);
    }

    static void clearScreen() {
        for (int i = 0; i < 25; i++){
            System.out.println();
        }
    }

    static void menuScreen(String input, Scanner scan, Menu menu) {
        clearScreen();
        while (true) {
            System.out.println("[1]: Order");
            System.out.println("[2]: Leave\n");
            System.out.print("Waiter: " + ((input.equals("-1")) ?
                    "Sorry, I didn't understand. Please say it again: " :
                    "Welcome to McDonald's! How can I help you? "));
            input = scan.nextLine();

            switch (input) {
                case "1":
                    String order = "";
                    menu.orderFood(order, scan, menu);
                    return;
                case "2":
                    System.out.println("Waiter: Have a great day!");
                    return;
                default:
                    menuScreen("-1", scan, menu);
                    return;
            }
        }
    }
}