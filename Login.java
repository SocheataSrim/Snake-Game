import java.util.List;

class Login {
    private static List<RegisteredUser> users = Register.getUsers();

    public static boolean loginUser(User user) {
        return user.authenticate();
    }

    public static boolean VerifyUserName(String userName) {
        for (RegisteredUser user : users) {
            if (user.getName().equals(userName)) {
                System.out.println("Username already exists!");
                return true;
            }
        }
        return false;
    }
}




