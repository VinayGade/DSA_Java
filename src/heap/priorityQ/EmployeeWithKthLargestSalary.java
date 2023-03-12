package heap.priorityQ;

import heap.beans.Employee;
import heap.beans.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class EmployeeWithKthLargestSalary {

    public Employee kthLargestSalary(List<Employee> employees, int k) {
        // Java 7
        //Queue<Employee> employeeQueue = new PriorityQueue<Employee>(employees.size(), new EmployeeComparator());

        // Java 8
        Queue<Employee> employeeQueue = new PriorityQueue<>(employees.size(),
            (Employee o1, Employee o2) -> Float.compare(o2.getSalary(), o1.getSalary())
        );

        employeeQueue.addAll(employees);

        for(int i=0; i<(k-1); i++) {
            System.out.println((i+1)+" th Employee :"+employeeQueue.peek().toString());
            employeeQueue.poll();
        }
        return employeeQueue.peek();
    }

    public static void main(String[] args) {

        Employee e1 = new Employee();
        e1.setName("Vinay");
        e1.setId(101);
        e1.setDesignation("Software Engineer");
        e1.setSalary(45000);

        Employee e2 = new Employee();
        e2.setName("Vikas");
        e2.setId(304);
        e2.setDesignation("Devops Engineer");
        e2.setSalary(50000);

        Employee e3 = new Employee();
        e3.setId(507);
        e3.setName("Ganesh");
        e3.setDesignation("Team Lead");
        e3.setSalary(75000);

        Employee e4 = new Employee();
        e4.setName("Rahul");
        e4.setId(215);
        e4.setDesignation("Sr Software Engineer");
        e4.setSalary(54000);

        Employee e5 = new Employee();
        e5.setId(906);
        e5.setName("Dinesh");
        e5.setDesignation("Business Analyst");
        e5.setSalary(80000);

        Employee e6 = new Employee();
        e6.setId(815);
        e6.setName("Amrut");
        e6.setDesignation("Project Manager");
        e6.setSalary(100000);

        Employee e7 = new Employee();
        e7.setId(471);
        e7.setName("Vivek");
        e7.setDesignation("Quality Engineer");
        e7.setSalary(40000);

        Employee e8 = new Employee();
        e8.setId(621);
        e8.setName("Siddhesh");
        e8.setDesignation("UI/UX Engineer");
        e8.setSalary(42000);

        Employee e9 = new Employee();
        e9.setId(703);
        e9.setName("Sushant");
        e9.setDesignation("Full Stack Developer");
        e9.setSalary(60000);

        EmployeeWithKthLargestSalary kthLargest = new EmployeeWithKthLargestSalary();

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        employees.add(e6);
        employees.add(e7);
        employees.add(e8);
        employees.add(e9);

        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();

        Employee kthLargestEmployee = kthLargest.kthLargestSalary(employees, k);

        System.out.println(k+"th Largest Employee :");
        System.out.println(kthLargestEmployee.toString());
    }
}

// Java 7
class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Float.compare(o2.getSalary(), o1.getSalary());
    }
}
