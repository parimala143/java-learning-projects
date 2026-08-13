import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Expense {

    String description;
    double amount;

    Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    void displayExpense() {
        System.out.println(description + " - Rs. " + amount);
    }
}

public class ExpenseTracker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>();

        while (true) {

            System.out.println("\n===== Expense Tracker =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Calculate Total");
            System.out.println("4. Save Expenses");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter expense description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();

                    expenses.add(new Expense(description, amount));

                    System.out.println("Expense added successfully.");
                    break;

                case 2:

                    if (expenses.isEmpty()) {
                        System.out.println("No expenses available.");
                    } else {

                        System.out.println("\nYour Expenses:");

                        for (Expense expense : expenses) {
                            expense.displayExpense();
                        }
                    }

                    break;

                case 3:

                    double total = 0;

                    for (Expense expense : expenses) {
                        total = total + expense.amount;
                    }

                    System.out.println("Total Expense: Rs. " + total);
                    break;

                case 4:

                    try {

                        FileWriter writer = new FileWriter("expenses.txt");

                        for (Expense expense : expenses) {
                            writer.write(
                                expense.description + " - Rs. "
                                + expense.amount + "\n"
                            );
                        }

                        writer.close();

                        System.out.println("Expenses saved to expenses.txt");

                    } catch (IOException e) {
                        System.out.println("Error while saving expenses.");
                    }

                    break;

                case 5:

                    System.out.println("Thank you for using Expense Tracker.");
                    scanner.close();
                    return;

                default:

                    System.out.println("Invalid choice.");
            }
        }
    }
}
