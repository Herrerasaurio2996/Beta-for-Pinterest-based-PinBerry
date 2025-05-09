package Workshops.Workshop2.Workshop_No_2_1_0.classes;

import java.util.ArrayList;

/**
 * StorageService is responsible for managing photo storage.
 * It can upload, save, delete, and simulate downloading photos.
 * It also handles uploading user profile pictures.
 */
public class StorageService {
    
    // Internal list that stores all uploaded photos
    private ArrayList<Photo> storedPhotos;

    /**
     * Constructor: Initializes the photo storage list.
     */
    public StorageService() {
        this.storedPhotos = new ArrayList<>();
    }

    /**
     * Uploads a photo to the storage if the photo is valid and active.
     * 
     * @param photo The Photo object to be uploaded.
     * @return true if upload is successful, false otherwise.
     */
    public boolean uploadPhoto(Photo photo) {
        if (photo != null && photo.isActive()) {
            storedPhotos.add(photo);
            System.out.println("Photo stored: " + photo.getImage());
            return true;
        }
        System.out.println("Failed to store photo.");
        return false;
    }

    /**
     * Simulates uploading a user's profile picture.
     * Does not store the actual image, only confirms the action.
     *
     * @param user             The User who is uploading the picture.
     * @param newPicturePath   The path or name of the new profile picture.
     * @return true if upload is successful, false otherwise.
     */
    public boolean uploadProfilePicture(User user, String newPicturePath) {
        if (user != null && newPicturePath != null && !newPicturePath.isEmpty()) {
            // Simulation only; you could save this to another list if needed
            System.out.println("Profile picture uploaded: " + newPicturePath);
            return true;
        }
        System.out.println("Failed to upload profile picture.");
        return false;
    }

    /**
     * Simulates downloading a photo if it exists in storage and is active.
     *
     * @param photo The Photo object to download.
     * @return true if the photo can be downloaded, false otherwise.
     */
    public boolean downloadPhoto(Photo photo) {
        if (photo != null && photo.isActive() && storedPhotos.contains(photo)) {
            System.out.println("Downloading photo: " + photo.getImage());
            return true;
        }
        System.out.println("Cannot download: photo not found or already deleted.");
        return false;
    }

    /**
     * Returns the list of all photos currently stored.
     * 
     * @return ArrayList of Photo objects.
     */
    public ArrayList<Photo> getStoredPhotos() {
        // Retorna solo las fotos activas
    ArrayList<Photo> activePhotos = new ArrayList<>();
    for (Photo photo : storedPhotos) {
        if (photo.isActive()) {
            activePhotos.add(photo);
        }
    }
    return activePhotos;
}

    /**
     * Saves a photo to storage if:
     * - The photo is not null
     * - The photo is active (not deleted)
     * - The photo is not already stored
     *
     * @param photo The Photo to save.
     * @return true if saved successfully, false otherwise.
     */
    public boolean savePhoto(Photo photo) {
        if (photo != null && photo.isActive() && !storedPhotos.contains(photo)) {
            storedPhotos.add(photo);
            System.out.println("Photo saved successfully.");
            return true;
        }
        System.out.println("Photo could not be saved.");
        return false;
    }

    /**
     * Deletes a photo from storage if it exists and is still active.
     * This method:
     * - Marks the photo as deleted (via photo.delete())
     * - Removes the photo from the internal storage list
     *
     * @param photo The Photo to delete.
     * @return true if deleted successfully, false otherwise.
     */
    public boolean deletePhoto(Photo photo) {
        if (photo != null && storedPhotos.contains(photo) && photo.isActive()) {
            boolean marked = photo.delete(); // marks as logically deleted
            if (marked) {
                storedPhotos.remove(photo); // removes from physical list
                System.out.println("Photo removed from storage: " + photo.getImage());
                return true;
            }
        }
        System.out.println("Cannot delete: photo not found or already deleted.");
        return false;
    }
}
