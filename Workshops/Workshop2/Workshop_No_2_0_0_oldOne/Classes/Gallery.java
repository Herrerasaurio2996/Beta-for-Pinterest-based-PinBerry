package Workshops.Workshop2.Workshop_No_2_0_0_oldOne.Classes;
import java.util.ArrayList;

public class Gallery {


    private ArrayList<Photo> allPhotos;

    // Index used to track the current position when showing photos
    private int currentIndex; 

     // Constructor: initializes the gallery with an empty list and scroll position at 0
    public Gallery() {
        this.allPhotos = new ArrayList<>();
        this.currentIndex = 0;
    }

    /**
     * Adds a photo to the gallery only if it is not null and is active (not deleted).
     * @param photo the photo to add
     * @return true if the photo was added successfully
     *//**
     * Adds a photo to the gallery only if it is not null and is active (not deleted).
     * @param photo the photo to add
     * @return true if the photo was added successfully
     */
    public boolean addPhoto(Photo photo) {
        if (photo != null && photo.isActive()) {
            allPhotos.add(photo);
            return true;
        }
        return false;
    }

        /**
     * Displays up to 'cantidad' active photos starting from the current scroll position.
     * Only shows photos that are not deleted.
     * After displaying, it updates the scroll index.
     */
    public void showPhotos(int cantidad) {
        System.out.println("📷 Showing " + cantidad + " pictures:");

        int shown = 0;
        while (currentIndex < allPhotos.size() && shown < cantidad) {
            Photo photo = allPhotos.get(currentIndex);
            if (photo.isActive()) {
                System.out.println("- " + photo.getImage());// Show image reference
                shown++;
            }
            currentIndex++;
        }

        if (shown == 0) {
            System.out.println("There are no more active photos to display.");
        }
    }

         /**
     * Resets the scroll index to the beginning.
     * Allows the gallery to start displaying photos from the start again.
     */
    public void resetScroll() {
        this.currentIndex = 0;
        System.out.println("🔁 Gallery restarted.");
    }

         /**
     * Returns the total number of photos in the gallery (active or deleted).
     * @return total number of Photo objects
     */
    public int getTotalPhotos() {
        return allPhotos.size();
    }
}

