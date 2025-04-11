# **Workshop No. 1 – Object-Oriented Design and Requierements**

This folder contains the first Workshop of the Object Oriented Programming project

This workshop document is part of the Object-Oriented Programming course at Universidad Distrital Francisco José de Caldas. It presents the design and planning phase for a Pinterest-like image sharing application named **PinBerry**.

---

## Workshop Overview

This workshop focuses on the design and important requirements that will help us to develop the program more easily, as well as help us to better understand the functionalities and features of this, it will try to develop the program in relation to the principles of object oriented programming.

The application concept is inspired by Pinterest, aiming to let users upload, manage, and explore images across thematic boards.

---

## Objectives

- Define the system architecture using object-oriented design principles.
- Analyze and identify key classes and their interactions.
- Provide visual mock-ups of the application interface.
- Describe how to apply the basic concepts of object-oriented programming, such as encapsulation, inheritance and abstraction.
- Create a base for the implementation phase of the Mini Pinterest (PinBerry) project.

---

## Functional Requirements

- Users can register and log in to their accounts.
- Users can upload, download and delete images.
- Users can create and manage folders.
- Images can be assigned to folders.
- Users can browse and search for images.

## Non-Functional Requirements

- The application must be user-friendly and intuitive.
- The application must apply well the practice of code reuse
- The application must be easy to maintain
- The application must allow adding or modifying new functionalities without major problems.

---

## User Stories

- **As a user**, I want to register an account so I can start using the app.
- **As a user**, I want to view the available images on the platform, So that in can explore interesting visual content.
- **As a user**, I want to upload images so i can organize and store them 
- **As a user**, I want to create folders to organize or save my images.
- **As a user**, I want to see images uploaded by others for inspiration.
---

## Mockups

The PDF contains sketches showing the layout of important screens, such as:

- Login and registration pages.
- Home page (gallery).
- Loading screen.
- Board creation and management interface.
- Photo management (Upload and delete)

These mockups serve as initial references for the user interface and may evolve or change in the development phase.

[Mockups sketch](https://www.canva.com/design/DAGkTfEUicw/4lp_0_doZkH3n4L4n3Y25A/edit?utm_content=DAGkTfEUicw&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)
---

## CRC Cards (Class–Responsibility–Collaborator)

| Class       | Responsibilities                                         | Collaborators       |
|-------------|----------------------------------------------------------|---------------------|
| `User`      | Authenticate, create boards, upload images               | Folder, Photo, AuthenticationService        |
| `Photo`     | Store metadata, display content                          | User, Folder         |
| `Folder`     | Contain and manage images                                | User, Photo         |
| `Gallery`   | Show public images, allow browsing and searching         | Photos, User               |
| `AuthenticationService`   | Manage login and session states                          | User, DataBase                |
| `StorageService`   | Manage file system                          | Photo, Folder                |

---