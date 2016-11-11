/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Account {
    
    private int accountNumber;
    private double balance;
    private boolean holdOnAccount = false;
    private boolean wasWorkedWithToday = false;
    public Account(){
        
    }
    public Account(int accountNumber, double balance){
        this.balance = balance;
        this.accountNumber = accountNumber;
    }
    
    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @return the holdOnAccount
     */
    public boolean isHoldOnAccount() {
        return holdOnAccount;
    }

    /**
     * @param holdOnAccount the holdOnAccount to set
     */
    public void setHoldOnAccount(boolean holdOnAccount) {
        this.holdOnAccount = holdOnAccount;
    }

    /**
     * @return the accountNumber
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return the wasWorkedWithToday
     */
    public boolean isWasWorkedWithToday() {
        return wasWorkedWithToday;
    }

    /**
     * @param wasWorkedWithToday the wasWorkedWithToday to set
     */
    public void setWasWorkedWithToday(boolean wasWorkedWithToday) {
        this.wasWorkedWithToday = wasWorkedWithToday;
    }
    
    
}
