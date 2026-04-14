package Intermediate_Prog;

import java.io.*;
import java.util.*;
import java.time.LocalDateTime;

public class Labrador_KimLouise_Task9 {

    static void main() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            IO.println("----- WATER BILLING SYSTEM -----");
            IO.print("""
                    1. Add Account Record
                    2. View All Records
                    3. View File Information
                    4. Delete File
                    5. Search Account Record
                    6. Exit
                    """);

            IO.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addAccountRecord(scanner);
                case 2 -> viewAllRecords();
                case 3 -> viewFileInformation();
                case 4 -> deleteFile(scanner);
                case 5 -> searchAccountRecord(scanner);
                case 6 -> {
                    IO.println("Exiting...");
                    return;
                }
                default -> IO.println("Invalid choice.");
            }

            IO.println();
        }
    }

    // ------------------- ACCOUNT RECORD METHODS ------------------

    /**
     * Validates the account number before saving.
     * The account number must follow the format `XXX-XX-XXXX` and must not already
     * exist in the file.
     */
    static String validatedAccountNo(Scanner scanner) {
        String accountNo;

        IO.print("Enter Account Number: ");
        accountNo = scanner.nextLine().trim();

        for (AccountRecord record : parseFromFile()) {
            if (record.accountNumber.equals(accountNo)) {
                IO.println("Account number already exists. Please enter a unique account number.");
                return validatedAccountNo(scanner);
            }
        }

        if (!accountNo.matches("\\d{3}-\\d{2}-\\d{4}")) {
            IO.println("Invalid account number format. Please enter in the format XXX-XX-XXXX.");
            return validatedAccountNo(scanner);
        }

        return accountNo;
    }

    /**
     * Adds one or more account records.
     * For each record, the user enters an account number, name, and address.
     * The data is then saved to `accounts.txt` in a simple line-based format.
     */
    static void addAccountRecord(Scanner scanner) {
        while (true) {
            IO.println("\n----- ADD ACCOUNT RECORD -----");

            String accountNumber = validatedAccountNo(scanner);

            IO.print("Enter Name: ");
            String name = scanner.nextLine().trim();

            IO.print("Enter Address: ");
            String address = scanner.nextLine().trim();

            saveToFile(accountNumber, name, address);

            IO.print("\nDo you want to enter another account? (Y/N): ");
            String continueInput = scanner.nextLine().toUpperCase();

            IO.println();

            if (continueInput.equals("N"))
                break;
        }
    }

    /**
     * Displays every saved account record.
     * The program reads the file first, then prints each record in a readable report style.
     */
    static void viewAllRecords() {
        ArrayList<AccountRecord> accountRecords = parseFromFile();

        for (AccountRecord record : accountRecords) {
            IO.print("\n----- " + record.name.toUpperCase() + "'S ACCOUNT INFORMATION -----\n");
            IO.println("Name: " + record.name);
            IO.println("Address: " + record.address);
            IO.println("Account Number: " + record.accountNumber);
            IO.println("Date Created: " + record.dateCreated);

            IO.println("\nZone: " + record.zone);
            IO.println("Classification: " + record.classification);
            IO.println("Pipe Size: " + record.pipeSize);
        }
    }

    /**
     * Shows basic information about `accounts.txt`.
     * This includes the file name, size, and last modified date.
     */
    static void viewFileInformation() {
        try {
            File file = new File("accounts.txt");

            IO.println("\n----- FILE INFORMATION -----");

            if (file.exists()) {
                IO.println("File Name: " + file.getName());
                IO.println("File Size: " + file.length() + " bytes");
                IO.println("Last Modified: " + new Date(file.lastModified()));
            } else {
                IO.println("File does not exist.");
            }
        } catch (Exception e) {
            IO.println("An error occurred while retrieving file information: " + e.getMessage());
        }
    }

    /**
     * Deletes the `accounts.txt` file after confirming with the user.
     */
    static void deleteFile(Scanner scanner) {
        IO.println("\n----- DELETE FILE -----");
        IO.print("Are you sure you want to delete the file? (Y/N): ");
        String confirmation = scanner.nextLine().toUpperCase();

        if (confirmation.equals("Y")) {
            File file = new File("accounts.txt");
            if (file.exists()) {
                if (file.delete())
                    IO.println("File deleted successfully.");
                else
                    IO.println("Failed to delete the file.");
            } else
                IO.println("File does not exist.");
        } else
            IO.println("File deletion cancelled.");
    }

    /**
     * Searches for one account by account number.
     * The program scans the saved records and prints the first matching entry.
     */
    static void searchAccountRecord(Scanner scanner) {
        IO.println("\n----- SEARCH ACCOUNT RECORD -----");
        IO.print("Enter Account Number to search: ");
        String accountNumber = scanner.nextLine();

        ArrayList<AccountRecord> accountRecords = parseFromFile();

        for (AccountRecord record : accountRecords) {
            if (record.accountNumber.equals(accountNumber)) {
                IO.print("\n----- ACCOUNT INFORMATION -----\n");
                IO.println("Name:" + record.name);
                IO.println("Address:" + record.address);
                IO.println("Account Number:" + record.accountNumber);
                IO.println("Date Created:" + record.dateCreated);

                IO.println("\nZone:" + record.zone);
                IO.println("Classification:" + record.classification);
                IO.println("Pipe Size:" + record.pipeSize);

                return;
            }
        }

        IO.println("Account not found.");
    }


    // ------------------- FILE HANDLING METHODS ------------------

    /**
     * Saves one account record to `accounts.txt`.
     * Each record is written as one data line followed by a separator line:
     * account number, name, address, and creation timestamp.
     */
    static void saveToFile(String accountNumber, String name, String address) {
        try {
            FileWriter fileWriter = new FileWriter("accounts.txt", true);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.write(accountNumber + ", " + name + ", " + address + ", " + LocalDateTime.now() + "\n");
            writer.write("-----\n");

            writer.close();
        } catch (IOException e) {
            IO.println("An error occurred while saving to file: " + e.getMessage());
        }
    }

    /**
     * Reads all records from `accounts.txt` and converts them into `Intermediate_Prog.AccountRecord` objects.
     * The file is expected to contain one data line per record, with `-----` used as a separator.
     */
    static ArrayList<AccountRecord> parseFromFile() {
        ArrayList<AccountRecord> accountRecords = new ArrayList<>();

        try {
            // Create the file first if it is missing so the rest of the program can continue safely.
            File file = new File("accounts.txt");
            if (!file.exists()) {
                boolean created = file.createNewFile();
                if (created) {
                    IO.println("File does not exist. A new file has been created.");
                }
            }

            BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"));

            String line;

            while ((line = reader.readLine()) != null) {
                // Skip separator lines and parse only real record lines.
                if (!line.equals("-----")) {
                    String[] values = line.split(", ");

                    String accountNumber = values[0];
                    String name = values[1];
                    String address = values[2];
                    Date dateCreated = values[3].equals("null") ? null : Date.from(LocalDateTime.parse(values[3].trim()).atZone(TimeZone.getDefault().toZoneId()).toInstant());

                    accountRecords.add(new AccountRecord(accountNumber, name, address, dateCreated));
                }
            }

        } catch (IOException e) {
            IO.println("An error occurred while reading from file: " + e.getMessage());
        }

        return accountRecords;
    }
}

/**
 * Stores one account record and computes extra display fields from the account number.
 */
class AccountRecord {
    String accountNumber;
    String name;
    String address;
    String zone;
    String classification;
    String pipeSize;
    Date dateCreated;

    /**
     * Creates a record and derives the display fields used by the reports.
     */
    public AccountRecord(String accountNumber, String name, String address, Date dateCreated) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.address = address;
        this.zone = getZone(accountNumber);
        this.classification = getClassification(accountNumber);
        this.pipeSize = getPipeSize(accountNumber);
        this.dateCreated = dateCreated;
    }

    /**
     * Gets the zone part from the account number.
     */
    static String getZone(String accountNo) {
        return accountNo.substring(0, 3);
    }

    /**
     * Converts the classification digit into a readable label.
     */
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

    /**
     * Converts the pipe-size digit into a readable pipe size.
     */
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