package org.Perfekta_Produkter_AB;


import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Employee extends Person{
    private double salary;
    private Date startDate;

    public Employee(String name, String gender, double salary, Date startDate) {
        super(name, gender);
        this.salary = salary;
        this.startDate = startDate;
    }

    public static Employee addEmployee(Scanner scanner) {
        System.out.println("Add employee:");

        System.out.print("Name: ");
        String empName = scanner.nextLine();

        System.out.print("Gender (Male/Female): ");
        String empGender = scanner.nextLine();

        Date empStartDate = InputValidator.getValidDate(scanner, "Start Date (yyyy-MM-dd): ");

        System.out.print("Salary: ");
        double empSalary = scanner.nextDouble();
        scanner.nextLine(); // Read the remaining newline character
        System.out.println("New Employee created");
        System.out.println("Press 'Enter' to exit");
        scanner.nextLine();


        return new Employee(empName, empGender, empSalary, empStartDate);
    }

    public static void showAllEmployees(List<Employee> employees, DateTimeFormatter dateFormatter, Scanner scanner) {

        if (employees.size() < 1) {
            System.out.println("There is no active employees.");
        } else {

            String separator = "+------------+----------------------+------------+-----------------+----------------+";
            System.out.println("Total employees: " + employees.size());
            System.out.println(separator);
            System.out.println("|     ID     |         Name         |   Gender   |    Start Date   |     Salary     |");
            System.out.println(separator);
            for (Employee employee : employees) {
                LocalDate startDate = employee.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                System.out.printf("| %-10s | %-20s | %-10s | %-15s | %-14s |\n",
                        employee.getId(), employee.getName(), employee.getGender(),
                        startDate.format(dateFormatter), employee.getSalary());
            }
            System.out.println("+------------+----------------------+------------+-----------------+----------------+");
        }
        System.out.println("Press 'Enter' to exit");
        scanner.nextLine();

    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}
