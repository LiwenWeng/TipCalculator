public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.printMenu();
        System.out.println(menu.getPrice("1"));
    }
}
