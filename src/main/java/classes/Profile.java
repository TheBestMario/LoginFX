package classes;
public class Profile {
    private String username;
    private String password;

    private boolean loggedIn = false;
    private static Profile[] profiles = new Profile[10];
    public Profile(String username, String password) {
        this.username = username;
        this.password = password;

    }
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    public boolean isLoggedIn() {
        return loggedIn;
    }

    public Profile(String username){
        this(username, null);
    }

    public void welcomeMessage(){
        System.out.println("Successful login, "+ username);
    }

    public String getUsername() {
        return username;
    }

    //for the sake of testing, we use this method to set some profiles
    public static Profile[] getProfileArray() {
        return profiles;
    }
    public static void addProfile(Profile profile){
        for (int i = 0; i < profiles.length; i++) {
            if (profiles[i] == null) {
                profiles[i] = profile;
                break;
            }
        }
    }

    public boolean checkPassword(String password){
        if (this.password == null) {
            return false;
        }
        return this.password.equals(password);
    }
    public static boolean checkUserNameExists(String username){
        for (Profile profile : profiles) {
            if (profile != null && profile.username.equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    public static Profile getProfile(String username){
        for (Profile profile : profiles) {
            if (profile != null && profile.username.equalsIgnoreCase(username)) {
                return profile;
            }
        }
        return null;
    }

    public static boolean checkUserNamePasses(String username){
        boolean result = false;
        if (username.isBlank()) {
            System.out.println("Username cannot be empty or only have spaces");
        }
        return result;
    }
    public static void ProfileCheck() {

        //making test profiles saved.
        Profile.getProfileArray()[0] = new Profile("Luigi", "fakeman123");
        Profile.getProfileArray()[1] = new Admin("MarioG", "QwErTy123");
        String username;
        String password;
        Profile currentLogin = null;


        while (currentLogin == null) {
            System.out.println("""
                Login Menu
                Enter Username:""");

            //checks if the username is empty or only has spaces
            //>if it is, it will prompt the user to enter a valid username and loop again
            //>if not, it will ask for password, then check if the password is empty or only has spaces
            //>>if true, uses same while loop
            //>>if false, checks if the username exists in array of Profiles
            username = "";
            password = "";
            if (username.isBlank()) {
                System.out.println("Username cannot be empty or only have spaces");
                continue;
            }

            System.out.println("Enter Password:");
            if (password.isBlank()) {
                System.out.println("password cannot be empty or only have spaces");
                continue;
            }

            Profile attemptedLogin = new Profile(username, password);
            boolean profileExists = Profile.checkUserNameExists(username);
            Profile profile = Profile.getProfile(username);
            if (!profileExists) {
                System.out.println("""
                    Creating new profile...
                    """);
                currentLogin = new Profile(username, password);
                currentLogin.setLoggedIn(true);
                //adds profile to the last index of the array
                //realistically would add to the last empty index
                Profile.addProfile(currentLogin);

            }else if (profileExists && profile.checkPassword(password)) {
                currentLogin = Profile.getProfile(attemptedLogin.getUsername());
                currentLogin.setLoggedIn(true);
            }else
                System.out.println("""
                     The username and password combination is incorrect.
                     Please use correct details or use a new unique username.
                     """);


        }
        currentLogin.welcomeMessage();

    }
}
