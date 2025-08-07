import java.util.Scanner;

// 1. Bank Account Class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // 3. Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposited: $" + amount);
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    // 3. Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("✅ Withdrawn: $" + amount);
        }
    }

    // 3. Check balance
    public void checkBalance() {
        System.out.printf("💰 Current Balance: $%.2f%n", balance);
    }
}

// 1. ATM Class
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // 2. Show Menu
    public void showMenu() {
        int choice;
        do {
            System.out.println("\n========= ATM MENU =========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    handleWithdraw();
                    break;
                case 4:
                    System.out.println("👋 Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }

        } while (choice != 4);
    }

    // 3. Handle deposit
    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    // 3. Handle withdrawal
    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
}

// 4. Main class to run the program
public class AtmInterface {
    public static void main(String[] args) {
        // 4. Create a bank account with initial balance
        BankAccount myAccount = new BankAccount(500.00);

        // 5. Connect to ATM
        ATM atm = new ATM(myAccount);

        // 2. Start ATM menu
        atm.showMenu();
    }
}
