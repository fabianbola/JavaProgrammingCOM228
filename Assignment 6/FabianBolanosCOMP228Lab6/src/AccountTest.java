
import java.util.ArrayList; // For creating a list of transactions
import java.util.concurrent.ExecutorService; // For managing a thread pool
import java.util.concurrent.Executors; // To create thread pool executors
import java.util.concurrent.TimeUnit;

public class AccountTest {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(4);

        Account account = new Account(3000);

        System.out.println(String.format("Current balance: %.2f%n", account.getBalance()));

        ArrayList<Transaction> transactionsAccount = new ArrayList<Transaction>();
        transactionsAccount.add(new Transaction(account, 100, true));
        transactionsAccount.add(new Transaction(account, 2200, false));
        transactionsAccount.add(new Transaction(account, 1200, false));
        transactionsAccount.add(new Transaction(account, 550, true));
        transactionsAccount.add(new Transaction(account, 600, true));
        transactionsAccount.add(new Transaction(account, 1200, false));

        for (Transaction transaction : transactionsAccount) {
            executor.execute(transaction);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println(String.format("Not all tasks finished in the timeout period. Forcing shutdown."));
                executor.shutdownNow();
            } else {
                System.out.println(String.format("All tasks completed within the timeout period."));
            }
        } catch (InterruptedException e) {
            System.out.println("The awaitTermination method was interrupted. Forcing shutdown.");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println(String.format("Final account balance: %.2f", account.getBalance()));
    }
}