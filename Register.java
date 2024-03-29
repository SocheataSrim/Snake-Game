import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Register {
    private static List<RegisteredUser> users = new ArrayList<>();
    private static final String FILE_PATH = "users.txt";

    static {
        // Load existing users from file
        loadUsers();
    }

    private static void loadUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.add(new RegisteredUser(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            System.out.println(FILE_PATH + " does't exist.");
        }
    }

    private static void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (RegisteredUser user : users) {
                writer.write(user.getName() + "," + user.getPassword() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void registerUser(String name, String password) {
        RegisteredUser newUser = new RegisteredUser(name, password);
        users.add(newUser);
        System.out.println("User registered successfully!");
        saveUsers();
    }

    public static List<RegisteredUser> getUsers() {
        return users;
    }
}
