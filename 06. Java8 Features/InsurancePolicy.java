import java.util.*;
import java.util.stream.Collectors;

class InsurancePolicy {
    String policyNumber;
    String holderName;
    double premiumAmount;

    InsurancePolicy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public String toString() {
        return "Policy: " + policyNumber + ", Holder: " + holderName + ", Premium: $" + premiumAmount;
    }
}

public class InsurancePolicyProcessor {
    public List<InsurancePolicy> filterByPremium(List<InsurancePolicy> policies) {
        return policies.stream()
                .filter(p -> p.premiumAmount > 1200)
                .collect(Collectors.toList());
    }

    public List<InsurancePolicy> sortByHolderName(List<InsurancePolicy> policies) {
        return policies.stream()
                .sorted((p1, p2) -> p1.holderName.compareTo(p2.holderName))
                .collect(Collectors.toList());
    }

    public double computeTotalPremium(List<InsurancePolicy> policies) {
        return policies.stream()
                .mapToDouble(p -> p.premiumAmount)
                .sum();
    }

    public void printPolicyDetails(List<InsurancePolicy> policies) {
        policies.forEach(p -> System.out.println(p.toString()));
    }

    public List<InsurancePolicy> filterByPremiumRange(List<InsurancePolicy> policies) {
        return policies.stream()
                .filter(p -> p.premiumAmount >= 1000 && p.premiumAmount <= 2000)
                .collect(Collectors.toList());
    }

    public Optional<InsurancePolicy> findHighestPremiumPolicy(List<InsurancePolicy> policies) {
        return policies.stream()
                .max(Comparator.comparingDouble(p -> p.premiumAmount));
    }

    public Map<Character, List<InsurancePolicy>> groupByHolderInitial(List<InsurancePolicy> policies) {
        return policies.stream()
                .collect(Collectors.groupingBy(p -> p.holderName.charAt(0)));
    }

    public double computeAveragePremium(List<InsurancePolicy> policies) {
        return policies.stream()
                .mapToDouble(p -> p.premiumAmount)
                .average()
                .orElse(0.0);
    }

    public void sortAndPrintByPremium(List<InsurancePolicy> policies) {
        policies.stream()
                .sorted(Comparator.comparingDouble(p -> p.premiumAmount))
                .forEach(p -> System.out.println(p.toString()));
    }

    public boolean hasPolicyAboveThreshold(List<InsurancePolicy> policies) {
        return policies.stream()
                .anyMatch(p -> p.premiumAmount > 2000);
    }

    public Map<String, Long> countPoliciesByPremiumRange(List<InsurancePolicy> policies) {
        return policies.stream()
                .collect(Collectors.groupingBy(
                        p -> {
                            if (p.premiumAmount <= 1000) return "$0-$1000";
                            else if (p.premiumAmount <= 2000) return "$1001-$2000";
                            else return ">$2000";
                        },
                        Collectors.counting()
                ));
    }

    public List<String> extractUniqueHolderNames(List<InsurancePolicy> policies) {
        return policies.stream()
                .map(p -> p.holderName)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<InsurancePolicy> findByHolderNameSubstring(List<InsurancePolicy> policies, String substring) {
        return policies.stream()
                .filter(p -> p.holderName.contains(substring))
                .collect(Collectors.toList());
    }

    public Map<String, Double> mapPolicyNumberToPremium(List<InsurancePolicy> policies) {
        return policies.stream()
                .collect(Collectors.toMap(
                        p -> p.policyNumber,
                        p -> p.premiumAmount
                ));
    }
}