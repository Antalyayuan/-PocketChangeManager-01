package projectChangeMoney;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PocketChangeManagerPop {

    // Simplified process
    // 1. First, complete the menu display and allow menu selection with corresponding prompts.
    // 2. Complete the pocket change details feature.
    // 3. Implement the income addition feature.
    // 4. Implement the expenditure feature.
    // 5. Add the exit feature.
    // 6. When the user selects option 4 to exit, prompt "Are you sure you want to exit? y/n".
    // The input must be either y or n. Otherwise, repeat the prompt until y or n is entered.

    public static void main(String[] args) {
        // Define relevant variables
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";

        // 2. Complete the pocket change details feature
        // Options:
        // (1) Store income and expenditure records in an array (an expandable array might be needed).
        // (2) Use objects.
        // (3) Use string concatenation (chosen here).
        String details = "---------------Pocket Change Details----------------";

        // 3. Complete the income addition feature. Functional development introduces new logic and code.
        // Define additional variables
        double money = 0;
        double balance = 0;
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm"); // For date formatting

        // 4. Expenditure feature
        // Define a new variable to store the reason for expenditure
        String note = "";

        // Use do-while to ensure the menu is displayed at least once
        do {
            System.out.println("\n==============Pocket Change Menu==============");
            System.out.println("\t\t\t1 Pocket Change Details");
            System.out.println("\t\t\t2 Add Income");
            System.out.println("\t\t\t3 Expenditure");
            System.out.println("\t\t\t4 Exit");

            System.out.print("Please select (1-4): ");
            key = scanner.next();

            // Use switch to control menu actions
            switch (key) {
                case "1":
                    System.out.println("1 Pocket Change Details");
                    System.out.println(details);
                    break;
                case "2":
                    System.out.println("2 Add Income");
                    System.out.print("Enter income amount: ");
                    // Validate input
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input! Please enter a valid number.\nEnter income amount: ");
                        scanner.next(); // Clear invalid input
                    }
                    money = scanner.nextDouble();

                    // Validate the amount
                    if (money <= 0) {
                        System.out.println("The income amount must be greater than 0.");
                        break;
                    }

                    balance += money;
                    // Append income details to the 'details' string
                    date = new Date();
                    details += "\nIncome\t\t + " + money + "\t" + sdf.format(date) + "\tBalance: " + balance;

                    break;
                case "3":
                    System.out.println("3 Expenditure");
                    System.out.print("Enter expenditure amount: ");
                    // Validate input
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input! Please enter a valid number.\nEnter expenditure amount: ");
                        scanner.next(); // Clear invalid input
                    }
                    money = scanner.nextDouble();
                    // Validate the expenditure range
                    if (money <= 0 || money > balance) {
                        System.out.println("Your expenditure amount should be between 0.0 and " + balance);
                        break;
                    }

                    System.out.print("Reason for expenditure: ");
                    scanner.nextLine(); // Clear the buffer to allow correct input handling
                    note = scanner.nextLine();
                    balance -= money;

                    // Append expenditure details to the 'details' string
                    date = new Date();
                    details += "\nExpenditure\t - " + money + "\t" + sdf.format(date) + "\tBalance: " + balance + "\t" + note;

                    break;
                case "4":
                    // When the user selects 4 to exit, prompt "Are you sure you want to exit? y/n".
                    // Input must be either y or n; otherwise, keep looping.
                    // (1) Define a variable 'choice' to store the user's input.
                    // (2) Use while + break to handle the input.
                    // (3) After exiting the while loop, decide based on the user's choice.
                    System.out.println("4 Exit");
                    String choice = "";
                    while (true) {
                        System.out.println("Are you sure you want to exit? y/n");
                        choice = scanner.next();
                        if ("y".equalsIgnoreCase(choice) || "n".equalsIgnoreCase(choice)) {
                            break;
                        }
                    }

                    // Determine the user's choice after exiting the loop
                    if (choice.equalsIgnoreCase("y")) {
                        loop = false;
                    }
                    // If the user chooses 'n', do nothing
                    break;

                default:
                    System.out.println("Invalid selection, please try again.");
            }
        } while (loop);

        System.out.println("You have exited the Pocket Change system. Thank you for using it!");
    }
}
