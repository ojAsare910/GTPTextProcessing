# Text Processing Application Requirements

## Overview

This project aims to develop a JavaFX application for text processing tasks. The application allows users to manage text data through functionalities such as adding, updating, deleting, searching, replacing, and matching text patterns within a dataset.

## Functional Requirements

1. **Add Data**
   - Users can add new text entries to the application.
   - Input: Text data entered via a dialog box.
   - Output: Added data is displayed in a table.

2. **Update Data**
   - Users can modify existing text entries.
   - Input: Updated text data entered via a dialog box.
   - Output: Updated data replaces the existing entry in the table.

3. **Delete Data**
   - Users can remove selected text entries.
   - Input: Selection of data to be deleted.
   - Output: Deleted data is removed from the table.

4. **Search Data**
   - Users can search for specific text within a selected data entry.
   - Input: Search pattern (regex or word).
   - Output: Displays if the search pattern is found within the data entry.

5. **Replace Data**
   - Users can replace text within a selected data entry.
   - Input: Replacement pattern (regex or plain text).
   - Output: Replaced data is updated in the table and displayed.

6. **Match Data**
   - Users can match text patterns within a selected data entry.
   - Input: Pattern to match (regex or plain text).
   - Output: Displays if a match is found within the selected data.

## Non-Functional Requirements

- **Usability**: The user interface should be intuitive and easy to navigate.
- **Performance**: The application should handle typical text processing operations efficiently.
- **Reliability**: The application should provide accurate results for text processing tasks.
- **Maintainability**: The codebase should be well-structured, documented, and modular to facilitate future enhancements and bug fixes.

## System Architecture

The application follows a Model-View-Controller (MVC) architecture:

- **Model**: `DataModel` encapsulates text data and manages its properties.
- **View**: FXML files define the user interface components (e.g., dialogs, main view).
- **Controller**: Individual controllers manage user interactions and application logic for each functionality (e.g., `AddDialogController`, `MainController`).

## Class Descriptions

- **DataModel.java**: Represents a text data entry with getter, setter, and property methods for data manipulation and display.
- **DialogManager.java**: Handles dialog windows for adding, updating, deleting, searching, replacing, and matching data.
- **MainController.java**: Controls the main application window and its interactions with the user and data.
- **MatchDialogController.java**: Manages the logic for matching text patterns within data entries.
- **Other Controllers**: Each controller manages specific dialog interactions and data manipulation tasks.

## User Interface

- **Main View**: Displays a table of text data entries with buttons for adding, updating, deleting, searching, replacing, and matching operations.
- **Dialogs**: Each operation (add, update, delete, search, replace, match) has its own dialog window for user input and interaction.

## Tools and Technologies

- **JavaFX**: GUI framework for Java applications.
- **FXML**: XML-based markup language for defining the UI in JavaFX applications.
- **CSS**: Styling language for customizing the application's appearance.

## Resources

- **FXML Files**: Contains layout definitions for dialogs and main view.
- **CSS File**: Defines styles for UI elements.

## Setup Instructions

### Prerequisites

- Java Development Kit (JDK) 21
- JavaFX SDK.
- Integrated Development Environment (IDE) such as IntelliJ IDEA.

### Running the Application

1. Clone the repository from GitHub.
2. Import the project into your IDE.
3. Configure JavaFX SDK in your IDE's project settings.
4. Run `MainApp.java` to launch the application.



