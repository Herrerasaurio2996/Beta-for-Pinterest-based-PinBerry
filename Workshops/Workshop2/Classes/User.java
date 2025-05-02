package Workshops.Workshop2.Classes;

public class User {

    // Public attribute for the user's profile picture (not recommended to be public)
    public String profilepicture;

    // Private attributes for encapsulation
    private String username;
    private String password;

    // Indicates whether the user is currently logged in
    public boolean isLoggedIn;

    // Constructor to initialize a user with username, password, and profile picture

    public User (String username, String password, String profilepicture) {
        this.username = username;
        this.password = password;
        this.profilepicture = profilepicture;
        this.isLoggedIn = false; // User starts as logged out
    }

    // Tries to log in the user by comparing input password with the stored one
    public boolean login(String inputPassword) {
        if (this.password.equals(inputPassword)) {
            this.isLoggedIn = true;// Successful login
        }
        return false;// Incorrect password
    }

    // Logs out the user
    public void logout() {
        this.isLoggedIn = false;
    }

    // Attempts to update the password after verifying the current one
    public boolean setupdatePassword (String actualpassword, String newpassword) {
        if (this.password.equals(actualpassword)) {
            this.password = newpassword;
            System.out.println("Password changed successfully");
            return true;
        }
        System.out.println("Incorrect password");
        return false;
    }
    // Updates the profile picture if the new picture string is valid
    public boolean setProfilePicture(String newpicture) {
        if (newpicture != null && !newpicture.isEmpty()) {
            this.profilepicture = newpicture;
            System.out.println("Profile picture changed sucessfully");
            return true;
        }
        System.out.println("Can't change profile picture");
        return true;  // Note: always returns true, even if change failed — this may be a logic mistake
    }

    // Returns the username
    public String getUsername() {
        return username;
    }

    // Returns whether the user is logged in
    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}




