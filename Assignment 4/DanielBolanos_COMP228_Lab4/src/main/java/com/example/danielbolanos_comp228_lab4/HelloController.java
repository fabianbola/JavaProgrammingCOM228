package com.example.danielbolanos_comp228_lab4;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.application.Platform;




public class HelloController {

    @FXML
    private TextField nameTB, addressTB, providenceTB, cityTB, postalCodeTB, phoneNumberTB, emailTB;

    @FXML
    private TextArea Result;

    @FXML CheckBox studentCouncilCHB, volunteerWorkCHB;

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
                codeCoursesComboBox.getItems().setAll(
                        "Java", "Python", "C++", "JavaScript", "Ruby", "Swift", "Kotlin",
                        "PHP", "R", "Go", "TypeScript", "SQL", "Rust", "Perl"
                );
            } else if (newValue == businessRB) {
                codeCoursesComboBox.getItems().setAll(
                        "Excel", "PowerPoint", "Word", "Outlook", "Access", "Publisher",
                        "OneNote", "Teams", "SharePoint", "Project", "Visio", "OneDrive"
                );
            }
            CoursesSelected.getItems().clear();

        });

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

    @FXML
    private void onSubmitButtonClick() {
        String name = nameTB.getText();
        String address = addressTB.getText();
        String providence = providenceTB.getText();
        String city = cityTB.getText();
        String postalCode = postalCodeTB.getText();
        String phoneNumber = phoneNumberTB.getText();
        String email = emailTB.getText();
        String studentCouncil = "";
        String volunteerCouncil = "";

        if(studentCouncilCHB.isSelected()){
            studentCouncil = ", is student council";
        }
        if(volunteerWorkCHB.isSelected()){
            volunteerCouncil = ", is volunteer council";
        }

        StringBuilder combinedText = new StringBuilder();
        combinedText.append(name).append(", ");
        combinedText.append(address).append(", ");
        combinedText.append(providence).append(", ");
        combinedText.append(city).append(", ");
        combinedText.append(postalCode).append(", ");
        combinedText.append(phoneNumber).append(", ");
        combinedText.append(email);
        combinedText.append(studentCouncil);
        combinedText.append(volunteerCouncil);
        combinedText.append("\n").append("Courses:\n");

        for (String item : CoursesSelected.getItems()) {
            combinedText.append("- ").append(item).append("\n");
        }
        Result.setText(combinedText.toString());

        nameTB.setText("");
        addressTB.setText("");
        providenceTB.setText("");
        cityTB.setText("");
        postalCodeTB.setText("");
        phoneNumberTB.setText("");
        emailTB.setText("");
        studentCouncilCHB.setSelected(false);
        volunteerWorkCHB.setSelected(false);
        computerScienceRB.setSelected(false);
        businessRB.setSelected(false);
        codeCoursesComboBox.getItems().clear();
        CoursesSelected.setDisable(true);

    }


}
