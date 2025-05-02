package Workshops.Workshop2.Classes;
import java.util.ArrayList;

public class Gallery {

    private ArrayList<Photo> allPhotos;
    private int currentIndex; 

    public Gallery() {
        this.allPhotos = new ArrayList<>();
        this.currentIndex = 0;
    }

    public boolean addPhoto(Photo photo) {
        if (photo != null && photo.isActive()) {
            allPhotos.add(photo);
            return true;
        }
        return false;
    }

    public void showPhotos(int cantidad) {
        System.out.println("📷 Showing " + cantidad + " pictures:");

        int shown = 0;
        while (currentIndex < allPhotos.size() && shown < cantidad) {
            Photo photo = allPhotos.get(currentIndex);
            if (photo.isActive()) {
                System.out.println("- " + photo.getImage());
                shown++;
            }
            currentIndex++;
        }

        if (shown == 0) {
            System.out.println("There are no more active photos to display.");
        }
    }

    public void resetScroll() {
        this.currentIndex = 0;
        System.out.println("🔁 Gallery restarted.");
    }

    public int getTotalPhotos() {
        return allPhotos.size();
    }
}

