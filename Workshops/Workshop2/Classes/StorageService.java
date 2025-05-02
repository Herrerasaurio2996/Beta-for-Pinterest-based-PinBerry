package Workshops.Workshop2.Classes;

import java.util.ArrayList;

public class StorageService {
    private ArrayList<Photo> storedPhotos;

    public StorageService() {
        this.storedPhotos = new ArrayList<>();
    }

    // Save a new photo if it’s valid and not already stored
    public boolean savePhoto(Photo photo) {
        if (photo != null && photo.isActive() && !storedPhotos.contains(photo)) {
            storedPhotos.add(photo);
            System.out.println("✅ Photo saved successfully.");
            return true;
        }
        System.out.println("❌ Photo could not be saved.");
        return false;
    }

    // Retrieve a photo by index (basic example)
    public Photo retrievePhoto(int index) {
        if (index >= 0 && index < storedPhotos.size()) {
            return storedPhotos.get(index);
        }
        System.out.println("⚠️ Photo not found at that index.");
        return null;
    }

    // Mark photo as deleted, does not remove it from the list
    public boolean deletePhoto(Photo photo) {
        if (photo != null && photo.isActive()) {
            return photo.delete(); // usa el método delete de la clase Photo
        }
        System.out.println("⚠️ Photo is already deleted or null.");
        return false;
    }

    // Optional: list stored photos
    public void listStoredPhotos() {
        System.out.println("🗂 Stored Photos:");
        for (Photo p : storedPhotos) {
            System.out.println("- " + p.getAuthor() + " | " + p.getUploaddate());
        }
    }
}