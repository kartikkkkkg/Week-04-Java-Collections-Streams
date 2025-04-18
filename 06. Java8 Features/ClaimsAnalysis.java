import java.util.*;
import java.util.stream.Collectors;

class Claim {
    String claimId;
    String policyNumber;
    double claimAmount;
    Date claimDate;
    String status;

    Claim(String claimId, String policyNumber, double claimAmount, Date claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }
}

class PolicySummary {
    double totalClaimAmount;
    double averageClaimAmount;

    PolicySummary(double totalClaimAmount, double averageClaimAmount) {
        this.totalClaimAmount = totalClaimAmount;
        this.averageClaimAmount = averageClaimAmount;
    }
}

public class ClaimsAnalysis {
    public List<Map.Entry<String, PolicySummary>> analyzeClaims(List<Claim> claims) {
        return claims.stream()
                .filter(c -> c.status.equals("Approved") && c.claimAmount > 5000)
                .collect(Collectors.groupingBy(
                        c -> c.policyNumber,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> new PolicySummary(
                                        list.stream().mapToDouble(c -> c.claimAmount).sum(),
                                        list.stream().mapToDouble(c -> c.claimAmount).average().orElse(0)
                                )
                        )
                ))
                .entrySet().stream()
                .sorted(Comparator.comparingDouble((Map.Entry<String, PolicySummary> e) -> e.getValue().totalClaimAmount).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }
}