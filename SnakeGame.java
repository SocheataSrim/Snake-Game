import java.util.InputMismatchException;
import java.util.Scanner;

public class SnakeGame {
    public static void main(String[] args) {
        // Setting up scanner and variables
        Scanner sc = new Scanner(System.in);
        String tmpName;
        String tmpPassword;
        int choice;
        boolean isLogin = false;
        User user = null;

        // Print out the registration/login screen
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Play as Unregistered User");
        System.out.println("4. Quit");

        // Input error handling
        while (true) {
            try {
                System.out.print("Enter your option (1 - 4): ");
                choice = sc.nextInt();
                sc.nextLine(); // Consume the newline character
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                sc.nextLine();
            }
        }

        switch (choice) {
            case 1:
                do {
                    System.out.println("Input name: ");
                    tmpName = sc.nextLine();
                } while (Login.VerifyUserName(tmpName));
                System.out.println("Input password: ");
                tmpPassword = sc.nextLine();
                Register.registerUser(tmpName, tmpPassword);
                user = new RegisteredUser(tmpName, tmpPassword);
                isLogin = true;
                break;
            case 2:
                System.out.print("Input name: ");
                tmpName = sc.nextLine();
                System.out.print("Input password: ");
                tmpPassword = sc.nextLine();
                user = new RegisteredUser(tmpName, tmpPassword);
                isLogin = Login.loginUser(user);
                break;
            case 3:
                System.out.println("You are playing as an Unregistered User.");
                System.out.print("Input name: ");
                tmpName = sc.nextLine();
                user = new UnregisteredUser(tmpName);
                isLogin = Login.loginUser(user);
                break;
            case 4:
                System.out.println("Thank you for playing.");
                break;
            default:
                break;
        }

        sc.close();

        // If the user is login or exists, then the game will run
        if (isLogin) {
            user.playGame();
            Game level1 = new Game(1, 20, 750, 20, 20);
        } else {
            System.out.println("Failed to login!");
        }
    }
}
