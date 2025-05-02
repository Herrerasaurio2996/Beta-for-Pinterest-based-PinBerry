package Workshops.Workshop2.Classes;

import java.util.ArrayList;

public class AuthenticationService {
    private ArrayList<User> registeredUsers;
    private ArrayList<User> activeSessions;

    public AuthenticationService() {
        this.registeredUsers = new ArrayList<>();
        this.activeSessions = new ArrayList<>();
    }

    public boolean registerUser(User user) {
        if (user != null && !userExists(user.getUsername())) {
            registeredUsers.add(user);
            System.out.println("User successfully registered.");
            return true;
        }
        System.out.println("Could not be registered: already exists or is invalid.");
        return false;
    }

    public boolean verifyCredentials(String username, String password) {
        for (User user : registeredUsers) {
            if (user.getUsername().equals(username)) {
                return user.login(password); // usa el método login() de la clase User
            }
        }
        return false;
    }

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

    public boolean invalidateSession(String username) {
        for (User user : activeSessions) {
            if (user.getUsername().equals(username)) {
                user.logout(); 
                activeSessions.remove(user);
                System.out.println("Closed session for: " + username);
                return true;
            }
        }
        System.out.println("There is no active session for that user.");
        return false;
    }

    private boolean userExists(String username) {
        for (User u : registeredUsers) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
