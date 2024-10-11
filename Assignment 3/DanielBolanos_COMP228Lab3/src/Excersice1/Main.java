package Excersice1;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class Main {
    public static void main(String[] args) {

        ArrayList<Insurance> insurances = new ArrayList<Insurance>();
        int insuraNo=0;

        boolean flag = true;
        while(flag){
        try{
                int ID = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter your ID number", "ID number ", JOptionPane.QUESTION_MESSAGE));
                flag = false;

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
        }
        }

        flag = true;
        while(flag){
        try{
                String name =JOptionPane.showInputDialog(null,"Please enter your full name", "Full name", JOptionPane.QUESTION_MESSAGE);
                flag = false;

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
        }
        }

        flag = true;
        while(flag){
        try{
                int age = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter your age", "ID number ", JOptionPane.QUESTION_MESSAGE));
                flag = false;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
        }
        }

        flag = true;
        while(flag){
        try{
                String input = JOptionPane.showInputDialog(null, "Please enter your gender (M/F)", "Gender", JOptionPane.QUESTION_MESSAGE);
                if (input != null && (input.equalsIgnoreCase("M") || input.equalsIgnoreCase("F"))) {
                    char gender = input.charAt(0);
                    flag = false;
                }else{
                    JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
                }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
        }
        }

        flag = true;
        while(flag){
        try{
                String input = JOptionPane.showInputDialog(null, "Do you have a couple (Y/N)", "Couple", JOptionPane.QUESTION_MESSAGE);
            if (input != null && (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N"))) {
                char haveCouple = input.charAt(0);
                flag = false;
            }else{
                JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
        }
        }

        flag = true;
        while(flag) {
            try {
                String input = JOptionPane.showInputDialog(null, "Do you have a children (Y/N)", "Children", JOptionPane.QUESTION_MESSAGE);
                if (input != null && (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N"))) {
                    char haveChildren = input.charAt(0);
                    flag = false;
                }else{
                    JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
                }
                flag = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
            }
        }

        



    }
}