/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statecapitals;

import java.util.HashMap;


/**
 *
 * @author apprentice
 */
public class StateCapitals { 

   
   
    

    /**
     * @param args the command line arguments
     */
    public void run() {
        
       HashMap<String, String> statecapitals = new HashMap<>();
     
       
       statecapitals.put("Alabama","Montgomery");
       statecapitals.put("Alaska", "Juneua");
       statecapitals.put("Arizona", "FlagStaff");
      
       System.out.println("States listed:" + statecapitals.size());
       
       for (String i : statecapitals.keySet())
       {
           System.out.println(i);
       }
           
               
       
       System.out.println("Alabama:" +statecapitals.get("Alabama"));
    }
    
    
   
    
}
