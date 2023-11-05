import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class AtmMachine {
    private BankAccount userAccount;

    public AtmMachine(BankAccount account) {
        userAccount = account;
    }

    public void displayOptions() {
        System.out.println(" Welcome!!! What would you like to do ??");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }


    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            displayOptions();
            System.out.print("Select an option (1/2/3/4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (userAccount.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful. Your new balance is " + userAccount.getBalance()+" Rs");
                    } else {
                        System.out.println("Withdrawal failed. Insufficient balance in your account");
                    }
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    if (userAccount.deposit(depositAmount)) {
                        System.out.println("Deposit successful. Your new balance is " + userAccount.getBalance()+" Rs");
                    } else {
                        System.out.println("Deposit failed. Invalid deposit amount.");
                    }
                    break;
                case 3:
                    System.out.println("Your current balance is " + userAccount.getBalance()+" Rs");
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
        scanner.close();
    }
}

public class Main {
    public static void main(String[] args) {
        double initialBalance = 1000.0; // You can set the initial balance here.
        BankAccount userAccount = new BankAccount(initialBalance);
        AtmMachine atm = new AtmMachine(userAccount);
        atm.run();
    }
}
