package Workshops.Workshop2.Classes;

import java.util.ArrayList;

public class Folder {
    private String name;
    private ArrayList<Photo> photos;

    public Folder(String name) {
        this.name = name;
        this.photos = new ArrayList<>();
    }

    public static Folder create(String folderName) {
        if (folderName != null && !folderName.isEmpty()) {
            System.out.println("Carpeta '" + folderName + "' creada.");
            return new Folder(folderName);
        } else {
            System.out.println("Nombre de carpeta inválido.");
            return null;
        }
    }

    public boolean addPhoto(Photo photo) {
        if (photo != null && photo.isActive()) {
            photos.add(photo);
            System.out.println("The Photo has been add to the folder" + name + ".");
            return true;
        }
        System.err.println("Can't add the photo to the folder" + name + ".");
        return false;
    }

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

    public String getName() {
        return name;
    }
}
