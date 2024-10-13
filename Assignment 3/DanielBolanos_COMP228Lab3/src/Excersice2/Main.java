package Excersice2;
import javax.swing.JOptionPane;


public class Main {
    public static void main(String[] args) {

        String name = "";
        String testerType = "";
        boolean status = false;
        int workWeeklyHours = 0;
        char isBoss = ' ';

        String input = "";
        boolean flag = true;


        while (flag) {
            try {
                name = JOptionPane.showInputDialog(null, "Please enter gametester name", "Name", JOptionPane.QUESTION_MESSAGE);
                flag = false;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
            }
        }

        flag = true;
        while(flag) {
            try {
                testerType = JOptionPane.showInputDialog(null, "What sort of tester is? (Full/Part) time?", "Type of tester", JOptionPane.QUESTION_MESSAGE);
                if (testerType != null && (testerType.equalsIgnoreCase("Full") || testerType.equalsIgnoreCase("Part"))) {
                    if(testerType.equalsIgnoreCase("Full")) {
                        status = true;
                    }
                    flag = false;
                }else{
                    JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
            }
        }



        if (status ) {
            flag = true;
            while(flag){
                try{
                    input = JOptionPane.showInputDialog(null, "Is the tester a supervisor o manager (Y/N)", "Job tittle", JOptionPane.QUESTION_MESSAGE);
                    if (input != null && (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N"))) {
                        isBoss = input.charAt(0);
                        flag = false;
                    }else{
                        JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
                }
            }
            FullTimeGameTester FullTimeGameTester = new FullTimeGameTester(name,status,isBoss);
            System.out.println(FullTimeGameTester);

        }else {
            flag = true;
            while(flag){
                try{
                    workWeeklyHours = Integer.parseInt(JOptionPane.showInputDialog(null,"How many hours the tester will work weekly", "Weekly hours", JOptionPane.QUESTION_MESSAGE));
                    flag = false;
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, "The data prompt is not valid.");
                }
            }
            PartTimeGameTester PartTimeGameTester = new PartTimeGameTester(name,status,workWeeklyHours);
            System.out.println(PartTimeGameTester);
        }
    }
}