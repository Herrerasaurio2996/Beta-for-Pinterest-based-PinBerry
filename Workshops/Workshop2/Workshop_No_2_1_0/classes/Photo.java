package Workshops.Workshop2.Workshop_No_2_1_0.classes;
/**
 * The Photo class represents a digital image that can be uploaded,
 * downloaded, and marked as deleted. It stores basic metadata like
 * dimensions, file path, and deletion state.
 */
public class Photo {

    // Photo attributes
    private int height;          // Photo height in pixels
    private int width;           // Photo width in pixels
    private String nameFile;     // Logical name of the photo (e.g. "vacation1")
    private String file;         // Physical file name or path (e.g. "vacation1.jpg")
    private boolean isDeleted;   // Indicates whether the photo has been deleted

    /**
     * Constructor: creates a new Photo with the given attributes.
     * 
     * @param nameFile Logical name of the photo
     * @param file     File path or image reference
     * @param height   Photo height in pixels
     * @param width    Photo width in pixels
     */
    public Photo(String nameFile, String file, int height, int width) {
        this.nameFile = nameFile;
        this.file = file;
        this.height = height;
        this.width = width;
        this.isDeleted = false; // Photo is active by default
    }

    /**
     * Simulates the upload of the photo.
     * Simply prints a message to confirm the upload action.
     */
    public void upload() {
        System.out.println("Photo uploaded successfully.");
    }

    /**
     * Marks the photo as deleted if it hasn't already been deleted.
     * 
     * @return true if the deletion was successful, false if it was already deleted
     */
    public boolean delete() {
        if (!isDeleted) {
            isDeleted = true;
            return true;
        }
        return false;
    }

    /**
     * Gets the file path or image name associated with this photo.
     * 
     * @return A String representing the image reference
     */
    public String getImage() {
        return file;
    }

    /**
     * Checks if the photo is currently active (not deleted).
     * 
     * @return true if the photo is active, false if it has been deleted
     */
    public boolean isActive() {
        return !isDeleted;
    }
}


    