import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    String transactionId;
    String policyNumber;
    double amount;
    Date transactionDate;
    boolean isFraudulent;

    Transaction(String transactionId, String policyNumber, double amount, Date transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }
}

class FraudSummary {
    long fraudCount;
    double totalFraudAmount;

    FraudSummary(long fraudCount, double totalFraudAmount) {
        this.fraudCount = fraudCount;
        this.totalFraudAmount = totalFraudAmount;
    }
}

public class FraudDetection {
    public List<String> detectFraud(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.isFraudulent && t.amount > 10000)
                .collect(Collectors.groupingBy(
                        t -> t.policyNumber,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> new FraudSummary(
                                        list.size(),
                                        list.stream().mapToDouble(t -> t.amount).sum()
                                )
                        )
                ))
                .entrySet().stream()
                .filter(e -> e.getValue().fraudCount > 5 || e.getValue().totalFraudAmount > 50000)
                .map(e -> "Alert: Policy " + e.getKey() + " - Fraud Count: " + e.getValue().fraudCount + ", Total Amount: " + e.getValue().totalFraudAmount)
                .collect(Collectors.toList());
    }
}