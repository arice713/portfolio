
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author apprentice
 */
public class BankAccountController {

    BankAccountManager manager = new BankAccountManager();
    ConsoleIO con = new ConsoleIO();

    public void run() {
        //load data
        try {
            manager.loadData();
        } catch (FileNotFoundException fnf) {
            con.print("Unable to load from file");
        }

        //prompt user for a PIN
        int PIN = promptForPIN();
        boolean workingWithAnyAccount = true;
        //loop while workingWithAccount
        while (workingWithAnyAccount) {
            //prompt for which account to use
            displayAllAccounts();
            int currentAccountNumber = promptForWhichAccount();
            Account currentAccount = manager.getAccount(currentAccountNumber);

            boolean stillWorkingWithThisAccount = true;
            while (stillWorkingWithThisAccount) {
                //prompt to make deposit or withdrawal
                int transactionType = promptForTransactionType();
                switch (transactionType) {

                    //if deposit
                    //make deposit
                    //prompt for how much
                    case 1:
                        float amountToAdd = promptForAmount();
                        deposit(currentAccount, amountToAdd);
                        currentAccount.setWasWorkedWithToday(true);
                        break;
                    case 2:
                        float amountToSubtract = promptForAmount();
                        withdraw(currentAccount, amountToSubtract);
                        currentAccount.setWasWorkedWithToday(true);
                        break;
                    default:
                        //print balance
                        printBalance(currentAccount);
                        break;
                }
                //ask if user wants to make another transaction with the same account
                stillWorkingWithThisAccount = promptForAnotherTransaction();

            }
            //prompt to work with another account or quit (Y/N)
            workingWithAnyAccount = promptToWorkWithAnotherAccount();
        }
        //print receipt with balance
        printReceipt();
        //save data
        try {
            manager.saveData();
        } catch (IOException ioe) {
            con.print("Unable to save to file");
        }
    }

    public int promptForPIN() {
        int PIN = con.promptForInt("Please enter your PIN:");
        while (PIN != 1234) {
            //validate PIN - check if it matches one particular PIN(1234)
            //if invalid, print please enter another PIN
            PIN = con.promptForInt("Invalid, please enter another PIN.");
        }
        return PIN;
    }

    public void displayAllAccounts() {
        ArrayList<Account> accountList = manager.getAllAccounts();
        for (Account account : accountList) {
            con.print("Account Number: " + account.getAccountNumber());
            if (account instanceof SavingsAccount) {
                con.print("Account Type: Savings");
            } else {
                con.print("Account Type: Checking");
            }
        }
    }

    public int promptForWhichAccount() {
        int choice = con.promptForInt("Which account would you like to access? Please enter the account number");
        boolean valid = false;
        ArrayList<Account> accountList = manager.getAllAccounts();
        for (Account account : accountList) {
            if (account.getAccountNumber() == choice) {
                valid = true;
            }
        }
        while (!valid) {
            choice = con.promptForInt("Please enter a valid account number:");
            for (Account account : accountList) {
                if (account.getAccountNumber() == choice) {
                    valid = true;
                }
            }
        }
        return choice;
    }

    public int promptForTransactionType() {
        int transactionType = con.promptForInt("Please enter one of the following commands:"
                + "\n1. Deposit"
                + "\n2. Make a withdrawal"
                + "\n3. View Balance");
        while (transactionType != 1 && transactionType != 2 && transactionType != 3) {
            transactionType = con.promptForInt("Please enter a valid command");
        }
        return transactionType;
    }

    public boolean promptForAnotherTransaction() {
        boolean keepGoing = false;
        String response = con.promptForString("Would you like to make another transaction in this account? Y/N").toLowerCase();
        while (!response.equals("y") && !response.equals("n")) {
            response = con.promptForString("Please enter Y/N:");
        }
        if (response.equals("y")) {
            keepGoing = true;
        }
        return keepGoing;
    }

    //prompt for deposit, withdrawal, or view balance
    //validate for proper command
    public float promptForAmount() {
        float amount = con.promptForFloat("How much did you want to deposit or withdraw?");
        while (amount <= 0) {
            amount = con.promptForFloat("Please enter a valid amount...");
        }
        return amount;
    }

    public void printBalance(Account currentAccount) {
        con.print("Current balance: $" + currentAccount.getBalance());
    }

    public void printReceipt() {
        //get list of accounts
        ArrayList<Account> accountList = manager.getAllAccounts();
        con.print("---------Receipt----------");
        for (Account account : accountList) {
            //if account wasWorkedWith, print balance  
            if (account.isWasWorkedWithToday()) {
                con.print("Account number: " + account.getAccountNumber());
                con.print("Current Balance:" + account.getBalance());
                con.print("");
            }
        }
        con.print("------------------------");

    }

    public void deposit(Account currentAccount, float amountToAdd) {
        manager.removeAccount(currentAccount);
        currentAccount.setBalance(currentAccount.getBalance() + amountToAdd);
        if (amountToAdd >= 10000) {
            currentAccount.setHoldOnAccount(true);
        }
        manager.addAccount(currentAccount);
        printBalance(currentAccount);
    }

    public void withdraw(Account currentAccount, double amountToSubtract) {
        double currentBalance = currentAccount.getBalance();
        //check if there's a hold on the account
        if (!currentAccount.isHoldOnAccount()) {
            //if it's a savings account
            if (currentAccount instanceof SavingsAccount) {
                SavingsAccount savings = (SavingsAccount) currentAccount;

                //check if the withdrawal limit limit has been reached
                if (savings.getNumWithdrawalsThisMonth() >= savings.getMAXNUMWITHDRAWALS()) {
                    con.print("You have reached the maximum amount of withdrawals for the month.");
                } else {
                    currentAccount.setBalance(currentBalance - amountToSubtract);
                    savings.setNumWithdrawalsThisMonth(savings.getNumWithdrawalsThisMonth() + 1);
                }
            } else { //if it's a checking account
                currentAccount.setBalance(currentBalance - amountToSubtract);
            }
            if ((currentBalance - amountToSubtract) < 0) {
                con.print("Your account has been overdrawn. A fee of $10.00 will be applied.");
                currentAccount.setHoldOnAccount(true);
                        
                currentAccount.setBalance(currentAccount.getBalance() - 10);
            }
            printBalance(currentAccount);
        }else{
              con.print("Unable to process transaction. There is currently a hold on your account.");
        }
    }

    private boolean promptToWorkWithAnotherAccount() {
        boolean keepGoing = false;
        String response = con.promptForString("Do you want to manage a different account? Please enter Y/N:").toLowerCase();
        while (!response.equals("y") && !response.equals("n")) {
            response = con.promptForString("Please enter y/n:");
        }
        if (response.equals("y")) {
            keepGoing = true;
        }
        return keepGoing;
    }
}
