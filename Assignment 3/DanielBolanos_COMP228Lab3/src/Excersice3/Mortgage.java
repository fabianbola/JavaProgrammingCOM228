package Excersice3;
import javax.swing.JOptionPane;

public abstract class Mortgage implements MortgageConstants{

    private int mortgageNo;
    private String customerName;
    private double amountMortgage;
    private double interestRate;
    private int term;

    private void setMortgageNo(int mortgageNo){
        this.mortgageNo = mortgageNo;
    }
    private void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    private void setAmountMortgage(double amountMortgage){
        if(amountMortgage > MaxAmountMortgage){
            String message = String.format("%.2f is not a amount valid. The maximum amount mortgage is 300.000.%n New amount mortgage: 300.000",amountMortgage);
            JOptionPane.showMessageDialog(null, message , "Invalid Amount mortgage", JOptionPane.INFORMATION_MESSAGE);
            this.amountMortgage = MaxAmountMortgage;
        }else {
            this.amountMortgage = amountMortgage;
        }
    }
    private void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }
    private void setTerm(int term){
        if((term == shortTerm) || (term == mediumTerm) || (term == longTerm)){
            this.term = term;
        }else {
            String message = String.format("%d is not a term valid. The term prompt is not 1, 3 or 5 years.%nNew term is 1 year", term);
            JOptionPane.showMessageDialog(null,  message , "Invalid term mortgage", JOptionPane.INFORMATION_MESSAGE);
            this.term = shortTerm;
        }
    }

    public int getMortgageNo(){
        return mortgageNo;
    }
    public String getCustomerName(){
        return customerName;
    }
    public double getAmountMortgage(){
        return amountMortgage;
    }
    public double getInterestRate(){
        return interestRate;
    }
    public int getTerm(){
        return term;
    }

    protected Mortgage(int mortgageNo, String customerName, double amountMortgage, double interestRate, int term){
        setMortgageNo(mortgageNo);
        setCustomerName(customerName);
        setAmountMortgage(amountMortgage);
        setInterestRate(interestRate);
        setTerm(term);
    }

    public abstract void displayData();

}
