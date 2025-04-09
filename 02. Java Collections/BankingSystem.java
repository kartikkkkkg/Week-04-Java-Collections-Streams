import java.util.*;

public class BankingSystem {
    private Map<String, Double> customerAccounts = new HashMap<>();
    private Map<String, Double> customerAccountsTreeMap = new TreeMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();

    public void addAccount(String accountNumber, double balance) {
        customerAccounts.put(accountNumber, balance);
        customerAccountsTreeMap.put(accountNumber, balance);
    }

    public void deposit(String accountNumber, double amount) {
        customerAccounts.put(accountNumber, customerAccounts.get(accountNumber) + amount);
        customerAccountsTreeMap.put(accountNumber, customerAccountsTreeMap.get(accountNumber) + amount);
    }

    public void withdraw(String accountNumber, double amount) {
        if (customerAccounts.get(accountNumber) >= amount) {
            customerAccounts.put(accountNumber, customerAccounts.get(accountNumber) - amount);
            customerAccountsTreeMap.put(accountNumber, customerAccountsTreeMap.get(accountNumber) - amount);
            withdrawalQueue.add(accountNumber);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }

    public void displayAccounts() {
        System.out.println("Customer Accounts:");
        for (Map.Entry<String, Double> entry : customerAccounts.entrySet()) {
            System.out.println("Account Number: " + entry.getKey() + ", Balance: " + entry.getValue());
        }
    }

    public void displaySortedAccounts() {
        System.out.println("\nCustomer Accounts (Sorted by Account Number):");
        for (Map.Entry<String, Double> entry : customerAccountsTreeMap.entrySet()) {
            System.out.println("Account Number: " + entry.getKey() + ", Balance: " + entry.getValue());
        }
    }

    public void processWithdrawals() {
        System.out.println("\nProcessing Withdrawal Requests:");
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            System.out.println("Processed withdrawal for account: " + accountNumber);
        }
    }

    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        bankingSystem.addAccount("A123", 5000.0);
        bankingSystem.addAccount("B456", 10000.0);
        bankingSystem.deposit("A123", 2000.0);
        bankingSystem.withdraw("A123", 1000.0);
        bankingSystem.displayAccounts();
        bankingSystem.displaySortedAccounts();
        bankingSystem.processWithdrawals();
    }
}