package Workshops.Workshop2.Classes;

import java.util.ArrayList;

public class Folder {

     // Folder name
    private String name;

    // List of photos inside the folder
    private ArrayList<Photo> photos;

    // Constructor: initializes the folder with a name and empty photo list
    public Folder(String name) {
        this.name = name;
        this.photos = new ArrayList<>();
    }

    /**
     * Static factory method to create a Folder.
     * It checks that the folder name is valid (not null or empty).
     * @param folderName the name for the folder
     * @return a new Folder object or null if the name is invalid
     */
    public static Folder create(String folderName) {
        if (folderName != null && !folderName.isEmpty()) {
            System.out.println("Carpeta '" + folderName + "' creada.");
            return new Folder(folderName);
        } else {
            System.out.println("Nombre de carpeta inválido.");
            return null;
        }
    }

     /**
     * Adds a photo to the folder if it is not null and is active (not deleted).
     * @param photo the Photo object to add
     * @return true if the photo was added successfully
     */
    public boolean addPhoto(Photo photo) {
        if (photo != null && photo.isActive()) {
            photos.add(photo);
            System.out.println("The Photo has been add to the folder" + name + ".");
            return true;
        }
        System.err.println("Can't add the photo to the folder" + name + ".");
        return false;
    }

    /**
     * Removes a photo from the folder if it exists.
     * @param photo the Photo object to remove
     * @return true if the photo was found and removed
     */
    public boolean removePhoto(Photo photo) {
        if (photos.contains(photo)) {
            photos.remove(photo);
            System.out.println("Photo removed from folder '" + name + "'.");
            return true;
        } else {
            System.out.println("The photo is not found in this folder.");
            return false;
        }
    }

    /**
     * Lists all the photos currently in the folder.
     * Shows the image reference of each photo.
     */
    public void listPhotos() {
        System.out.println("Photos in the folder'" + name + "':");
        if (photos.isEmpty()) {
            System.out.println("The folder is empty.");
        } else {
            for (Photo p : photos) {
                System.out.println("- " + p.getImage());
            }
        }
    }

     /**
     * Changes the name of the folder to a new one if it is valid.
     * @param newName the new folder name
     * @return true if the renaming was successful
     */
    public boolean renameFolder(String newName) {
        if (newName != null && !newName.isEmpty()) {
            this.name = newName;
            System.out.println("The folder is now called " + newName);
            return true;
        } else {
            System.out.println("Invalid name.");
            return false;
        }
    }

     // Getter for the folder name
    public String getName() {
        return name;
    }
}
