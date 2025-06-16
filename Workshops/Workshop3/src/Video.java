import java.time.LocalDate;

public class Video implements Multimedia{
    private String name;
    private String route;
    private Integer size;
    private LocalDate date;

    public Video(String name, String route, Integer size, String date) {
        this.name = name;
        this.route = route;
        this.size = size;
        this.date = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public String getRoute() {
        return route;
    }

    public Integer getSize() {
        return size;
    }

    public LocalDate getDate() {
        return date;
    }
}
