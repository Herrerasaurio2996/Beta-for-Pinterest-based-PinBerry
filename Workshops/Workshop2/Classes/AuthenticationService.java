package Workshops.Workshop2.Classes;

import java.util.ArrayList;

public class AuthenticationService {

    // List of all registered users
    private ArrayList<User> registeredUsers;

    // List of users with active sessions
    private ArrayList<User> activeSessions;

    // Constructor: initializes both user lists
    public AuthenticationService() {
        this.registeredUsers = new ArrayList<>();
        this.activeSessions = new ArrayList<>();
    }


      /**
     * Registers a new user if it's valid and not already registered.
     * @param user the User object to register
     * @return true if the user was successfully registered
     */
    public boolean registerUser(User user) {
        if (user != null && !userExists(user.getUsername())) {
            registeredUsers.add(user);
            System.out.println("User successfully registered.");
            return true;
        }
        System.out.println("Could not be registered: already exists or is invalid.");
        return false;
    }

    /**
     * Verifies the credentials of a user using the login method in User class.
     * Note: this does not create a session.
     * @param username the user's username
     * @param password the user's password
     * @return true if the credentials are correct
     */
    public boolean verifyCredentials(String username, String password) {
        for (User user : registeredUsers) {
            if (user.getUsername().equals(username)) {
                return user.login(password);  // Uses the User's login() method
            }
        }
        return false;
    }

      /**
     * Creates an active session for a user if the credentials are valid.
     * Adds them to the activeSessions list.
     * @param username the user's username
     * @param password the user's password
     * @return true if session is created
     */
    public boolean createSession(String username, String password) {
        for (User user : registeredUsers) {
            if (user.getUsername().equals(username) && user.login(password)) {
                if (!activeSessions.contains(user)) {
                    activeSessions.add(user);
                    System.out.println("Session started for: " + username);
                } else {
                    System.out.println("There is already an active session.");
                }
                return true;
            }
        }
        System.out.println("Incorrect credentials.");
        return false;
    }

     /**
     * Ends the session of the user if they are in the activeSessions list.
     * @param username the user's username
     * @return true if session was found and ended
     */
    public boolean invalidateSession(String username) {
        for (User user : activeSessions) {
            if (user.getUsername().equals(username)) {
                user.logout(); // Uses the User's logout() method
                activeSessions.remove(user);
                System.out.println("Closed session for: " + username);
                return true;
            }
        }
        System.out.println("There is no active session for that user.");
        return false;
    }

     /**
     * Helper method to check if a username is already registered.
     * @param username the username to check
     * @return true if the user exists
     */
    private boolean userExists(String username) {
        for (User u : registeredUsers) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
