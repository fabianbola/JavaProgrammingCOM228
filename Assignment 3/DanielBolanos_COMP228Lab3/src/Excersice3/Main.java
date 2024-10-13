package Excersice3;
import javax.swing.JOptionPane;


public class Main {
    public static void main(String[] args) {
        String customerName;
        double amountMortgage;
        double interestRate;
        int term;

        Mortgage[] mortgageArray = new Mortgage[3];
        interestRate = Double.parseDouble(JOptionPane.showInputDialog(null,"What is the interest rate (from 1 to 100)?","Interest rate",JOptionPane.PLAIN_MESSAGE));


        for(int i = 0; i < mortgageArray.length; i++) {
            customerName = JOptionPane.showInputDialog(null,"What is customer name?","Interest name",JOptionPane.PLAIN_MESSAGE);
            amountMortgage = Double.parseDouble(JOptionPane.showInputDialog(null,"What is the mortgage amount?","Mortgage amount",JOptionPane.PLAIN_MESSAGE));
            term = Integer.parseInt(JOptionPane.showInputDialog(null,"What is the mortgage term (1, 3 or 5)?","Term",JOptionPane.PLAIN_MESSAGE));

            if (i % 2 != 0) {
                PersonalMortgage personalMortgage = new PersonalMortgage(i,customerName,amountMortgage,interestRate,term);
                mortgageArray[i] = personalMortgage;

            } else {
                PersonalMortgage BusinessMortgage = new PersonalMortgage(i,customerName,amountMortgage,interestRate,term);
                mortgageArray[i] = BusinessMortgage;
            }
        }

        for(int i = 0; i < mortgageArray.length; i++) {
            mortgageArray[i].displayData();
        }
    }
}
