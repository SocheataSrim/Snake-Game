import java.util.List;

class RegisteredUser extends User {
    public RegisteredUser(String name, String password) {
        super(name, password);
    }

    @Override
    public boolean authenticate() {
        List<RegisteredUser> users = Register.getUsers();
        for (RegisteredUser registeredUser : users) {
            if (registeredUser.getName().equals(getName()) && registeredUser.getPassword().equals(getPassword())) {
                System.out.println("Login successful!");
                return true;
            }
        }
        System.out.println("Login failed!");
        return false;
    }
}
