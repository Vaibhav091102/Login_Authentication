import java.util.HashMap;
import java.util.Scanner;

public class SimpleAuthSystem {
    private static HashMap<String, String> users = new HashMap<>();
    private static boolean loggedIn = false;

    public static void register(Scanner scanner) {
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Try another one.");
            return;
        }

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        
        users.put(username, password);
        System.out.println("User registered successfully!");
    }

    public static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            loggedIn = true;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    public static void accessSecuredPage() {
        if (loggedIn) {
            System.out.println("Welcome to the secured page!");
        } else {
            System.out.println("Access denied. You need to log in first.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String option;

        while (true) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Access Secured Page");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    register(scanner);
                    break;
                case "2":
                    login(scanner);
                    break;
                case "3":
                    accessSecuredPage();
                    break;
                case "4":
                    System.out.println("Exiting system.");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
