# 📌 PinBerry – Workshop 3: SOLID-Oriented Multimedia Manager

## 👨‍💻 Authors  
- Juan Sebastián Herrera Rodríguez – 20242020032  
- Isabela Chica Becerra – 20242020035  

**Universidad Distrital Francisco José de Caldas**  
Facultad de Ingeniería – Ingeniería de Sistemas  
Asignatura: Programación Orientada a Objetos (POO)  
Docente: Carlos Andrés Sierra  
Bogotá D.C. – 2025  

---

## 🧩 Project Overview

**PinBerry** is a minimalist, user-centered media application inspired by Pinterest, focused on essential features: uploading, downloading, deleting, and organizing multimedia content (photos, GIFs, videos). It removes social elements to offer a clean and distraction-free environment for personal media management.

The project emphasizes modularity, clean architecture, and adherence to SOLID principles using Java and object-oriented programming. It’s designed to be scalable, extensible, and easy to maintain.

---

## 🎯 Project Objectives

### General Objective
- Build a minimalist web application for managing multimedia content through folders, using solid OOP principles.

### Specific Objectives
- Create a responsive and intuitive desktop user interface.
- Apply object-oriented design with defined responsibilities per class (User, App, Folder, etc.).
- Implement functionalities like register, login, upload, delete, download, and folder creation.
- Ensure modularity and code reusability with SOLID principles.
- Provide a clean, private media experience by removing social media noise.

---

## 🔧 Functional Requirements

- **Register/Login**: Create and authenticate accounts securely.
- **Upload**: Add multimedia files (photo, GIF, video) into the general folder.
- **Delete**: Remove media files from folders (with ownership validation).
- **Download**: Save media from the general folder to the user's device.
- **Folder Management**:
  - Auto-create user folders upon registration.
  - Create custom mini folders.
  - Save selected media into folders.

---

## 🧠 Object-Oriented Principles Applied

| Principle | Application |
|----------|-------------|
| **Encapsulation** | Private attributes; access only through defined methods. |
| **Abstraction** | Multimedia interface centralizes shared behavior. |
| **Polymorphism** | Multimedia types (Photo, Video, Gif) used interchangeably via interface. |
| **Inheritance** | Classes implement Multimedia interface to promote reuse. |
| **Decomposition** | Media logic separated into focused classes (User, Folder, App, etc.). |

---

## 🧱 SOLID Principles Justification

| Principle | Implementation in PinBerry |
|----------|-----------------------------|
| **SRP** | Each class has a single, well-defined responsibility (e.g., Folder only manages media). |
| **OCP** | New media types can be added by implementing the Multimedia interface, without modifying existing logic. |
| **LSP** | Photo, Gif, and Video can replace Multimedia objects without breaking the system. |
| **ISP** | Multimedia interface defines only essential methods (getName, getRoute, etc.). |
| **DIP** | Classes depend on abstractions (Multimedia), not specific implementations. |

---

## 📁 Folder Structure & Architecture

- **User** → Aggregates Folders.
- **Folder** → Aggregates Multimedia (Photo, Gif, Video).
- **Multimedia Interface** → Abstracts common behavior.
- **App Class** → Coordinates all actions (upload, delete, folder creation).

```plaintext
User
 ├── Folder (UserFolder, MiniFolder)
 │     └── List<Multimedia>
 │           ├── Photo
 │           ├── Video
 │           └── Gif
```

---

## ⚙️ Use Cases Implemented

| Functionality | Description |
|---------------|-------------|
| Register      | Creates a user and a personal folder. |
| Login         | Authenticates access using credentials. |
| Upload Media  | Adds a file to the general folder. |
| Download Media | Saves a file from the general folder to local storage. |
| Delete Media  | Verifies ownership before deleting. |
| Create Folder | Adds a mini-folder under the user's account. |
| Save to Folder | Uploads media to a selected folder with validation. |

---

## 📑 Documentation Features

- Detailed **CRC Cards** per class.
- **Activity & Sequence Diagrams** for all main use cases.
- Clear traceability between design, implementation, and principles.
- Updated **class diagrams** showing aggregation and interface usage.
- A full explanation of refactorings from Workshop 2 to Workshop 3.

---

## 📌 Final Notes

PinBerry is not just a media manager—it’s an exercise in clean architecture, modular design, and solid OOP practices. Through thoughtful implementation and SOLID-guided modeling, the application is positioned for long-term scalability and clarity in both structure and purpose.
