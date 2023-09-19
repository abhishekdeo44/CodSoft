import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner = new Scanner(System.in);

    public ATM(double initialBalance) {
        account = new BankAccount(initialBalance);
    }

    public void start() {
        System.out.println("Welcome to the ATM!");
        while (true) {
            System.out.println("Options:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 3:
                    double balance = account.checkBalance();
                    System.out.println("Account balance: " + balance);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM(1000.0); // Initial account balance
        atm.start();
    }
}
