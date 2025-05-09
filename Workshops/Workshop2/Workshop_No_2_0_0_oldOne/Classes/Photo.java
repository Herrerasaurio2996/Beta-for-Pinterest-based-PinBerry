package Workshops.Workshop2.Workshop_No_2_0_0_oldOne.Classes;

public class Photo {
    // Photo attributes 
    private String author;        // Name of the person who uploaded the photo
    private String uploaddate;    // Date when the photo was uploaded
    private String image;         // Image reference (could be a filename or path)
    private boolean isDeleted;    // Tracks if the photo has been deleted

    // Constructor: initializes a new Photo object
    public Photo(String author, String uploaddate, String image) {
        this.author = author;
        this.uploaddate = uploaddate;
        this.image = image;
        this.isDeleted = false; // Photo is active by default
    }
    
    // Simulates uploading the photo
    public void upload() {
            System.out.println("Photo upload Succefully");
        }
    
         /**
     * Marks the photo as deleted if it hasn't been deleted yet.
     * Returns true if deletion was successful, false otherwise.
     */
    public boolean delete() {
        if (!isDeleted) {
            System.out.println("The photo has been successfully deleted");
            isDeleted = true;
            return true;
        }
        System.out.println("The photo already been deleted ");
        return false;
    }

        /**
     * Simulates downloading the photo if it is not deleted.
     * Returns true if download is possible, false otherwise.
     */
    public boolean download() {
        if (!isDeleted) {
            System.out.println("Download photo...");
            return true;
        }
        
        System.out.println("Can't download a deleted photo");
        return false;
    }

    // Getter for the upload date
    public String getUploaddate() {
        return uploaddate;
    }

     // Getter for the author's name
    public String getAuthor(){
        return author;
    }

    // Getter for the image reference
    public String getImage(){
        return image;
    }

    // Returns true if the photo is not deleted
    public boolean isActive() {
        return !isDeleted;
    
    }
}