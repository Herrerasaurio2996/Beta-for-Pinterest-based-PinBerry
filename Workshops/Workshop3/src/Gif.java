import java.time.LocalDate;

// This class represents a GIF file with its properties and methods to access them.
public class Gif implements Multimedia {
    private String route = ""; // Path to the GIF file
    private String name = ""; // Name of the GIF file
    private Integer size = 0; // Size of the GIF file, default is 0
    private LocalDate date = LocalDate.now(); // Date of the GIF file, default is empty

    public Gif(String route, String name, Integer size, String date) {
        this.route = route;// Path to the GIF file
        this.name = name;// Name of the GIF file
        this.size = size; // Default size for GIFs
        this.date = LocalDate.now(); // Default date for GIFs    
    }

    public String getRoute(){
        return this.route;// Returns the path to the GIF file
    }

    public String getName() {
        return this.name; // Returns the name of the GIF file
    }

    public Integer getSize() {
        return this.size; // Returns the size of the GIF file
    }

    public LocalDate getDate() {
        return this.date; // Returns the date of the GIF file
    }

    /**public String toString() {
        return "Gif{" +
                "route='" + route + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", date='" + date + '\'' +
                '}';
    }*/
}