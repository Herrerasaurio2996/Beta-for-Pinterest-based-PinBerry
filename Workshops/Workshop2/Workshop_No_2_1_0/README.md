# **WORKSHOP No. 2 – OBJECT-ORIENTED IMPLEMENTATION**
---
## **🛠️ Actualizations**
In this second workshop, improvements were made to the original class designs and implementations based on the functional requirements of the Pinberry application.

**Removed the Folder class entirely**

  - The Folder class was deleted from the model to simplify the architecture and reduce unnecessary complexity. Since folder structures were not essential for meeting functional requirements, all associations, responsibilities, and collaborations related to this class were eliminated from the design. 
<br>

**Refactored the Photo class🍓**

  - Attributes were adjusted to reflect a more minimal and relevant data structure focused on image management Methods related to folder association and organization were removed. 

  - The next Methods were removed: 

  - download(): Allows the user to download the image to their local storage. 

  - delete(): Permanently removes an uploaded image from the system. 

  - upload(): Uploads a new image to the system and links it to the user. 
<br>

**Updated the User class🍓**

  - The methods updatePassword() and updateProfilePhoto() were removed as they were no longer aligned with the current scope of the application. 

  - Two new responsibilities were added to the class CRC (Class-Responsibility-Collaborator) card: 

  - The user can now delete images (deletePicture()). 

  - The user can now download images (downloadPicture()). 

  - These actions reflect direct interaction with image content, reinforcing the shift in focus from profile management to image manipulation. 
<br>

**Introduced StorageService as a collaborator🍓**

  - Given the user's new responsibilities related to file operations (uploading, downloading, and deleting images), StorageService was added as a collaborator to handle persistent storage operations. This ensures a clear separation of concerns, where storage logic is centralized and reusable across components.
  
<br>

**Rewritten user stories to align with the revised class structure🍓**
  
  - All user stories were updated to be consistent with the modified responsibilities of User and Photo. This ensures that each requirement (e.g., uploading an image, saving it, downloading it, deleting it) is traceable to concrete class methods and interactions in the system design. 
<br>

**Removed retrievePhotos() method🍓**

   - This method was eliminated as part of simplifying the application logic. Image retrieval is now handled implicitly through user interactions such as viewing the gallery or initiating a download, removing the need for a separate retrieval function. 

  - These changes were necessary to allow users to better organize their photo collections by creating and renaming folders, aligning with the application's goal of intuitive visual content management.

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

📌 **User**
- register()
- login()
- logout()
- uploadPicture()
- deletePciture()
- downloadPicture()
- isLoggedIn()

📌 **Gallery**
- showPhotos()
- resetScroll()
- loadPhotos()

📌 **AuthenticationService**
- registerUser()
- verifyCredentials()
- createSession()
- invalidateSession()
- userExist()

📌 **StorageService**
- savePhoto()
- downloadPhoto()
- deleteUserPhoto()
- uploadUserPhoto()

---

## **📈 Sequence Diagrams**
The following diagrams represent the interactions between classes and users for each of the 6 key functionalities:

1. Register User
2. Log In
3. Upload Photo
4. Download Photo
5. Delete Photo
6. Edit Profile

Each diagram focuses on a specific use case and shows the flow of method calls between the involved objects.

---

## **🧪 Implementation of OOP Concepts**
The system strongly applies encapsulation: attributes are private and exposed only through validated methods. For instance, the User class does not expose passwords, and Photo objects cannot be downloaded or deleted unless active. This protects internal state and prevents unauthorized access.

Polymorphism is not currently used since the system does not have overlapping behavior across classes that would justify a common superclass or interface. However, the design is open to future polymorphic implementations, such as supporting different types of storage in StorageService or multiple layout strategies in Gallery, through interfaces or strategy patterns.

---
## **🚧 Work in Progress**
Each class is implemented according to the specification and connected through explicit relationships:

- User → uses AuthenticationService
- User → Photo
- Gallery → shows Photo
- AuthenticationService → manages User
- StorageService → saves and deletes Photo

The system emphasizes clarity, simplicity, and clean design. All updates reflect the needs of the user stories and acceptance criteria defined in [Workshop 1](https://github.com/Herrerasaurio2996/Beta-for-Pinterest-based-PinBerry/blob/main/Workshops/Workshop1/Workshop1_ObjectOrientedDesign.pdf)