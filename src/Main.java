import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Order order = new Order();

        String input = "";

        while (!input.equals("2")) {
            clearScreen();
            System.out.println("[1]: Order");
            System.out.println("[2]: Leave\n");
            System.out.print("Waiter: " + ((input.equals("invalid") ?
                    "Sorry, I didn't understand. Please say it again: " :
                    "Welcome to McDonald's! How can I help you? ")));

            input = scanner.nextLine();

            switch (input) {
                case "1":
                    order.orderFood("first", scanner, menu);
                    break;

                case "2":
                    System.out.println("Waiter: Bye, have a great day!");
                    break;

                default:
                    input = "invalid";
            }
        }
    }

    public static void clearScreen() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }
}