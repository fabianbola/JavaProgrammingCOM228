package com.example.danielbolanos_comp228_lab4;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ListView;
import javafx.application.Platform;




public class HelloController {

    @FXML
    private TextField nameTB, addressTB, providenceTB, cityTB, postalCodeTB, phoneNumberTB, emailTB, Result;

    @FXML
    private ComboBox<String> codeCoursesComboBox;

    @FXML
    private ListView<String> CoursesSelected;

    @FXML
    private RadioButton computerScienceRB, businessRB;

    public void initialize() {
        ToggleGroup group = new ToggleGroup();
        computerScienceRB.setToggleGroup(group);
        businessRB.setToggleGroup(group);
        group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == computerScienceRB) {

                // Opciones para Computer Science
                codeCoursesComboBox.getItems().setAll("Java", "Python", "C++");
            } else if (newValue == businessRB) {
                // Opciones para Business
                codeCoursesComboBox.getItems().setAll("Excel", "PowerPoint", "Word");
            }
            CoursesSelected.getItems().clear();

        });
        /*
        codeCoursesComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                CoursesSelected.getItems().add(newValue);
            }
            int index = codeCoursesComboBox.getItems().indexOf(newValue);
            if (index >= 0 ) {
                codeCoursesComboBox.getItems().remove(index);
            }
        });
        */

        codeCoursesComboBox.setOnAction(event -> {
            String selectedCourse = codeCoursesComboBox.getSelectionModel().getSelectedItem();
            if (selectedCourse != null) {
                CoursesSelected.getItems().add(selectedCourse);
                Platform.runLater(() -> codeCoursesComboBox.getItems().remove(selectedCourse));
            }
        });


        CoursesSelected.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                String selectedCourse = CoursesSelected.getSelectionModel().getSelectedItem();
                if (selectedCourse != null) {
                    codeCoursesComboBox.getItems().add(selectedCourse);
                    CoursesSelected.getItems().remove(selectedCourse);
                }
            }
        });
    }
/*


    @FXML
    private void getBackCourse() {
        String selectedCourse = CoursesSelected.getSelectionModel().getSelectedItem();
        if (selectedCourse != null) {
            codeCoursesComboBox.getItems().add(selectedCourse);
            CoursesSelected.getItems().remove(selectedCourse);
        }
    }
*/

}











/*
    @FXML
    private void onSubmitButtonClick() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String ageText = ageField.getText();
        String program = programField.getText();
        String favoriteColor = colorComboBox.getValue();

        // Validate input
        if (firstName.isBlank() || lastName.isBlank() || ageText.isBlank() || program.isBlank() || favoriteColor == null) {
            showAlert("Input Error", "Please fill in all fields.");
            return;
        }

        try {
            int age = Integer.parseInt(ageText);

            // Display custom message with the collected information
            messageLabel.setText(String.format("Hello %s %s!\nYour Age is %d\nYour favorite color is %s and you're enrolled in the %s program.",
                    firstName, lastName, age, favoriteColor, program));

            // Clear input fields
            firstNameField.clear();
            lastNameField.clear();
            ageField.clear();
            programField.clear();
            colorComboBox.setValue(null);
        } catch (NumberFormatException e) {
            showAlert("Input Error", "Age must be a valid number.");
        }
    }

    // Utility method to show alert dialog
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
*/

