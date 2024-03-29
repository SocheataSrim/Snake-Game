abstract class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    protected String getPassword() {
        return password;
    }

    public void playGame() {
        System.out.println(name + " is playing the game.");
    }

    @Override
    public String toString() {
        return "User [name=" + name + "]";
    }

    // Abstract method for user authentication
    public abstract boolean authenticate();
}
