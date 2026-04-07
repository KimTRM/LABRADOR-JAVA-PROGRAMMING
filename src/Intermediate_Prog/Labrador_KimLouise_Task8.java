package Intermediate_Prog;

import java.util.Scanner;

public class Labrador_KimLouise_Task8 {

    static void main() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            IO.println("----- WATER BILLING SYSTEM -----");
            IO.print("Enter Account Number: ");
            String accountNumber = scanner.nextLine();

            IO.print("Enter Name: ");
            String name = scanner.nextLine();

            IO.print("Enter Address: ");
            String address = scanner.nextLine();

            boolean isValidated = validateAccountNo(accountNumber);

            while (!isValidated) {
                IO.print("Enter Account Number: ");
                accountNumber = scanner.nextLine();

                isValidated = validateAccountNo(accountNumber);
            }

            IO.print("\n----- ACCOUNT INFORMATION -----\n");
            IO.println("Name:" + name);
            IO.println("Address:" + address);
            IO.println("Account Number:" + accountNumber);

            IO.println("\nZone:" + getZone(accountNumber));
            IO.println("Classification:" + getClassification(accountNumber));
            IO.println("Pipe Size:" + getPipeSize(accountNumber));

            IO.print("\nDo you want to enter another account? (yes/no): ");
            String continueInput = scanner.nextLine().trim().toLowerCase();

            IO.println();

            if (!continueInput.equals("yes")) {
                IO.println("Exiting...");
                break;
            }
        }
    }

    static boolean validateAccountNo(String accountNo) {
        String format = "XXX-XX-XXXX";

        if (accountNo.length() != format.length()) {
            IO.println("Invalid account number format. Please enter in the format XXX-XX-XXXX.");
            return false;
        }

        for (int i = 0; i < format.length(); i++) {
            char expectedChar = format.charAt(i);
            char actualChar = accountNo.charAt(i);

            if (expectedChar == 'X' && !Character.isDigit(actualChar)) {
                IO.println("Invalid account number format. Please enter in the format XXX-XX-XXXX.");
                return false;
            } else if (expectedChar == '-' && actualChar != '-') {
                IO.println("Invalid account number format. Please enter in the format XXX-XX-XXXX.");
                return false;
            }
        }

//        return accountNo.matches("\\d{3}-\\d{2}-\\d{4}");

        return true;
    }

    static String getZone(String accountNo) {
        return accountNo.substring(0, 3);
    }

    static String getClassification(String accountNo) {
        String classification = "";
        char zone = accountNo.charAt(4);

        switch (zone) {
            case '1' -> classification = "Residential";
            case '2' -> classification = "Commercial";
            case '3' -> classification = "Industrial ";
            case '4' -> classification = "Government";
            case '5' -> classification = "Institutional";
            case '6' -> classification = "Agricultural";
            case '7' -> classification = "Non-Profit";
            case '8' -> classification = "Construction";
            case '9' -> classification = "Other";
        }

        return classification;
    }

    static String getPipeSize(String accountNo) {
        String PipeSize = "";
        char zone = accountNo.charAt(5);

        switch (zone) {
            case '1' -> PipeSize = "1/2";
            case '2' -> PipeSize = "3/4";
            case '3' -> PipeSize = "1 ";
            case '4' -> PipeSize = "2";
            case '5' -> PipeSize = "3";
            case '6' -> PipeSize = "4";
            case '7' -> PipeSize = "6";
            case '8' -> PipeSize = "8";
            case '9' -> PipeSize = "10";
        }

        return PipeSize;
    }
}
