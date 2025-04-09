import java.util.*;

class InsurancePolicy {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, Date expiryDate, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyholderName() { return policyholderName; }
    public Date getExpiryDate() { return expiryDate; }
    public String toString() { return "Policy Number: " + policyNumber + ", Policyholder: " + policyholderName + ", Expiry Date: " + expiryDate + ", Premium: " + premiumAmount; }
}

public class InsurancePolicyManagementMap {
    private Map<String, InsurancePolicy> hashMap = new HashMap<>();
    private Map<String, InsurancePolicy> linkedHashMap = new LinkedHashMap<>();
    private Map<String, InsurancePolicy> treeMap = new TreeMap<>();

    public void addPolicy(InsurancePolicy policy) {
        hashMap.put(policy.getPolicyNumber(), policy);
        linkedHashMap.put(policy.getPolicyNumber(), policy);
        treeMap.put(policy.getPolicyNumber(), policy);
    }

    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return hashMap.get(policyNumber);
    }

    public List<InsurancePolicy> getPoliciesExpiringSoon(int days) {
        Date currentDate = new Date();
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();
        for (InsurancePolicy policy : hashMap.values()) {
            long diff = policy.getExpiryDate().getTime() - currentDate.getTime();
            if (diff <= (days * 24 * 60 * 60 * 1000L)) {
                expiringPolicies.add(policy);
            }
        }
        return expiringPolicies;
    }

    public List<InsurancePolicy> getPoliciesByHolder(String policyholderName) {
        List<InsurancePolicy> result = new ArrayList<>();
        for (InsurancePolicy policy : hashMap.values()) {
            if (policy.getPolicyholderName().equals(policyholderName)) {
                result.add(policy);
            }
        }
        return result;
    }

    public void displayPolicies(Map<String, InsurancePolicy> map) {
        for (InsurancePolicy policy : map.values()) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagementMap policyManagement = new InsurancePolicyManagementMap();
        policyManagement.addPolicy(new InsurancePolicy("P001", "John Doe", new Date(System.currentTimeMillis() + (60 * 24 * 60 * 60 * 1000L)), 500.0));
        policyManagement.addPolicy(new InsurancePolicy("P002", "Jane Smith", new Date(System.currentTimeMillis() + (15 * 24 * 60 * 60 * 1000L)), 600.0));
        policyManagement.addPolicy(new InsurancePolicy("P003", "Alice Brown", new Date(System.currentTimeMillis() + (5 * 24 * 60 * 60 * 1000L)), 300.0));

        System.out.println("All Policies in LinkedHashMap:");
        policyManagement.displayPolicies(policyManagement.linkedHashMap);

        System.out.println("\nPolicies expiring soon (within 30 days):");
        policyManagement.getPoliciesExpiringSoon(30).forEach(System.out::println);

        System.out.println("\nPolicies for Jane Smith:");
        policyManagement.getPoliciesByHolder("Jane Smith").forEach(System.out::println);
    }
}