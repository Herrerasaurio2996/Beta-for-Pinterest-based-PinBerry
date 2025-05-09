package Workshops.Workshop2.Workshop_No_2_1_0.classes;
import java.util.ArrayList;

public class Gallery {


    private ArrayList<Photo> allPhotos; // List of all photos in the gallery
    private ArrayList<Photo> displayedPhotos; // Photos being displayed in the feed
    private StorageService storageService; // The service that manages photo storage
    private int photosPerLoad; // Number of photos to be loaded for each “pagination”.
    private int currentIndex; // Index to know from which photo to load

    // Constructor
    public Gallery(StorageService storageService, int photosPerLoad) {
        this.storageService = storageService;
        this.photosPerLoad = photosPerLoad;
        this.currentIndex = 0; // 
        this.displayedPhotos = new ArrayList<>();
        this.allPhotos = new ArrayList<>();
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
        System.out.println("Gallery restarted.");
    }

    /**
    * Adds photos from the given user to the gallery.
    * This simulates loading more content as the user scrolls down.
    */
    public void loadPhotos(StorageService storage) {
    ArrayList<Photo> allPhotos = storageService.getStoredPhotos(); // Retrieve all stored photos from the storage service
    int index = Math.min(currentIndex + photosPerLoad, allPhotos.size());  // Calculate the end index for the current batch of photos to load
    for (int i = currentIndex; i < index; i++) {  // Load photos from the current index up to the calculated end index
        displayedPhotos.add(allPhotos.get(i)); // Add photo to the displayed list
        currentIndex = index; // Update the index for the next batch
        displayLoadedPhotos(); // Display all currently loaded photos
        }
    }

    private void displayLoadedPhotos() { // Displays all photos currently loaded into the gallery
        System.out.println("Loaded photos:");
        for (Photo photo : displayedPhotos) {
            System.out.println("Displaying Photo:" + photo.getImage());
        }
    }
}

