package Excersice2;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        int sum =0;
        boolean won = true;
        String messageInput = "Guess how much is the sum of the lotto";

        for(int i=0;i<=5;i++){
            if(i>0){
                lotto = new Lotto();
            }
            int[] lotoNumbers = lotto.getLotto();
            for (int j : lotoNumbers) {
                sum += j;
            }
            try{
                int userAnswer = Integer.parseInt(JOptionPane.showInputDialog(null,messageInput, "Sum of the lotto ", JOptionPane.QUESTION_MESSAGE));
                if (userAnswer <3 || userAnswer > 27){
                    i--;
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number between 3 and 27.");
                }else{
                    if(sum==userAnswer){
                        JOptionPane.showMessageDialog(null, "Congratulation!! You won. The sum of the lotto is equal to " + userAnswer);
                        won = false;
                        break;
                    }else{
                        JOptionPane.showMessageDialog(null, "Sorry. Bad luck. The sum of the lotto is " + sum + ". Please try again.");
                        sum =0;
                    }
                }
            }catch(NumberFormatException e){
                i--;
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number");
            }
        }
        if(won){
            JOptionPane.showMessageDialog(null, "Game over. The machine won.");
        }
    }
}


