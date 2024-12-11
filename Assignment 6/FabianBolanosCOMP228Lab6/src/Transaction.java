public class Transaction implements Runnable{

    private final Account account;
    private final boolean typeTransaction;
    private final double amount;


    public Transaction(Account account, double amountTransaction, boolean typeTransaction ) {
        this.account = account;
        this.typeTransaction = typeTransaction;
        this.amount = amountTransaction;
    }

    @Override
    public void run() {
        if (typeTransaction) {
            account.BalanceDeposit(amount);
        } else {
            account.BalanceWithdraw(amount);
        }
    }
}