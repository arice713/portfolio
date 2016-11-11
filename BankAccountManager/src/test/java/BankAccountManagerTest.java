/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class BankAccountManagerTest {
    BankAccountManager manager = new BankAccountManager();
    ArrayList<Account> accountList = new ArrayList();
    
    @Test
    public void BankAccountManagerGetAccountTest() {
        //Arrange
        try{
        manager.loadData();
        }catch(FileNotFoundException fnf){
            
        }
        //Act
        Account expectedAccount = new Account(37865,10266.0);
        Account actualAccount = manager.getAccount(37865);
        
        //Assert
        assertEquals(expectedAccount.getAccountNumber(),
                actualAccount.getAccountNumber());
    }
    @Test
    public void BankAccountManagerAddAccount(){
        //Before, accountList is empty
        
        //Act
        Account newAccount = new Account(1234,1000);   
        accountList.add(newAccount);
        //Assert
        assertEquals(1,accountList.size());
        
        //Act
        accountList.remove(newAccount);
        assertEquals(0,accountList.size());
    }
}
