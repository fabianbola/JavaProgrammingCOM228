public class Account {

    private double balance;

    public synchronized double getBalance() {
        return balance;
    }

    public Account(double initBalance) {
        if (initBalance > 0) {
            balance = initBalance;
        }else{
            balance = 0;
        }
    }


    public synchronized void BalanceWithdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            System.out.println(String.format(" %.2f was withdrew from the account", amount));
            balance -= amount;
            System.out.println(String.format("New balance after withdrawal is %.2f", balance));
        } else {
            System.out.println(String.format("Transaction denied. There is not enough funds to withdraw %.2f.", amount));
        }
    }


    public synchronized void BalanceDeposit(double depositAmount) {
        if (depositAmount > 0) {
            System.out.println(String.format("%.2f was deposited in the account.", depositAmount));
            balance += depositAmount;
            System.out.println(String.format("The new balance is %.2f", balance));
        }
    }
}

