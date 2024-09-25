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
    boolean wrongInput;

    // Method to ask the user a question, get their answer, and display the final score.
    public void inputAnswer() {
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            wrongInput = false;
            String userAnswer = simulateQuestion(i);
            boolean match = checkAnswer(userAnswer, i);
            if(wrongInput) {
            i--;
            }
            if (match) {
                score++;
            }
            generateMessage(match);
        }
        JOptionPane.showMessageDialog(null, "Your final score is: " + score + "/" + questions.length);

    }

    // Method to simulate the questions
    public String simulateQuestion(int questionNumber) {
        String message = questions[questionNumber] + "\n1) " + answers[questionNumber][0] + "\n2) " + answers[questionNumber][1] + "\n3) " + answers[questionNumber][2] + "\n4) " + answers[questionNumber][3];
        String userAnswer = JOptionPane.showInputDialog(null,message, "Question " + (questionNumber + 1), JOptionPane.QUESTION_MESSAGE);
        return userAnswer;
    }



    // Method to check if the user's answer is correct
    public boolean checkAnswer( String answer, int questionNumber) {
        try {
            int userAnswer = Integer.parseInt(answer);
            return userAnswer == correctAnswers[questionNumber];
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number between 1 and 4.");
            wrongInput = true;
            return false;
        }
    }

    // Method to generate a random message based on whether the answer is correct or not
    public void generateMessage(boolean isCorrect) {
        Random random = new Random();
        if (isCorrect) {
            switch (random.nextInt(4)) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Excellent!");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Good!");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Keep up the good work!");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Nice work!");
                    break;
                default:
                    break;
            }
        } else {
            switch (random.nextInt(3)) {
                case 1:
                    JOptionPane.showMessageDialog(null, "No. Please try again");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Wrong. Try once more");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Don't give up!");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "No. Keep trying..");
                    break;
                default:
                    break;
            }
        }
    }
}
