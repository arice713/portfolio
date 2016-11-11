
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author apprentice
 */
public class BankAccountManager {

    //intialize ArrayList of Account objects
    ArrayList<Account> accountList = new ArrayList();
    private final String BANKACCOUNT_FILE = "bankAccount.txt";
    private final String DELIMITER = "::";

    public ArrayList getAllAccounts() {
        return accountList;
    }

    public void addAccount(Account newAccount) {
        accountList.add(newAccount);
    }
    public void removeAccount(Account account){
        accountList.remove(account);
    }
    public Account getAccount(int targetAccountNumber){
        for(Account account : accountList){
            if(account.getAccountNumber() == targetAccountNumber){
                return account;
            }
        }
        return null;
    }
    public void loadData() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(BANKACCOUNT_FILE)));
        String currentLine;
        String[] currentTokens;
        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            int accountNumber = Integer.parseInt(currentTokens[0]);
            float balance = Float.parseFloat(currentTokens[1]);
            if (currentTokens.length == 3) {
                int numWithdrawalsThisMonth = Integer.parseInt(currentTokens[2]);
                SavingsAccount newSavingsAccount = new SavingsAccount(accountNumber, balance,
                        numWithdrawalsThisMonth);
                addAccount(newSavingsAccount);
            } else {
                Account newAccount = new Account(accountNumber, balance);
                addAccount(newAccount);
            }
        }
    }

    public void saveData() throws IOException {
        //Need to update to include savings account withdrawals
        PrintWriter writer = new PrintWriter(new FileWriter(BANKACCOUNT_FILE));
        for (Account account : accountList) {
            if(account instanceof SavingsAccount){
                SavingsAccount savings = (SavingsAccount) account;
            writer.println(account.getAccountNumber() + DELIMITER
                    + account.getBalance() + DELIMITER
                    + savings.getNumWithdrawalsThisMonth());
            }else{
                writer.println(account.getAccountNumber() + DELIMITER
                    + account.getBalance());
            }
            writer.flush();
        }
        writer.close();
    }
}
