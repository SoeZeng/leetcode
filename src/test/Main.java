package test;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        //write your code here......
        employees.add(new Employee("小明", 2500));
        employees.add(new Employee("小军", 8000));
        employees.add(new Employee("小红", 100000));

        for(Employee employee: employees) {
            double salary = employee.getSalary();
            salary -= 3500;
            double res;
            if(salary <= 0) {
                res = 0;
            }else if(salary <= 1500) {
                res = salary * 0.03;
            }else if(salary <= 4500) {
                res = salary * 0.1 - 105;
            }else if(salary <= 9000) {
                res = salary * 0.2 - 555;
            }else if(salary <= 35000) {
                res = salary * 0.25 - 1005;
            }else if(salary <= 55000) {
                res = salary * 0.3 - 2755;
            }else if(salary <= 80000) {
                res = salary * 0.35 - 5505;
            }else {
                res = salary * 0.45 - 13505;
            }

            System.out.println(employee.getName() + "应该缴纳的个人所得税是：" + String.format("%.1f", res));
        }



    }
}
class Employee{
    private String name;
    private double salary;
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}










