import java.util.PriorityQueue;

class Patient {
    String name;
    int severity;
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
    public String toString() { return name + " (Severity: " + severity + ")"; }
}

public class HospitalTriage {
    public static void main(String[] args) {
        PriorityQueue<Patient> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.severity, p1.severity));
        pq.add(new Patient("John", 3));
        pq.add(new Patient("Alice", 5));
        pq.add(new Patient("Bob", 2));
        System.out.println("Triage Order:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}