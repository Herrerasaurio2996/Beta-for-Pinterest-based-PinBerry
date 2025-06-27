import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

// Main application class for Pinberry
public class App {

    // Constant for the file name where all general multimedia is stored
    private static final String FILE_NAME = "GeneralFolder.txt";
    // Folder object that represents the general gallery folder (contains all media)
    private static Folder generalFolder = new Folder("General Folder");
    // JPanel that will visually contain all the images and videos in the gallery
    private static JPanel imagePanel;
    // JScrollPane that allows scrolling through the gallery panel
    private static JScrollPane scrollPane;

    // Simulated logged-in user (replace with real login logic if needed)
    private static User currentUser = new User("default", "1234", null);

    // Main method that launches the application
    public static void main(String[] args) {
        // Ensures all Swing components are created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            // Create the main application window (JFrame)
            JFrame frame = new JFrame("Pinberry");
            // Set the default close operation so the app exits when window is closed
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Set the initial size of the main window
            frame.setSize(900, 600);
            // Center the window on the screen
            frame.setLocationRelativeTo(null);
            // Use BorderLayout for the main window
            frame.setLayout(new BorderLayout());

            // Create the left panel that will hold the main action buttons
            JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
            // Set a fixed preferred size for the button panel
            buttonPanel.setPreferredSize(new Dimension(200, 600));

            // Create the button to reset the scroll position of the gallery to the top
            JButton resetScrollBtn = new JButton("🔁 Reset Scroll");
            // Create the button to add new media (photo, gif, video) to the gallery
            JButton addMediaBtn = new JButton("➕ Add Media");
            // Create the button to open the user's profile (personal gallery)
            JButton profileBtn = new JButton("👤 Go to Profile");

            // Add the three buttons to the button panel (vertical order)
            buttonPanel.add(resetScrollBtn);
            buttonPanel.add(addMediaBtn);
            buttonPanel.add(profileBtn);
            // Add the button panel to the left side of the main window
            frame.add(buttonPanel, BorderLayout.WEST);
            
            // Create the main gallery panel with a grid layout (3 columns, variable rows)
            imagePanel = new JPanel(new GridLayout(0, 3, 10, 10));
            // Create a scroll pane that wraps the gallery panel, allowing vertical scrolling
            scrollPane = new JScrollPane(imagePanel);
            // Add the scroll pane (with the gallery) to the center of the main window
            frame.add(scrollPane, BorderLayout.CENTER);

            // Add an action listener to the reset scroll button
            // When clicked, the vertical scroll bar is set to the top (position 0)
            resetScrollBtn.addActionListener(e ->
                scrollPane.getVerticalScrollBar().setValue(0)
            );

            // Add an action listener to the add media button
            // When clicked, opens a file chooser dialog to select a media file
            addMediaBtn.addActionListener(e -> {
                // Create a file chooser dialog for selecting files from the system
                JFileChooser fileChooser = new JFileChooser();
                // Show the open dialog and store the user's action (approve/cancel)
                int option = fileChooser.showOpenDialog(frame);
                // If the user selected a file and clicked "Open"
                if (option == JFileChooser.APPROVE_OPTION) {
                    // Get the selected file object
                    File file = fileChooser.getSelectedFile();
                    // Get the absolute path of the selected file
                    String path = file.getAbsolutePath();
                    // Get the name of the selected file
                    String name = file.getName();
                    // Get the size of the file in bytes
                    int size = (int) file.length();
                    // Get the current date (when the file is added)
                    LocalDate date = LocalDate.now();

                    // Create a Multimedia object (Photo, Gif, or Video) based on the file extension
                    Multimedia media = createMediaFromExtension(name, path, size, date);
                    // If the file type is supported and the object was created
                    if (media != null) {
                        // Add the media to the general folder (in-memory object)
                        generalFolder.addMultimedia(media);
                        // Save the media's info to the general folder file (persistent storage)
                        saveMediaToFile(media);
                        // Display the media visually in the gallery panel
                        showMedia(media);

                        // If there is a logged-in user, add the media to their personal folder
                        if (currentUser != null) {
                            currentUser.uploadMultimedia(media);
                        }
                    }
                }
            });

            // Add an action listener to the profile button
            // When clicked, opens the user's profile window (personal gallery)
            profileBtn.addActionListener(e -> {
                UserFrame userFrame = new UserFrame();
                userFrame.showUserFrame();
            });

            // Load all media from the general folder file and display them in the gallery
            loadMediaFromFile();

            // Make the main application window visible to the user
            frame.setVisible(true);
        });
    }

    // Helper method to create a Multimedia object based on the file extension
    // Returns a Photo, Gif, or Video object, or null if the file type is unsupported
    private static Multimedia createMediaFromExtension(String name, String path, int size, LocalDate date) {
        String ext = name.toLowerCase();
        // If the file is a photo (jpg, jpeg, png)
        if (ext.endsWith(".jpg") || ext.endsWith(".jpeg") || ext.endsWith(".png")) {
            return new Photo(name, path, size, date);
        // If the file is a gif
        } else if (ext.endsWith(".gif")) {
            return new Gif(name, path, size, date);
        // If the file is a video (mp4, mov, avi)
        } else if (ext.endsWith(".mp4") || ext.endsWith(".mov") || ext.endsWith(".avi")) {
            return new Video(name, path, size, date);
        // If the file type is not supported, show a dialog and return null
        } else {
            JOptionPane.showMessageDialog(null, "Unsupported file type");
            return null;
        }
    }

    // Helper method to save a multimedia object's info to the general folder file
    // The file stores the type, name, path, size, and date of each media item
    private static void saveMediaToFile(Multimedia media) {
        String type = "PHOTO";
        if (media instanceof Gif) type = "GIF";
        else if (media instanceof Video) type = "VIDEO";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(type + ";" + media.getName() + ";" + media.getRoute() + ";" + media.getSize() + ";" + media.getDate());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving media: " + e.getMessage());
        }

        if (media instanceof Photo) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("User.txt", true))) {
                writer.write("PHOTO;" + media.getName() + ";" + media.getRoute() + ";" + media.getSize() + ";" + media.getDate());
                writer.newLine();
            } catch (IOException ex) {
                System.out.println("Error saving user photo: " + ex.getMessage());
            }
        }
    }

    // Helper method to load all media from the general folder file and display them in the gallery
    private static void loadMediaFromFile() {
        File file = new File(FILE_NAME);
        // If the file does not exist, there is nothing to load
        if (!file.exists()) return;

        try (Scanner scanner = new Scanner(file)) {
            // Read each line of the file (each line represents a media item)
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(";");
                // Each line must have 5 fields: type, name, path, size, date
                if (data.length == 5) {
                    String type = data[0];
                    String name = data[1];
                    String path = data[2];
                    int size = Integer.parseInt(data[3]);
                    LocalDate date = LocalDate.parse(data[4]);

                    // Check if the file still exists on disk
                    File f = new File(path);
                    if (!f.exists()) continue;

                    Multimedia media = null;
                    // Create the appropriate Multimedia object based on the type
                    switch (type) {
                        case "PHOTO":
                            media = new Photo(name, path, size, date);
                            break;
                        case "GIF":
                            media = new Gif(name, path, size, date);
                            break;
                        case "VIDEO":
                            media = new Video(name, path, size, date);
                            break;
                    }

                    // If the object was created, add it to the general folder and display it
                    if (media != null) {
                        generalFolder.addMultimedia(media);
                        showMedia(media);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading media: " + e.getMessage());
        }
    }

    // Helper method to display a multimedia object in the gallery panel
    // If the media is a video, display a label with a video icon and name
    // If the media is an image (photo or gif), display the image scaled to 200x200 pixels
    private static void showMedia(Multimedia media) {
        if (media instanceof Video) {
            // For videos, show a label with a movie icon and the file name
            JLabel label = new JLabel("🎬 " + media.getName());
            label.setHorizontalAlignment(SwingConstants.CENTER);
            imagePanel.add(label);
        } else {
            // For images, load and scale the image, then display it in a label
            ImageIcon img = new ImageIcon(media.getRoute());
            Image scaled = img.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            JLabel label = new JLabel(new ImageIcon(scaled));
            label.setToolTipText(media.getName());
            imagePanel.add(label);
        }

        // Refresh the gallery panel to show the new media
        imagePanel.revalidate();
        imagePanel.repaint();
    }

    // Opens a simple profile window (not used for folders/photos, just a placeholder)
    private static void openProfileWindow() {
        // Create a new JFrame for the profile window
        JFrame profileFrame = new JFrame("Your Profile");
        // Set the size of the profile window
        profileFrame.setSize(600, 500);
        // Center the profile window on the screen
        profileFrame.setLocationRelativeTo(null);
        // Use BorderLayout for the profile window
        profileFrame.setLayout(new BorderLayout());

        // Create a panel for the top part of the profile window
        JPanel topPanel = new JPanel(new FlowLayout());

        // Create a label with a user avatar icon
        JLabel avatar = new JLabel("👤");
        avatar.setFont(new Font("Arial", Font.PLAIN, 48));
        // Create a text field for entering the user's name
        JTextField nameField = new JTextField("Enter your name", 20);

        // Add the avatar and name field to the top panel
        topPanel.add(avatar);
        topPanel.add(nameField);

        // Create a button to close the profile window
        JButton closeBtn = new JButton("Close");
        // Add an action listener to close the window when clicked
        closeBtn.addActionListener(e -> profileFrame.dispose());

        // Add the top panel to the center of the profile window
        profileFrame.add(topPanel, BorderLayout.CENTER);
        // Add the close button to the bottom of the profile window
        profileFrame.add(closeBtn, BorderLayout.SOUTH);

        // Make the profile window visible
        profileFrame.setVisible(true);
    }
    
    // Inner class for managing the user's profile and folders
    public static class UserFrame {
        // File name for storing user's personal photos
        private static final String USER_FILE = "User.txt";
        // File name for storing user's folders and folder-photo relationships
        private static final String USER_FOLDERS_FILE = "UserFolders.txt";
        // File name for the general folder (not used here)
        private static final String GENERAL_FILE = "GeneralFolder.txt";

        // Folder object representing the user's personal folder
        private Folder userFolder = new Folder("User");
        // List of user's folders (not used directly in this code)
        private List<Folder> userFolders = new ArrayList<>();

        // Show the user's profile window with their personal photos
        public void showUserFrame() {
            // Create a new JFrame for the user profile
            JFrame frame = new JFrame("User Profile");
            // Set the size of the user profile window
            frame.setSize(800, 600);
            // Use BorderLayout for the user profile window
            frame.setLayout(new BorderLayout());
            // Center the user profile window on the screen
            frame.setLocationRelativeTo(null);

            // Create a panel to display the user's photos in a grid
            JPanel imagePanel = new JPanel(new GridLayout(0, 3, 10, 10));
            // Create a scroll pane for the image panel
            JScrollPane scrollPane = new JScrollPane(imagePanel);
            // Add the scroll pane to the center of the user profile window
            frame.add(scrollPane, BorderLayout.CENTER);

            // Load the user's photos from file and display them in the image panel
            loadUserPhotos(imagePanel);

            // Make the user profile window visible
            frame.setVisible(true);
        }

        // Load all photos from the user's personal file and display them in the given panel
        private void loadUserPhotos(JPanel panel) {
            File file = new File(USER_FILE);
            // If the file does not exist, there are no photos to load
            if (!file.exists()) return;

            try (Scanner scanner = new Scanner(file)) {
                // Read each line of the file (each line represents a photo)
                while (scanner.hasNextLine()) {
                    String[] data = scanner.nextLine().split(";");
                    // Each line must have 5 fields and start with "PHOTO"
                    if (data.length == 5 && data[0].equals("PHOTO")) {
                        String name = data[1]; // Name of the photo
                        String path = data[2]; // Path to the photo file
                        int size = Integer.parseInt(data[3]); // Size of the photo
                        LocalDate date = LocalDate.parse(data[4]); // Date of the photo

                        // Create a Photo object from the file data
                        Photo photo = new Photo(name, path, size, date);
                        // Add the photo to the user's personal folder (in-memory)
                        userFolder.addMultimedia(photo);

                        // Load and scale the photo image
                        ImageIcon img = new ImageIcon(photo.getRoute());
                        Image scaled = img.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                        // Create a label to display the photo
                        JLabel label = new JLabel(new ImageIcon(scaled));
                        label.setToolTipText(photo.getName());
                        // Create a button to open the folder dialog for this photo
                        JButton folderBtn = new JButton("📁 Folder");

                        // When the folder button is clicked, open the folder dialog for this photo
                        folderBtn.addActionListener(e -> openFolderDialog(photo));

                        // Create a container panel to hold the photo and the folder button
                        JPanel container = new JPanel(new BorderLayout());
                        container.add(label, BorderLayout.CENTER);
                        container.add(folderBtn, BorderLayout.SOUTH);

                        // Add the container to the main image panel
                        panel.add(container);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Open the dialog to manage folders for a specific photo
        private void openFolderDialog(Photo photo) {
            // Create a new JFrame for the folder management dialog
            JFrame folderFrame = new JFrame("User Folders");
            // Set the size of the folder dialog window
            folderFrame.setSize(600, 500);
            // Use BorderLayout for the folder dialog window
            folderFrame.setLayout(new BorderLayout());
            // Center the folder dialog window on the screen
            folderFrame.setLocationRelativeTo(null);

            // Create a model to hold the list of folder names
            DefaultListModel<String> folderModel = new DefaultListModel<>();
            // Create a JList to display the folder names
            JList<String> folderList = new JList<>(folderModel);
            // Load the folder names from file into the model
            loadUserFolders(folderModel);

            // Button to add the photo to the selected folder
            JButton addBtn = new JButton("➕ Add to Selected Folder");
            // Button to create a new folder
            JButton newFolderBtn = new JButton("📂 New Folder");
            // Button to view photos in the selected folder
            JButton viewBtn = new JButton("👁️ View Folder");
            // Button to delete the selected folder and its photos
            JButton deleteBtn = new JButton("🗑️ Delete Folder");

            // Action to create a new folder
            newFolderBtn.addActionListener(e -> {
                String folderName = JOptionPane.showInputDialog("Enter folder name:");
                if (folderName != null && !folderName.trim().isEmpty()) {
                    folderModel.addElement(folderName);
                    saveFolder(folderName);
                }
            });

            // Action to add the photo to the selected folder
            addBtn.addActionListener(e -> {
                String selected = folderList.getSelectedValue();
                if (selected != null) {
                    copyPhotoToFolder(photo, selected);
                    JOptionPane.showMessageDialog(folderFrame, "Photo copied to folder: " + selected);
                }
            });

            // Action to view all photos in the selected folder
            viewBtn.addActionListener(e -> {
                String selected = folderList.getSelectedValue();
                if (selected != null) {
                    showPhotosInFolder(selected);
                }
            });

            // Action to delete the selected folder and its photos
            deleteBtn.addActionListener(e -> {
                String selected = folderList.getSelectedValue();
                if (selected != null) {
                    int confirm = JOptionPane.showConfirmDialog(folderFrame, "Are you sure you want to delete the folder '" + selected + "' and all its photos?", "Delete Folder", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        deleteFolder(selected);
                        folderModel.removeElement(selected);
                    }
                }
            });

            // Create a panel to hold all the folder management buttons
            JPanel btnPanel = new JPanel();
            btnPanel.add(newFolderBtn);
            btnPanel.add(addBtn);
            btnPanel.add(viewBtn);
            btnPanel.add(deleteBtn);

            // Add the folder list and the button panel to the folder dialog window
            folderFrame.add(new JScrollPane(folderList), BorderLayout.CENTER);
            folderFrame.add(btnPanel, BorderLayout.SOUTH);
            // Make the folder dialog window visible
            folderFrame.setVisible(true);
        }

        // Load all folder names from the user's folders file into the model
        private void loadUserFolders(DefaultListModel<String> model) {
            File file = new File(USER_FOLDERS_FILE);
            // If the file does not exist, there are no folders to load
            if (!file.exists()) return;

            try (Scanner scanner = new Scanner(file)) {
                // Read each line of the file (each line represents a folder or a photo-folder relationship)
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // If the line starts with "FOLDER;", extract the folder name and add it to the model
                    if (line.startsWith("FOLDER;")) {
                        String folderName = line.split(";")[1];
                        model.addElement(folderName);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Save a new folder name to the user's folders file
        private void saveFolder(String folderName) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FOLDERS_FILE, true))) {
                writer.write("FOLDER;" + folderName);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Save the relationship between a photo and a folder in the user's folders file
        private void copyPhotoToFolder(Photo photo, String folderName) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FOLDERS_FILE, true))) {
                writer.write("PHOTO;" + photo.getName() + ";" + photo.getRoute() + ";" + photo.getSize() + ";" + photo.getDate() + ";" + folderName);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Delete a folder and all its associated photos from the user's folders file
        private void deleteFolder(String folderName) {
            File file = new File(USER_FOLDERS_FILE);
            File tempFile = new File("UserFolders_temp.txt");

            try (BufferedReader reader = new BufferedReader(new FileReader(file));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                String line;
                // Read each line and only write lines that are NOT the folder or its photos
                while ((line = reader.readLine()) != null) {
                    // Skip writing the folder and its associated photos
                    if (line.equals("FOLDER;" + folderName)) continue;
                    if (line.startsWith("PHOTO;") && line.endsWith(";" + folderName)) continue;
                    writer.write(line);
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Replace the original file with the updated file (without the deleted folder/photos)
            if (file.delete()) {
                tempFile.renameTo(file);
            }
        }

        // Show all photos that belong to a specific folder in a new window
        private void showPhotosInFolder(String folderName) {
            // Create a new JFrame to display the photos in the selected folder
            JFrame photosFrame = new JFrame("Photos in " + folderName);
            // Set the size of the photos window
            photosFrame.setSize(600, 400);
            // Use BorderLayout for the photos window
            photosFrame.setLayout(new BorderLayout());
            // Center the photos window on the screen
            photosFrame.setLocationRelativeTo(null);

            // Create a panel to display the photos in a grid
            JPanel panel = new JPanel(new GridLayout(0, 3, 10, 10));

            File file = new File(USER_FOLDERS_FILE);
            // If the file exists, read it to find all photos in the selected folder
            if (file.exists()) {
                try (Scanner scanner = new Scanner(file)) {
                    // Read each line of the file
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // If the line represents a photo-folder relationship
                        if (line.startsWith("PHOTO;")) {
                            String[] data = line.split(";");
                            // Check that the line has 6 fields and the folder name matches
                            if (data.length == 6 && data[5].equals(folderName)) {
                                String name = data[1]; // Name of the photo
                                String path = data[2]; // Path to the photo file
                                int size = Integer.parseInt(data[3]); // Size of the photo
                                LocalDate date = LocalDate.parse(data[4]); // Date of the photo
                                // Create a Photo object from the file data
                                Photo photo = new Photo(name, path, size, date);

                                // Load and scale the photo image
                                ImageIcon img = new ImageIcon(photo.getRoute());
                                Image scaled = img.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                                // Create a label to display the photo
                                JLabel label = new JLabel(new ImageIcon(scaled));
                                label.setToolTipText(photo.getName());
                                // Add the label to the panel
                                panel.add(label);
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // Add the panel with the photos to the center of the photos window (with scroll)
            photosFrame.add(new JScrollPane(panel), BorderLayout.CENTER);
            // Make the photos window visible
            photosFrame.setVisible(true);
        }
    }
}