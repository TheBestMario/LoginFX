package classes;

import java.util.*;

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

    public static Map<String, Boolean> ProfileCheck(String username, String password) {
        Map<String, Boolean> map = new HashMap<>();

        //making test profiles saved.
        Profile.getProfileArray()[0] = new Profile("Luigi", "fakeman123");
        Profile.getProfileArray()[1] = new Admin("MarioG", "password");


        for (Profile profile: Profile.getProfileArray()){

            if (profile == null){
                map.put("userExists",false);
                break;
            }
            if (profile.username.equalsIgnoreCase(username)){
                map.put("userExists",true);

                if (profile.checkPassword(password)){
                    map.put("pwdMatches",true);
                    System.out.println(map);
                }else{
                    map.put("pwdMatches",false);
                }

            }else{
                map.put("userExists",false);
            }
        }

        return map;

    }
}
