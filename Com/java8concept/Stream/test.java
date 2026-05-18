package Com.sangram.DSA.Com.java8concept.Stream;


import java.util.Arrays;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class test {





    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8};
        int sum = Arrays.stream(array)
                .filter(n->n%2==0)
                .sum();
        System.out.println(sum);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Sangram", "IT",40000));
        employeeList.add(new Employee(2, "Amit", "HR",25000));
        employeeList.add(new Employee(3, "Neha", "IT",26000));
        employeeList.add(new Employee(4, "Rahul", "Finance",29000));
        employeeList.add(new Employee(5, "mohit", "IT",30000));
        employeeList.add(new Employee(6, "Rohit", "HR",33000));
        employeeList.add(new Employee(7, "Kiran", "Finance",31000));
        employeeList.add(new Employee(8, "Ravi", "IT",33000));




        List<String> emplp = employeeList.stream()
                .filter(emp->"IT".equals(emp.getDept()))
                .filter(n->n.getSalary() >=20000)
                .map(Employee::getName)
                .collect(Collectors.toList());


        System.out.println(emplp);

        // OR using Predicate.and()

        Predicate<Employee> isIT = e->e.getDept().equals("IT");
        Predicate<Employee> isHighpaying = e->e.getSalary()>30000;

        List<String> Emp  =  employeeList.stream()
                .filter(isIT.and(isHighpaying))
                .map(Employee::getName)
                .collect(Collectors.toList());


        System.out.println(Emp);

    }


}
