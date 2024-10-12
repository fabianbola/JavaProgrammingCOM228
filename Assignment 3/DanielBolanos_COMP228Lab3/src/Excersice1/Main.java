package Excersice1;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class Main {
    public static void main(String[] args) {

        ArrayList<Insurance> insurances = new ArrayList<Insurance>();
        int insuraNo = 0;
        int ID = 0;
        String name = "";
        int age = 0;
        char gender = ' ';
        char haveCouple = ' ';
        char haveChildren = ' ';
        char PreExistence = ' ';
        String insuranceType = "";
        double monthlyFee = 0.0;

        String input = "";
        boolean flag = true;

        do{
            while(flag){
                try{
                    ID = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter your ID number", "ID number ", JOptionPane.QUESTION_MESSAGE));
                    flag = false;

                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
                }
            }

            flag = true;
            while(flag){
                try{
                    name =JOptionPane.showInputDialog(null,"Please enter your full name", "Full name", JOptionPane.QUESTION_MESSAGE);
                    flag = false;

                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
                }
            }

            flag = true;
            while(flag){
                try{
                    age = Integer.parseInt(JOptionPane.showInputDialog(null,"Please enter your age", "ID number ", JOptionPane.QUESTION_MESSAGE));
                    flag = false;
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
                }
            }

            flag = true;
            while(flag){
                try{
                    input = JOptionPane.showInputDialog(null, "Please enter your gender (M/F)", "Gender", JOptionPane.QUESTION_MESSAGE);
                    if (input != null && (input.equalsIgnoreCase("M") || input.equalsIgnoreCase("F"))) {
                        gender = input.charAt(0);
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
                    insuranceType = JOptionPane.showInputDialog(null, "What sort of insurance do you want (Life/Health)?", "Sort of insurance", JOptionPane.QUESTION_MESSAGE);
                    if (insuranceType != null && (insuranceType.equalsIgnoreCase("Life") || insuranceType.equalsIgnoreCase("Health"))) {
                        flag = false;
                    }else{
                        JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
                }
            }

            flag = true;
            while(flag){
                try{
                    monthlyFee = Double.parseDouble(JOptionPane.showInputDialog(null, "How much is the monthly fee?", "Monthly fee", JOptionPane.QUESTION_MESSAGE));
                    flag = false;
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
                }
            }

            if (insuranceType.equalsIgnoreCase("LIFE") ) {
                flag = true;
                while(flag){
                    try{
                         input = JOptionPane.showInputDialog(null, "Do you have a couple (Y/N)", "Couple", JOptionPane.QUESTION_MESSAGE);
                        if (input != null && (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N"))) {
                            haveCouple = input.charAt(0);
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
                         input = JOptionPane.showInputDialog(null, "Do you have a children (Y/N)", "Children", JOptionPane.QUESTION_MESSAGE);
                        if (input != null && (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N"))) {
                            haveChildren = input.charAt(0);
                            flag = false;
                        }else{
                            JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
                        }
                        flag = false;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
                    }
                }
                Life insurance = new Life(insuraNo,ID,name,age,gender,haveCouple,haveChildren,monthlyFee);
                insurances.add(insurance);
                insuraNo++;
            }else {
                flag = true;
                while(flag){
                    try{
                         input = JOptionPane.showInputDialog(null, "Do you have Pre-existence illness (Y/N)", "Pre-existence illness", JOptionPane.QUESTION_MESSAGE);
                        if (input != null && (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N"))) {
                            PreExistence = input.charAt(0);
                            flag = false;
                        }else{
                            JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
                        }
                    }catch (Exception e){
                        JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
                    }
                }
                Health insurance = new Health(insuraNo,ID,name,age,gender,PreExistence,monthlyFee);
                insurances.add(insurance);
                insuraNo++;
            }

            flag = true;
            while(flag){
                try{
                    input = JOptionPane.showInputDialog(null, "Do you want to create another insurance (Y/N)", "New insurance", JOptionPane.QUESTION_MESSAGE);
                    if (input != null && (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N"))) {
                            flag = false;
                    }else{
                        JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
                }
            }

            flag = true;
            if (input.equalsIgnoreCase("N")) {
                flag = false;
            }
        }while(flag);

        for (Insurance insurance : insurances) {
            System.out.println(insurance.displayInfo());
        }


    }
}