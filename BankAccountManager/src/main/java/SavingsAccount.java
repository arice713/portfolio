/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class SavingsAccount extends Account{
    private int numWithdrawalsThisMonth;
    private final int MAXIMUMWITHDRAWALS = 10;
    
    public SavingsAccount(){
        
    }
    
    public SavingsAccount( int accountNumber, float balance, int numWithdrawalsThisMonth){
        this.setAccountNumber(accountNumber);
        this.numWithdrawalsThisMonth = numWithdrawalsThisMonth;
        this.setBalance(balance);
    } 

    /**
     * @return the numWithdrawalsThisMonth
     */
    public int getNumWithdrawalsThisMonth() {
        return numWithdrawalsThisMonth;
    }

    /**
     * @param numWithdrawalsThisMonth the numWithdrawalsThisMonth to set
     */
    public void setNumWithdrawalsThisMonth(int numWithdrawalsThisMonth) {
        this.numWithdrawalsThisMonth = numWithdrawalsThisMonth;
    }

    /**
     * @return the MAXNUMWITHDRAWALS
     */
    public int getMAXNUMWITHDRAWALS() {
        return MAXIMUMWITHDRAWALS;
    }
}