import java.util.Scanner;

public class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    // Constructor
    public ATM() {
        this.bankAccount = new BankAccount(1000.0); // Initial balance is set to 1000.0
        this.scanner = new Scanner(System.in);
    }

    // Display ATM options
    private void displayOptions() {
        System.out.println("===== ATM Menu =====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    // Process user input
    public void run() {
        while (true) {
            displayOptions();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Exiting the ATM.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Check account balance
    private void checkBalance() {
        System.out.println("Your account balance is: " + bankAccount.getBalance());
    }

    // Deposit money into the account
    private void deposit() {
        System.out.print("Enter the deposit amount: ");
        double amount = scanner.nextDouble();
        bankAccount.deposit(amount);
    }

    // Withdraw money from the account
    private void withdraw() {
        System.out.print("Enter the withdrawal amount: ");
        double amount = scanner.nextDouble();
        bankAccount.withdraw(amount);
    }

    // Main method to run the ATM
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}
