# 🍓 PinBerry – Workshop 4: LAYERS ARCHITECTURE

**Authors**:  
- 👥 Juan Sebastian Herrera Rodriguez - 20242020032 
- 👥 Isabela Chica Becerra - 20242020035

---

## 📝 Description

**Pinberry** is a desktop application developed in Java that simulates a simplified version of Pinterest. Users can upload and organize multimedia content (photos, videos, GIFs) into folders and explore a shared global feed. The application combines an interactive graphical user interface with a clean backend structure.

---

## 🖥️ Graphical Interface (GUI)

The graphical user interface is built using **Java Swing** and includes interactive buttons and menus such as:

- `Add Media`: to upload new photos or videos
- `Go to Profile`: to view the user’s personal uploads
- `Folder`: to create custom folders (`MiniFolders`)
- Automatically loads the global feed (`GeneralFolder`) when the app starts

---

## 🧠 Backend Logic

The backend logic is organized into layers that interact through clean method calls:

- `App`: acts as the controller and handles GUI logic
- `User`: represents the current user and their content
- `Folder`: manages media organization and supports three modes:
  - `GeneralFolder`: stores all uploaded media across the app
  - `UserFolder`: stores only the media uploaded by the user
  - `MiniFolder`: custom folders created by the user

The system also includes:

- `Photo`, `Video`, and `Gif` classes implementing the `Multimedia` interface
- Clean handling of folder creation, media storage, and viewing mechanisms

---

## 📊 UML Diagrams

The project includes UML sequence diagrams representing communication between layers in the following use cases:

- Uploading a photo
- Creating a custom folder (`MiniFolder`)
- Viewing the general feed (`GeneralFolder`)
- Viewing the user’s profile (`UserFolder`)

---

## 🚀 Compilation and Execution Instructions

### ✅ Requirements

- Java Development Kit (JDK) version 17 or higher
- A terminal or command prompt
- (Optional) An IDE like IntelliJ IDEA or Eclipse for better management

### 🔧 Compilation Steps

1. Open a terminal window.
2. Navigate to the directory where your `.java` files are stored using the `cd` command
3. Compile all .java files by running

### ▶️ Execution Steps
After successful compilation, run the application using:
- java App

This will start the Swing-based GUI and load the GeneralFolder by default.

### 📎Notes
- The application uses plain .txt files to persist media and user data locally.
- The global feed (GeneralFolder) is created once when the app starts and is shared by all users.
- Each user has a personal folder (UserFolder) to store their own uploads.
- Users can create multiple custom folders (MiniFolders) which start empty.
- Folders can exist without media. An empty folder is still valid.
- The system assumes that there is already an “active user” present; no login or registration logic has yet been included in the graphical interface.