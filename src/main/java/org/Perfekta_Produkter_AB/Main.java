package org.Perfekta_Produkter_AB;

import java.time.format.DateTimeFormatter;
import java.util.*;
import static org.Perfekta_Produkter_AB.Employee.addEmployee;
import static org.Perfekta_Produkter_AB.Intern.addIntern;
import static org.Perfekta_Produkter_AB.MainMenu.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        List<Intern> interns = new ArrayList<>();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        boolean isRunning = true;

        while (isRunning) {
           displayMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case ADD_EMPLOYEE_OPTION -> {
                    Employee newEmployee = addEmployee(scanner);
                    employees.add(newEmployee);
                }
                case ADD_INTERN_OPTION -> {
                    Intern newIntern = addIntern(scanner);
                    interns.add(newIntern);
                }
                case SHOW_ALL_EMPLOYEES -> {
                    Employee.showAllEmployees(employees, dateFormatter, scanner);
                }

                case SHOW_TOTAL_STAFF -> {
                    Utilities.showTotalStaff(employees, interns, scanner);
                }
                case AVERAGE_SALARY_BY_GENDER -> {
                    Utilities.calculateAverageSalaryByGender(employees, scanner);
                }
                case SHOW_EMPLOYEE_RANKING_BY_DATE -> {
                    Utilities.showEmployeeRankingByDate(employees, dateFormatter, scanner);
                }

                case EDIT_INTERN_COMMENTS_OPTION -> {
                    Intern.editInternComments(interns, scanner);
                }
                case EXIT_OPTION -> {
                    System.out.println("Closing terminal");
                    System.exit(0);
                }

                case SHOW_ALL_INTERNS -> {
                    Intern.showAllInterns(interns, dateFormatter, scanner);
                }

                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
