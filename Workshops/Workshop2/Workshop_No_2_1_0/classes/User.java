package Workshops.Workshop2.Workshop_No_2_1_0.classes;

public class User {

    // Public attribute for the user's profile picture (not recommended to be public)
    public String profilePicture;
    // Private attributes for encapsulation
    private String username;
    private String password;

    // Indicates whether the user is currently logged in
    public boolean isLoggedIn;

    // Constructor to initialize a user with username, password, and profile picture

    public User (String username, String password, String profilePicture) {
        this.username = username;
        this.password = password;
        this.profilePicture = profilePicture;
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

     // Simulates uploading the photo
     public void uploadpicture() {
        System.out.println("Photo upload Succefully");
    }
/**
 * Requests the deletion of a photo through the StorageService.
 * 
 * This method verifies that the photo is not null and is currently active
 * (not already deleted). If the checks pass, it delegates the deletion
 * task to the StorageService. If the deletion is successful, it prints
 * a confirmation message including the user's name and the photo's file name.
 * 
 * @param photo   The Photo object to be deleted.
 * @param storage The StorageService instance that handles deletion logic.
 * @return true if the photo was successfully deleted, false if the photo
 *         was already deleted, null, or deletion failed.
 */
public boolean deletePicture(Photo photo, StorageService storage) {
    return storage.deletePhoto(photo);
}
public boolean uploadPicture(Photo photo, StorageService storage) {
    return storage.uploadPhoto(photo);
}

public boolean uploadProfilePicture(String newPicturePath, StorageService storage) {
    return storage.uploadProfilePicture(null, newPicturePath);
}

public boolean downloadPicture(Photo photo, StorageService storage) {
    return storage.downloadPhoto(photo);
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