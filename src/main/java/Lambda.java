import java.util.Arrays;
import java.util.Comparator;

public class Lambda {

    public static void main(String[] args) {

        Employee[] employees = new Employee[]{
                new Employee("eswar", 34, 10000),
                new Employee("geeta", 27, 11000),
                new Employee("lakhit", 3, 9000)
        };

        Arrays.sort(employees, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return o1.age - o2.age;
            }
        });

        Arrays.sort(employees, Comparator.comparingInt(Employee::getSalary));

        Arrays.sort(employees, (emp1, emp2) -> emp2.age - emp1.age );

        for(Employee emp : employees) {
            System.out.println(emp.name);
        }
    }
}


class Employee {
    String name;
    int age;
    int salary;

    public int getAge() {
        return this.age;
    }

    public int getSalary() {
        return salary;
    }

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

//    public int compareTo(Object emp) {
//        if (emp instanceof Employee)
//            return this.name.compareTo(((Employee) emp).name);
//        return -1;
//    }
}