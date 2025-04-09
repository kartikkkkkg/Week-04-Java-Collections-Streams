import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    String name;
    Department department;
    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }
    public String toString() { return name; }
}

enum Department {
    HR, IT, SALES, MARKETING
}

public class GroupByDepartment {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", Department.HR));
        employees.add(new Employee("Bob", Department.IT));
        employees.add(new Employee("Carol", Department.HR));
        Map<Department, List<Employee>> groupedByDepartment = groupByDepartment(employees);
        groupedByDepartment.forEach((department, employeeList) -> System.out.println(department + ": " + employeeList));
    }

    public static Map<Department, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<Department, List<Employee>> departmentMap = new HashMap<>();
        for (Employee employee : employees) {
            departmentMap.computeIfAbsent(employee.department, k -> new ArrayList<>()).add(employee);
        }
        return departmentMap;
    }
}