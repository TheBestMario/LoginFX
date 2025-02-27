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


    public Profile(String username){
        this(username, null);
    }

    public String getUsername() {
        return username;
    }

    //for the sake of testing, we use this method to set some profiles
    public static Profile[] getProfileArray() {
        return profiles;
    }
    public static void addProfile(Profile profile){
        System.out.println("adding Profile to list "+profile.getUsername());
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

    public static Map<String, Boolean> ProfileCheckRegistration(String username, String password) {
        Map<String, Boolean> map = new HashMap<>();

        for (Profile profile : profiles) {

            if (profile == null) {
                map.put("userExists", false);
                break;
            }
            if (profile.username.equalsIgnoreCase(username)) {
                map.put("userExists", true);

                if (profile.checkPassword(password)) {
                    map.put("pwdMatches", true);
                    System.out.println(map);
                } else {
                    map.put("pwdMatches", false);
                }

            } else {
                map.put("userExists", false);
            }
        }

        return map;
    }

    public static boolean ProfileCheck(String username, String password) {
        for (Profile profile : profiles){
            if (profile == null){
                continue;
            }

            String existingName = profile.getUsername();
            boolean existingPasswordMatches = profile.checkPassword(password);

            if (existingName.equals(username) && existingPasswordMatches){
                System.out.println("Logging in...");
                return true;
            } else if (existingName.equals(username) && !existingPasswordMatches) {
                //could customise the warning here.
                System.out.println("Incorrect password");
                return false;
            }
        }
        System.out.println("User doesn't exist");
    return false;
    }
}
