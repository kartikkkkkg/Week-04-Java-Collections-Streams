import java.util.*;

class InsurancePolicy {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyholderName() { return policyholderName; }
    public Date getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }
    public double getPremiumAmount() { return premiumAmount; }
    public String toString() { return "Policy Number: " + policyNumber + ", Policyholder: " + policyholderName + ", Expiry Date: " + expiryDate + ", Coverage: " + coverageType + ", Premium: " + premiumAmount; }
    public int hashCode() { return policyNumber.hashCode(); }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InsurancePolicy that = (InsurancePolicy) obj;
        return policyNumber.equals(that.policyNumber);
    }
}

public class InsurancePolicyManagementSet {
    private Set<InsurancePolicy> hashSet = new HashSet<>();
    private Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSet = new TreeSet<>(Comparator.comparing(InsurancePolicy::getExpiryDate));

    public void addPolicy(InsurancePolicy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public void displayPolicies(Set<InsurancePolicy> set) {
        for (InsurancePolicy policy : set) {
            System.out.println(policy);
        }
    }

    public List<InsurancePolicy> getExpiringSoon(int days) {
        Date currentDate = new Date();
        List<InsurancePolicy> expiring = new ArrayList<>();
        for (InsurancePolicy policy : hashSet) {
            long diff = policy.getExpiryDate().getTime() - currentDate.getTime();
            if (diff <= (days * 24 * 60 * 60 * 1000L)) {
                expiring.add(policy);
            }
        }
        return expiring;
    }

    public List<InsurancePolicy> getByCoverageType(String coverageType) {
        List<InsurancePolicy> result = new ArrayList<>();
        for (InsurancePolicy policy : hashSet) {
            if (policy.getCoverageType().equals(coverageType)) {
                result.add(policy);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSet system = new InsurancePolicyManagementSet();
        system.addPolicy(new InsurancePolicy("P001", "John Doe", new Date(System.currentTimeMillis() + (60 * 24 * 60 * 60 * 1000L)), "Health", 500.0));
        system.addPolicy(new InsurancePolicy("P002", "Jane Smith", new Date(System.currentTimeMillis() + (15 * 24 * 60 * 60 * 1000L)), "Auto", 600.0));
        system.addPolicy(new InsurancePolicy("P003", "Alice Brown", new Date(System.currentTimeMillis() + (5 * 24 * 60 * 60 * 1000L)), "Health", 300.0));

        System.out.println("HashSet Policies:");
        system.displayPolicies(system.hashSet);

        System.out.println("\nLinkedHashSet Policies:");
        system.displayPolicies(system.linkedHashSet);

        System.out.println("\nTreeSet Policies (Sorted by Expiry):");
        system.displayPolicies(system.treeSet);

        System.out.println("\nPolicies Expiring Soon (within 30 days):");
        system.getExpiringSoon(30).forEach(System.out::println);

        System.out.println("\nHealth Policies:");
        system.getByCoverageType("Health").forEach(System.out::println);
    }
}