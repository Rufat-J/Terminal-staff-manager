package org.Perfekta_Produkter_AB;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Utilities {
    public static void showTotalStaff(List<Employee> employees, List<Intern> interns, Scanner scanner) {
        System.out.println("Total Staff: " + (employees.size() + interns.size()));
        System.out.println("Press 'Enter' to exit");
        scanner.nextLine();
    }

    public static void calculateAverageSalaryByGender(List<Employee> employees, Scanner scanner) {
        double totalMaleSalary = 0.0;
        int maleEmployeeCount = 0;
        double totalFemaleSalary = 0.0;
        int femaleEmployeeCount = 0;
        for (Employee employee : employees) {
            if (employee.getGender().equalsIgnoreCase("Male")) {
                totalMaleSalary += employee.getSalary();
                maleEmployeeCount++;
            } else if (employee.getGender().equalsIgnoreCase("Female")) {
                totalFemaleSalary += employee.getSalary();
                femaleEmployeeCount++;
            }
        }
        if (maleEmployeeCount > 0) {
            double averageMaleSalary = totalMaleSalary / maleEmployeeCount;
            System.out.println("Average male salary: " + averageMaleSalary);
        } else {
            System.out.println("No male employees found.");
        }
        if (femaleEmployeeCount > 0) {
            double averageFemaleSalary = totalFemaleSalary / femaleEmployeeCount;
            System.out.println("Average female salary: " + averageFemaleSalary);
        } else {
            System.out.println("No female employees found.");
        }
        System.out.println("Press 'Enter' to exit");
        scanner.nextLine();
    }


    public static void showEmployeeRankingByDate(List<Employee> employees, DateTimeFormatter dateFormatter, Scanner scanner) {
        // Sort employees by start date in ascending order
        employees.sort(Comparator.comparing(Employee::getStartDate));
        System.out.println("Ranking of Employees by Start Date (Earliest to Latest):");
        System.out.println("+------------+----------------------+------------+-----------------+----------------+");
        System.out.println("|     ID     |         Name         |   Gender   |    Start Date   |     Salary     |");
        System.out.println("+------------+----------------------+------------+-----------------+----------------+");
        for (Employee employee : employees) {
            LocalDate startDate = employee.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            System.out.printf("| %-10s | %-20s | %-10s | %-15s | %-14s |\n",
                    employee.getId(), employee.getName(), employee.getGender(),
                    startDate.format(dateFormatter), employee.getSalary());
        }
        System.out.println("+------------+----------------------+------------+-----------------+----------------+");
        System.out.println("Press 'Enter' to exit");
        scanner.nextLine(); // Make sure 'scanner' is accessible in this method
    }

}
