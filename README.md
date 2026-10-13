# Experiment 8 – Implement Menus and WebView in an Android Application

## Student Details

**Name:** Mohith TR
**USN:** 25MCAR0227 
**Experiment No.:** 8  
**Title:** Implement Menus and WebView in an Android Application

---

## 1. Aim

To develop an Android application that demonstrates the implementation of **Options Menu and WebView**.

The application allows the user to browse websites inside the Android application, perform searches, navigate between pages, refresh the current page, and use menu options.

---

## 2. Concept / Technology Used

### Android Options Menu

An Options Menu provides additional actions to the user through the three-dot menu in the application's toolbar.

The menu implemented in this experiment contains:

- Home
- Open Wikipedia 
- Refresh Page
- About this Experiment
- Exit

The menu is created using an XML menu resource and its actions are handled in `MainActivity.kt`.

### WebView

`WebView` is an Android component that allows web pages to be displayed directly inside an Android application.

In this experiment, websites such as Google and Wikipedia are displayed inside the application's WebView instead of opening a separate browser application.

### Address / Search Bar

The application provides an address bar where the user can enter:

- A complete website URL
- A domain name
- Search text

For example:

```text
https://www.wikipedia.org
```

or:

```text
Android WebView
```

If search text is entered, the application performs a Google search.

### Navigation History

The application provides **Back** and **Forward** buttons.

These buttons use the WebView browsing history to navigate between previously visited pages.

---

## 3. Scenario

The application is designed as a simple **Web Explorer**.

A user can use the application to:

1. Open Google using the Home button.
2. Open Wikipedia using the Wikipedia button.
3. Enter a website address.
4. Search for information using the address bar.
5. Navigate backward and forward through browsing history.
6. Refresh the current web page using the Options Menu.
7. View experiment and student information using the About option.
8. Exit the application using the Exit option.

This scenario demonstrates the practical use of **Android Menus and WebView**.

---

## 4. Features of the Application

| Feature | Description |
|---|---|
| WebView | Displays web pages inside the application |
| Address/Search Bar | Accepts website URLs and search text |
| GO Button | Opens the entered website or search |
| Home | Opens Google |
| Wikipedia | Opens Wikipedia |
| Back | Navigates to the previous page |
| Forward | Navigates to the next page |
| Refresh | Reloads the current web page |
| About | Displays experiment and student information |
| Exit | Closes the application |
| Loading Status | Displays the current page loading status |

---

## 5. Project Folder Structure

```text
MenuWebViewMAD8/
│
├── app/
│   │
│   └── src/
│       │
│       └── main/
│           │
│           ├── java/
│           │   └── com/
│           │       └── example/
│           │           └── menuwebviewmad8/
│           │               └── MainActivity.kt
│           │
│           └── res/
│               │
│               ├── drawable/
│               │   ├── bg_address.xml
│               │   ├── bg_button_light.xml
│               │   └── bg_button_primary.xml
│               │
│               ├── layout/
│               │   └── activity_main.xml
│               │
│               ├── menu/
│               │   └── main_menu.xml
│               │
│               └── values/
│                   ├── colors.xml
│                   ├── strings.xml
│                   └── themes.xml
│
├── README.md
└── ...
```

---

## 6. Important Files

### MainActivity.kt

`MainActivity.kt` contains the main application logic.

It handles:

- WebView configuration
- Website loading
- Search functionality
- Home button
- Wikipedia button
- Back navigation
- Forward navigation
- Options Menu
- Refresh
- About dialog
- Exit
- WebView loading status

### activity_main.xml

This file defines the application's user interface.

It contains:

- Toolbar
- Address/Search field
- GO button
- Home button
- Wikipedia button
- Back button
- Forward button
- Progress bar
- WebView
- Page status

### main_menu.xml

This XML file defines the Options Menu items used in the application.

### Drawable Files

The drawable XML files are used to provide backgrounds and styling for:

- Address bar
- Primary button
- Navigation buttons

---

# 7. Test Cases

## Test Case 1 – Open Home Page

