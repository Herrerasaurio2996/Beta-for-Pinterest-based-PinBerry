# **WORKSHOP No. 2 – OBJECT-ORIENTED IMPLEMENTATION**
---
## **🛠️ Actualizations**
In this second workshop, improvements were made to the original class designs and implementations based on the functional requirements of the Pinberry application.
- A new attribute was added to the Folder class: name
- A new method was implemented in Folder: renameFolder(String newName)

These changes were necessary to allow users to better organize their photo collections by creating and renaming folders, aligning with the application's goal of intuitive visual content management.

---
## **🧠 Technical Design (UML Diagrams)**
A thorough analysis of the object model led to the conclusion that inheritance was not appropriate for this system. Each class in PinBerry has clearly distinct responsibilities and behaviors, and no class requires a common base class or shared polymorphic interface at this stage.

Instead of inheritance, the design leverages composition: objects collaborate by referencing one another. For example, User has Photos and Folders, and StorageService works with Photo objects. This keeps each class independent, testable, and focused on a single purpose, following best practices in object-oriented design.

---
## **🧱 Class Diagram**
See section 2.1 in the main document for the complete class diagram representation.
[View Workshop 2 – PDF Document](WORKSHOP%20No.%202%20%E2%80%93%20OBJECT-ORIENTED%20IMPLEMENTATION.pdf)

---
## **🔧 Methods Implementation Summary**
Each class was implemented with encapsulation and responsibility in mind. Rather than exposing sensitive data through direct getters or setters, methods were written to validate and control access to internal state.

[Classes](https://github.com/Herrerasaurio2996/Beta-for-Pinterest-based-PinBerry/tree/main/Workshops/Workshop2/Classes)

Here is a summary of methods implemented per class:

📌 User
- register()
- login()
- logout()
- updatePassword()
- updateProfilePicture()
- isLoggedIn()

📌 Photo
- upload()
- download()
- delete()
- getAuthor()
- getUploaddate()
- isActive()

📌 Folder
- create()
- addPhoto()
- removePhoto()
- renameFolder()
- listPhotos()

📌 Gallery
- addPhoto()
- showPhotos()
- resetScroll()
- getTotalPhotos()

📌 AuthenticationService
- registerUser()
- verifyCredentials()
- createSession()
-invalidateSession()

📌 StorageService
- savePhoto()
- retrievePhoto()
- deletePhoto()
- listStoredPhotos()

---

## **📈 Sequence Diagrams**
The following diagrams represent the interactions between classes and users for each of the 7 key functionalities:

1. Register User
2. Log In
3. Upload Photo
4. Create Folder and Add Photo
5. Download Photo
6. Delete Photo
7. Edit Profile

Each diagram focuses on a specific use case and shows the flow of method calls between the involved objects.

---

## **🧪 Implementation of OOP Concepts**
The system strongly applies encapsulation: attributes are private and exposed only through validated methods. For instance, the User class does not expose passwords, and Photo objects cannot be downloaded or deleted unless active. This protects internal state and prevents unauthorized access.

Polymorphism is not currently used since the system does not have overlapping behavior across classes that would justify a common superclass or interface. However, the design is open to future polymorphic implementations, such as supporting different types of storage in StorageService or multiple layout strategies in Gallery, through interfaces or strategy patterns.

---
## **🚧 Work in Progress**
Each class is implemented according to the specification and connected through explicit relationships:

- User → uses AuthenticationService
- User → has Folder and Photo
- Folder → contains Photo
- Gallery → shows Photo
- AuthenticationService → manages User
- StorageService → saves and deletes Photo

The system emphasizes clarity, simplicity, and clean design. All updates reflect the needs of the user stories and acceptance criteria defined in [Workshop 1](https://github.com/Herrerasaurio2996/Beta-for-Pinterest-based-PinBerry/blob/main/Workshops/Workshop1/Workshop1_ObjectOrientedDesign.pdf)