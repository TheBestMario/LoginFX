package classes;

public class Admin extends Profile {
    public Admin(String username, String password) {
        super(username, password);
    }

    public void welcomeMessage() {
        System.out.println("Welcome Admin, " + getUsername());
    }
}