### Objective

To verify that the Home button opens Google inside the WebView.

### Steps

1. Launch the application.
2. Tap the **Home** button.
3. Observe the WebView.

### Expected Result

Google should open successfully inside the application's WebView.

### Screenshot

Add the screenshot of this test case here.

**Screenshot file:**

```text
screenshots/test-case-1-home.png
```

---

## Test Case 2 – Open Wikipedia

### Objective

To verify that the Wikipedia button opens Wikipedia inside the WebView.

### Steps

1. Launch the application.
2. Tap the **Wikipedia** button.
3. Observe the WebView.

### Expected Result

Wikipedia should open successfully inside the application's WebView.

### Screenshot

Add the screenshot of this test case here.

**Screenshot file:**

```text
screenshots/test-case-2-wikipedia.png
```

---

## Test Case 3 – Verify Options Menu and Student Details

### Objective

To verify the Options Menu and display the student's Name and USN.

### Steps

1. Launch the application.
2. Tap the three-dot menu in the toolbar.
3. Select **About this Experiment**.
4. Observe the About dialog.

### Expected Result

The dialog should display the experiment details and student information.

The dialog should contain:

```text
Experiment 8: Implement Menus and WebView

Student: Mohith TR
USN: 25MCAR0227
```

### Screenshot

Take a screenshot where the **Name and USN are clearly visible**.

**Screenshot file:**

```text
screenshots/test-case-3-about.png
```

---

# 8. Additional Test Cases

## Test Case 4 – Search Using Address Bar

### Input

```text
Android WebView
```

### Expected Result

Google search results for "Android WebView" should open inside the WebView.

---

## Test Case 5 – Back and Forward Navigation

### Steps

1. Open Google.
2. Open Wikipedia.
3. Press the Back button.
4. Press the Forward button.

### Expected Result

The WebView should correctly navigate through the browsing history.

---

## Test Case 6 – Refresh Page

### Steps

1. Open any web page.
2. Open the three-dot Options Menu.
3. Select **Refresh Page**.

### Expected Result

The current web page should reload successfully.

---

# 9. Output

The final application provides a simple Web Explorer interface.

The application contains:

- Android Options Menu
- Embedded WebView
- Address/Search bar
- GO button
- Home button
- Wikipedia button
- Back button
- Forward button
- Refresh option
- About dialog
- Exit option
- Loading status

The web page is displayed directly inside the Android application using WebView.

---

# 10. Conclusion

Experiment 8 was successfully implemented to demonstrate **Menus and WebView in an Android application**.

The application demonstrates how an Android application can display web content using WebView and provide browser-like controls using buttons and an Options Menu.

The experiment also demonstrates:

- Android UI design
- WebView implementation
- Options Menu implementation
- Event handling
- Website navigation
- Navigation history
- Dialog creation
- Page refresh functionality

---

# 11. Screenshots

The following screenshots should be added to the project for submission:

```text
screenshots/
│
├── test-case-1-home.png
├── test-case-2-wikipedia.png
└── test-case-3-about.png
```

### Screenshot 1

<img width="732" height="1600" alt="8 1" src="https://github.com/user-attachments/assets/47c142f6-712f-4dde-a841-9b5d5280da25" />


### Screenshot 2

<img width="732" height="1600" alt="8 2" src="https://github.com/user-attachments/assets/c72e7a77-f9be-49a9-a105-d704bff82c9b" />

```text
Student: Mohith TR
USN: 25MCAR0227
```

---

# 12. Submission Checklist

- [x] Android application created
- [x] Options Menu implemented
- [x] WebView implemented
- [x] Home navigation implemented
- [x] Wikipedia navigation implemented
- [x] Back navigation implemented
- [x] Forward navigation implemented
- [x] Refresh option implemented
- [x] About dialog implemented
- [x] Exit option implemented
- [x] README documentation created
- [ ] Output screenshot added
- [ ] Three test-case screenshots added
- [ ] Screenshot containing Name and USN added
- [ ] Final project pushed to GitHub
