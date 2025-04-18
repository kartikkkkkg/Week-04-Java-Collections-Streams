import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class EmployeeDataProcessing {
    public Map<String, Double> processEmployees(List<Employee> employees) {
        return employees.stream()
                .filter(e -> e.department.equals("Engineering") && e.salary > 80000)
                .sorted(Comparator.comparingDouble((Employee e) -> e.salary).reversed())
                .collect(Collectors.groupingBy(
                        e -> e.department,
                        Collectors.averagingDouble(e -> e.salary)
                ));
    }
}