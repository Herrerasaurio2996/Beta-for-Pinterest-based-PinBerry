import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String folderName = "";
    private List<Multimedia> files = new ArrayList<>();

    public Folder(String folderName) {
        this.folderName = folderName;
        this.files = new ArrayList<>();
        
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

    public void generalFolder(Folder folder, String folderName) {
        this.folderName = "General Folder";
    }

    public void miniFolder(Folder folder, String folderName, User user) {
        this.folderName = "Mini Folder";
    }

    public void userFolder(Folder folder, String folderName, User user) {
        this.folderName =  "User Folder";
    }

    public void getMultimediaDevice() {
        //This method should be able to get the multimedia from the device
    }

    public void getMultimediaGeneral() {
        //This method should be able to get the multimedia from the general folder
    }
}