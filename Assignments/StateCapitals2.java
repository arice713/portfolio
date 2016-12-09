/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statecapitals2;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class StateCapitals2 {

    public void run() {
        
        Capital capital1 = new Capital("Montgomery",2005764 , 1.554);
        Capital capital2 = new Capital("Juneau", 31275,2716.7);
        Capital capital3 = new Capital("Pheonix", 1445632, 474.9);
        Capital capital4 = new Capital("Little Rock",193524, 116.2);
        Capital capital5 = new Capital("Sacrmento",466488,97.2);
        



        HashMap<String, Capital> statecapitals2 = new HashMap<>();
        
        statecapitals2.put("Alabama", capital1);
        statecapitals2.put("Alaska",capital2);
        statecapitals2.put("Arizona",capital3);
        statecapitals2.put("Arkansas",capital4);
        statecapitals2.put("California",capital5);
    
        Set keySet = statecapitals2.keySet();
        
        for (Capital k : keySet)
        {
            System.out.println("Print State Capitals");
            System.out.println("P");
            System.out.println("");
        
        }
        
        
    }
    
    
}
