import java.util.Scanner;

class BankAccount{
    private double balance;

    public BankAccount(double initalBalance){
        this.balance= initalBalance;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        balance +=amount;
    }
    public boolean withdraw(double amount){
        if(balance>=amount){
            balance -= amount;
            return true;
        }
        return false;
    }
}
class ATM{
    private BankAccount bankAccount;
    public ATM(BankAccount bankAccount){
        this.bankAccount=bankAccount;
    }

    public void displayMenu(){
        System.out.println("Welcome to ATM. \nHow can we help you!");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check balance");
        System.out.println("4. Exit");
    }
    public void withdraw(double amount){
        if(bankAccount.withdraw(amount)){
            System.out.println("Withdraw is successful, \nCurrent Balance Rupees:- " + bankAccount.getBalance());
        }
        else{
            System.out.println("Insufficient Fund. \nWithdraw unsuccessful");
        }

    }

    public void deposit(double amount){
        bankAccount.deposit(amount);
        System.out.println("Deposit successful. \nCurrent Balance Rupees:- "+ bankAccount.getBalance());
    }
    public void checkBalance(double amount){
        System.out.println("Current Balance Rupees:- "+ bankAccount.getBalance());
    }
}

public class Task_3_ATM_Interface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            atm.displayMenu();
            System.out.println("Enter your Choice: ");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter Amount to Withdraw Rupees:-");
                    double withdrawAmount = sc.nextInt();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.println("Enter Amount to Deposit Rupees:-");
                    double depositamount = sc.nextInt();
                    atm.deposit(depositamount);
                    break;
                case 3:
                    atm.checkBalance(userAccount.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting ATM. Thank you for response! ");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again Later.");
            }
        }
        while(choice != 4);
        sc.close();
    }
}