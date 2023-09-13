package org.Perfekta_Produkter_AB;

public class MainMenu {
    static final int ADD_EMPLOYEE_OPTION = 1;
    static final int ADD_INTERN_OPTION = 2;
    static final int SHOW_ALL_EMPLOYEES = 3;
    public static final int SHOW_ALL_INTERNS = 4;
    public static final int EDIT_INTERN_COMMENTS_OPTION = 5;
    static final int SHOW_TOTAL_STAFF = 6;
    static final int AVERAGE_SALARY_BY_GENDER = 7;
    static final int SHOW_EMPLOYEE_RANKING_BY_DATE = 8;
    static final int EXIT_OPTION = 9;

    public static void displayMenu() {
        String separator = "+----------------------------------------------------+";
        System.out.println(separator);
        System.out.println("|      *** Welcome to Perfekta Produkter AB ***      |");
        System.out.println("| Choose an option                                   |");
        System.out.println("| 1. Add Employee                                    |");
        System.out.println("| 2. Add Intern                                      |");
        System.out.println("| 3. Show All Employees                              |");
        System.out.println("| 4. Show all Interns                                |");
        System.out.println("| 5. Edit Intern Comments                            |");
        System.out.println("| 6. Show Total Staff                                |");
        System.out.println("| 7. Show Average Salary by Gender                   |");
        System.out.println("| 8. Show Ranking of Employees by Start Date         |");
        System.out.println("| 9. Exit                                            |");

        System.out.println(separator);
    }




}
