import java.util.*;
import java.util.stream.Collectors;

class Person {
    String name;
    int age;
    double salary;

    Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}

public class SortPersons {
    public List<Person> sortPersons(List<Person> persons) {
        return persons.stream()
                .sorted((p1, p2) -> Integer.compare(p1.age, p2.age))
                .collect(Collectors.toList());
    }
}