import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String folderName = "";
    private List<Multimedia> files = new ArrayList<>();

    public Folder(String folderName) {
        this.folderName = folderName;
        this.files = new ArrayList<>();
        
    }

    public void addMultimedia(Multimedia multimedia) {
        files.add(multimedia);
        System.out.println("Multimedia added to folder: " + folderName);
    }

    public void removeMultimedia(Multimedia multimedia) {
        if (files.remove(multimedia)) {
            System.out.println("Multimedia removed from folder: " + folderName);
        } else {
            System.out.println("Multimedia not found in folder: " + folderName);
        }
    }

    public void saveMultimedia(Multimedia multimedia) {
        System.out.println("Multimedia saved in folder: " + folderName);
        // Aquí puedes implementar lógica adicional si es distinta a agregar
    }

    public String getName() {
        return folderName;
    }

    public void setName(String folderName) {
        this.folderName = folderName;
    }

    public List<Multimedia> getFiles() {
        return files;
    }

    public void generalFolder() {
        this.folderName = "General Folder";
    }

    public void miniFolder(String customName) {
        this.folderName = "Mini Folder - " + customName;
    }

    public void userFolder(User name) {
        this.folderName =  "User Folder  - " + name.getName();
    }

    public void getMultimediaDevice() {
        //This method should be able to get the multimedia from the device
    }

    public void getMultimediaGeneral() {
        //This method should be able to get the multimedia from the general folder
    }
}