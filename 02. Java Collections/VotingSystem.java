import java.util.*;

public class VotingSystem {
    private Map<String, Integer> votesHashMap = new HashMap<>();
    private Map<String, Integer> votesLinkedHashMap = new LinkedHashMap<>();
    private Map<String, Integer> votesTreeMap = new TreeMap<>();

    public void vote(String candidate) {
        votesHashMap.put(candidate, votesHashMap.getOrDefault(candidate, 0) + 1);
        votesLinkedHashMap.put(candidate, votesLinkedHashMap.getOrDefault(candidate, 0) + 1);
        votesTreeMap.put(candidate, votesTreeMap.getOrDefault(candidate, 0) + 1);
    }

    public void displayResults() {
        System.out.println("Votes in HashMap:");
        votesHashMap.forEach((k, v) -> System.out.println(k + " : " + v + " votes"));
        System.out.println("\nVotes in LinkedHashMap (Order of Votes):");
        votesLinkedHashMap.forEach((k, v) -> System.out.println(k + " : " + v + " votes"));
        System.out.println("\nVotes in TreeMap (Sorted by Candidate):");
        votesTreeMap.forEach((k, v) -> System.out.println(k + " : " + v + " votes"));
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        votingSystem.vote("Alice");
        votingSystem.vote("Bob");
        votingSystem.vote("Alice");
        votingSystem.displayResults();
    }
}