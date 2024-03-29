class UnregisteredUser extends User {
    public UnregisteredUser(String name) {
        super(name, null); // Unregistered user without a password
    }

    @Override
    public boolean authenticate() {
        // Unregistered users are always considered authenticated
        return true;
    }

    @Override
    public void playGame() {
        System.out.println(getName() + " is playing the game as an Unregistered User.");
    }
}
