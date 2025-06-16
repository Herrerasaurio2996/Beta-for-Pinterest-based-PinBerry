import java.util.ArrayList;
import java.util.List;

public class User {
    private String name = "";
    private String password = "";
    private List<Folder> folders = new ArrayList<>();

    public User(String name, String password, List<Folder> folders) {
        this.name = name;
        this.password = password;
        this.folders = folders;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public void register(String name, String password) {
        this.name = name;
        this.password = password;
        System.out.println("User registered successfully");
    }

    public void login(String name, String password) {
        if (this.name.equals(name) && this.password.equals(password)) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
    }

    public void addMultimedia(Multimedia multimedia) {
        if (folders != null && !folders.isEmpty()) {
            folders.get(0).addMultimedia(multimedia);
        } else {
            System.out.println("No folders available to add multimedia.");
        }
    }

    public void eliminateMultimedia(Multimedia multimedia) {
        if (folders != null && !folders.isEmpty()) {
            folders.get(0).removeMultimedia(multimedia);
        } else {
            System.out.println("No folders available to delete multimedia.");
        }
    }

    public void saveMultimedia(Multimedia multimedia) {
        if (folders != null && !folders.isEmpty()) {
            folders.get(0).saveMultimedia(multimedia);
        } else {
            System.out.println("No folders available to save multimedia.");
        }
    }
}
