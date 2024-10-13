package Excersice3;
import javax.swing.JOptionPane;


public class BusinessMortgage extends Mortgage{

    public BusinessMortgage(int mortgageNo, String customerName, double amountMortgage, double interestRate, int term) {
        super( mortgageNo, customerName, amountMortgage, (interestRate+2), term);
    }

    @Override
    public void displayData(){
        String message = String.format("The mortgage detail is:%n MortgageNo: %s%n  Customer Name: %s%n Amount: %.2f%n Interest Rate: %.2f%n Term: %d%n",
                super.getMortgageNo(), super.getCustomerName(), super.getAmountMortgage(),super.getInterestRate(), super.getTerm());
        JOptionPane.showMessageDialog(null, message, "Mortgage details", JOptionPane.INFORMATION_MESSAGE);
    }
}
