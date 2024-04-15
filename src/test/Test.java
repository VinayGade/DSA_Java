package test;

import beans.Employee;

import java.util.*;

public class Test {

    //list-string
    //sort based on length

    /*

Input
Hi
Genpact
There

Output
Hi
There
Genpact
    * */
    public static void main(String[] args) {
        /*

        List<String> strings = new ArrayList<>();

        strings.add("Hi");
        strings.add("Genpact");
        strings.add("There");

        strings.sort((s1, s2) -> s1.length()-s2.length());

        strings.forEach(System.out::println);
        */

        Map<String, List<Employee>> employeeMap = new LinkedHashMap<>();
        Employee employee1=new Employee("Vijay", "Sales", 30, 32000.0d);

        Employee employee2=new Employee("Vinay", "Dev", 30, 30000.0d);
        Employee employee3=new Employee("Raj", "HR", 25, 28000.0d);
        Employee employee4=new Employee("Swati", "QA", 32, 35000.0d);
        Employee employee5=new Employee("Swapnil", "Management", 38, 52000.0d);
        Employee employee6=new Employee("Divya", "Management", 39, 60000.0d);

        Employee employee7=new Employee("Nilesh", "QA", 34, 39000.0d);
        Employee employee8=new Employee("Deepa", "Dev", 34, 44000.0d);

        List<Employee> employeeSales = Arrays.asList(employee1);
        List<Employee> employeeDev = Arrays.asList(employee2,employee8);
        List<Employee> employeeManagement = Arrays.asList(employee5,employee6);
        List<Employee> employeeQA = Arrays.asList(employee4,employee7);
        List<Employee> employeeHR = Arrays.asList(employee3);

        /*
        List<Employee> employees = Arrays.asList(employee1,
                employee2, employee3, employee4, employee5, employee6, employee7, employee8);

         */

        employeeMap.put("Sales", employeeSales);
        employeeMap.put("QA", employeeQA);
        employeeMap.put("Dev", employeeDev);
        employeeMap.put("HR", employeeHR);
        employeeMap.put("Management", employeeManagement);


        System.out.println("before sort:");

        populateEmployees(employeeMap);

        System.out.println("after sort:");

        employeeMap = sortEmployees(employeeMap);

        populateEmployees(employeeMap);
    }

    public static Map<String, List<Employee>> sortEmployees(Map<String, List<Employee>> employeeMap){

        List<Map.Entry<String, List<Employee>>> employees = new ArrayList<>();
        employees.addAll(employeeMap.entrySet());
        employees.sort((e1, e2) ->
                e1.getKey().compareTo(e2.getKey()));
        employeeMap.clear();
        employees.forEach(entry -> {
            employeeMap.put(entry.getKey(), entry.getValue());
        });
        return employeeMap;
    }

    public static void populateEmployees(Map<String, List<Employee>> employeeMap){
        employeeMap.forEach((k,v) ->
        {
            System.out.println("department "+k);
            for(Employee e : v){
                System.out.println(e.toString());
            }
        });
    }
}

//employee : name,age,salary,dept
//Hashmap : key :dept val:List<Employee>
//sort map based on dept