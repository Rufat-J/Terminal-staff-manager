package org.Perfekta_Produkter_AB;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputValidator {

    public static String getValidGender(Scanner scanner) {
        String gender;
        boolean isValidGender = false;

        do {
            System.out.print("Gender (Male/Female): ");
            gender = scanner.nextLine();

            if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")) {
                isValidGender = true;
            } else {
                System.out.println("Invalid gender! Please use 'Male' or 'Female'.");
            }
        } while (!isValidGender);

        return gender;
    }

    public static Date getValidDate(Scanner scanner, String prompt) {
        Date date = null;
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        inputDateFormat.setLenient(false); // To ensure strict date parsing
        boolean isValidDate = false;

        while (!isValidDate) {
            System.out.print(prompt); // Prompt for date with a custom message
            String dateStr = scanner.nextLine();

            try {
                date = inputDateFormat.parse(dateStr);
                isValidDate = true; // If parsing succeeds, the date is valid
            } catch (ParseException e) {
                System.out.println("Invalid date format! Please use 'yyyy-MM-dd' format.");
            }
        }

        return date;
    }
}
