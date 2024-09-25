package Excersice1;

import javax.swing.JOptionPane;
import java.util.Random;

public class Test {

    // Array of Questions and answers
    String[] questions = {
            "Which of the following tools support the software-development process, \n including editors for writing and editing programs and debuggers for locating logic errors—errors that cause programs \nto execute incorrectly?",
            "Which of the following Java program units defines a group of related objects?",
            "Which of the following statements is false in relation to Java parameters?",
            "Which one of the following terms is correct for a Java class that creates object  of another\n class, then calls the object’s methods?",
            "Which of the following typically groups related classes so that they could be imported into\n programs and reused?"
    };

    // Array of answers
    String[][] answers = {
            {"Java Application Programming Interfaces (API)","Java Virtual Machine (JVM)","Java Development Kit (JDK)","Java Integrated Development Environments (IDE)"},
            {"Java method", "Java default constructor","Java Class","Java"},
            {"Java method", "Java default constructor", "Java Class", "Java"},
            {"Subscriber class", "Driver class", "Abstract class","Concrete class"},
            {"Method","Function","IDE","Package"}
    };

    // Array of correct answers
    int[] correctAnswers = {4, 3, 3, 2, 4};
    int questionNo =0;

    // Method to simulate the questions and get user's answers
    public void simulateQuestion() {
        int score = 0;

        // Loop through all questions
        for (int i = 0; questionNo < questions.length; i++, questionNo++) {
            String message = questions[questionNo] + "\n1) " + answers[questionNo][0] + "\n2) " + answers[questionNo][1] + "\n3) " + answers[questionNo][2] + "\n4) " + answers[questionNo][3];
            String userAnswer = inputAnswer(message);
            boolean match = checkAnswer(userAnswer);
            if (match) {
                score++;
            }
            generateMessage(match);
        }

        JOptionPane.showMessageDialog(null, "Your final score is: " + score + "/" + questions.length);
    }

    // Method to ask the user a question and get their input
    public String inputAnswer(String message) {
        String input = JOptionPane.showInputDialog(null,message, "Question " + (questionNo + 1), JOptionPane.QUESTION_MESSAGE);
        return input;
    }

    // Method to check if the user's answer is correct
    public boolean checkAnswer( String answer) {
        try {
            int userAnswer = Integer.parseInt(answer);
            return userAnswer == correctAnswers[questionNo];
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number between 1 and 4.");
            return false;
        }
    }

    // Method to generate a random message based on whether the answer is correct or not
    public void generateMessage(boolean isCorrect) {
        Random random = new Random();
        String[] correctMessages = {"Good job!", "Correct!", "Well done!", "That's right!"};
        String[] incorrectMessages = {"Oops! Wrong answer.", "Try again next time.", "Incorrect!", "Better luck next time!"};

        if (isCorrect) {
            JOptionPane.showMessageDialog(null, correctMessages[random.nextInt(correctMessages.length)]);
        } else {
            JOptionPane.showMessageDialog(null,incorrectMessages[random.nextInt(incorrectMessages.length)]);
        }
    }
}
