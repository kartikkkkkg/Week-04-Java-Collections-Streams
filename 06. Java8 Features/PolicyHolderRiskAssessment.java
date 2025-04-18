import java.util.*;
import java.util.stream.Collectors;

class PolicyHolder {
    String holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;

    PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }
}

class RiskAssessment {
    String holderId;
    String name;
    double riskScore;

    RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }
}

public class PolicyHolderRiskAssessment {
    public Map<String, List<RiskAssessment>> assessRisk(List<PolicyHolder> holders) {
        return holders.stream()
                .filter(h -> h.policyType.equals("Life") && h.age > 60)
                .map(h -> new RiskAssessment(h.holderId, h.name, h.premiumAmount / h.age))
                .sorted(Comparator.comparingDouble((RiskAssessment ra) -> ra.riskScore).reversed())
                .collect(Collectors.groupingBy(
                        ra -> ra.riskScore > 0.5 ? "High Risk" : "Low Risk"
                ));
    }
}