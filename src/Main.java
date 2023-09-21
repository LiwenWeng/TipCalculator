import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scan = new Scanner(System.in);

        // Variables
        String input = "";

        // Main Program
        menuScreen(input, scan, false);
    }

    static void clearScreen() {
        for (int i = 0; i < 25; i++){
            System.out.println();
        }
    }

    static void menuScreen(String input, Scanner scan, boolean invalidInput) {
        clearScreen();
        while (true) {
            System.out.println("Waiter: " + ((invalidInput) ?
                    "Sorry, I didn't understand. Please say it again." :
                    "Welcome to McDonald's! How can I help you?"));
            System.out.println("[1]: Order");
            System.out.println("[2]: Leave");
            System.out.print("> ");
            input = scan.nextLine();

            switch (input) {
                case "1":
                    orderFood();
                    return;
                case "2":
                    System.out.println("Waiter: Have a great day!");
                    return;
                default:
                    menuScreen("2", scan, true);
                    return;
            }
        }
    }

    static void orderFood() {
        clearScreen();
        System.out.println("test");

    }
}