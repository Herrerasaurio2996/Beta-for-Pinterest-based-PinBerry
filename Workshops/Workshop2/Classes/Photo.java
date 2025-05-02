package Workshops.Workshop2.Classes;

public class Photo {
    private String author;
    private String uploaddate;
    private String image;
    private boolean isDeleted;

    public Photo(String author, String uploaddate, String image) {
        this.author = author;
        this.uploaddate = uploaddate;
        this.image = image;
        this.isDeleted = false;
    }
    
    public void upload() {
            System.out.println("Photo upload Succefully");
        }
    
    public boolean delete() {
        if (!isDeleted) {
            System.out.println("The photo has been successfully deleted");
            isDeleted = true;
            return true;
        }
        System.out.println("The photo already been deleted ");
        return false;
    }

    public boolean download() {
        if (!isDeleted) {
            System.out.println("Download photo...");
            return true;
        }
        System.out.println("Can't download a deleted photo");
        return false;
    }

    public String getUploaddate() {
        return uploaddate;
    }

    public String getAuthor(){
        return author;
    }

    public String getImage(){
        return image;
    }

    public boolean isActive() {
        return !isDeleted;
    
    }
}