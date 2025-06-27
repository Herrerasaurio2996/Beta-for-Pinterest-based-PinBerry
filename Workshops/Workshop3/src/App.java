import Photo;
import Video;
import Gif;



// this is Pinberry a simple Java application that its a mini version of pinterest
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// This is the main class of the application
// It contains the main method which is the entry point of the application
public class App {

    public static Photo createPhoto(Scanner scanner) throws Exception {
        System.out.print("Enter photo name: ");
        String name = scanner.nextLine();
        System.out.print("Enter photo route: ");
        String route = scanner.nextLine();
        System.out.print("Enter photo size: ");
        Integer size = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter photo date: ");
        String date = scanner.nextLine();

        return new Photo(name, route, size, date);

        public static Video createVideo(Scanner scanner) throws Exception {
        System.out.print("Enter photo name: ");
        String name = scanner.nextLine();
        System.out.print("Enter photo route: ");
        String route = scanner.nextLine();
        System.out.print("Enter photo size: ");
        Integer size = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter photo date: ");
        String date = scanner.nextLine();

        return new Video(name, route, size, date);

        public static Gif createGif(Scanner scanner) throws Exception {
        System.out.print("Enter photo name: ");
        String name = scanner.nextLine();
        System.out.print("Enter photo route: ");
        String route = scanner.nextLine();
        System.out.print("Enter photo size: ");
        Integer size = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter photo date: ");
        String date = scanner.nextLine();

        return new Gif(name, route, size, date);
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
