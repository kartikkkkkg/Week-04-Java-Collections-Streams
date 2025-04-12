class TransactionException extends Exception {
    public TransactionException(String message) {
        super(message);
    }
}

public class TransactionProcessor {
    public void processTransaction(int amount) throws TransactionException {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Invalid amount");
            }
            System.out.println("Transaction processed: " + amount);
        } catch (IllegalArgumentException e) {
            throw new TransactionException("Transaction failed for amount " + amount + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        TransactionProcessor processor = new TransactionProcessor();
        try {
            processor.processTransaction(0);
        } catch (TransactionException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}