package org.Perfekta_Produkter_AB;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static org.Perfekta_Produkter_AB.InputValidator.getValidGender;

public class Intern extends Person {

    private Date endDate;
    private String comments;

    public Intern(String name, String gender, Date endDate) {
        super( name, gender);
        this.endDate = endDate;
        this.comments = "";
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    static Intern addIntern(Scanner scanner) {
        System.out.println("Add Intern:");

        System.out.print("Name: ");
        String intName = scanner.nextLine();
        String intGender = getValidGender(scanner);
        Date intEndDate = InputValidator.getValidDate(scanner, "End Date (yyyy-MM-dd): ");

        return new Intern(intName, intGender, intEndDate);
    };

    public static void editInternComments(List<Intern> interns, Scanner scanner) {
        System.out.println("Enter the ID of the intern to edit comments:");
        String internId = scanner.nextLine();

        // Find the intern by ID
        Intern internToUpdate = null;
        for (Intern intern : interns) {
            if (intern.getId().equals(internId)) {
                internToUpdate = intern;
                break;
            }
        }

        if (internToUpdate != null) {
            System.out.println("Current Comments: " + internToUpdate.getComments());
            System.out.println("Enter new comments (or press Enter to keep the current comments):");
            String newComments = scanner.nextLine();

            if (!newComments.isEmpty()) {
                internToUpdate.setComments(newComments);
                System.out.println("Comments updated successfully.");
            } else {
                System.out.println("No changes made.");
            }
        } else {
            System.out.println("Intern with ID " + internId + " not found.");
        }
    }

    public static void showAllInterns(List<Intern> interns, DateTimeFormatter dateFormatter, Scanner scanner) {

        if (interns.size() < 1) {
            System.out.println("There is no active interns.");
        } else {

            String separator = "+------------+----------------------+------------+-----------------+------------------+";
            System.out.println("Total interns: " + interns.size());
            System.out.println(separator);
            System.out.println("|     ID     |         Name         |   Gender   |     End Date    |     Comments     |");
            System.out.println(separator);
            for (Intern intern : interns) {
                LocalDate endDate = intern.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                System.out.printf("| %-10s | %-20s | %-10s | %-15s | %-16s |\n",
                        intern.getId(), intern.getName(), intern.getGender(),
                        endDate.format(dateFormatter), intern.comments);
            }
            System.out.println("+------------+----------------------+------------+-----------------+------------------+");
        }
        System.out.println("Press 'Enter' to exit");
        scanner.nextLine();
    }
}
