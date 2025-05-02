package Workshops.Workshop2.Classes;

public class User {
    public String profilepicture;
    private String username;
    private String password;
    public boolean isLoggedIn;

    public User (String username, String password, String profilepicture) {
        this.username = username;
        this.password = password;
        this.profilepicture = profilepicture;
        this.isLoggedIn = false;
    }

    public boolean login(String inputPassword) {
        if (this.password.equals(inputPassword)) {
            this.isLoggedIn = true;
        }
        return false;
    }

    public void logout() {
        this.isLoggedIn = false;
    }

    public boolean setupdatePassword (String actualpassword, String newpassword) {
        if (this.password.equals(actualpassword)) {
            this.password = newpassword;
            System.out.println("Password changed successfully");
            return true;
        }
        System.out.println("Incorrect password");
        return false;
    }

    public boolean setProfilePicture(String newpicture) {
        if (newpicture != null && !newpicture.isEmpty()) {
            this.profilepicture = newpicture;
            System.out.println("Profile picture changed sucessfully");
            return true;
        }
        System.out.println("Can't change profile picture");
        return true;
    }

    public String getUsername() {
        return username;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}




