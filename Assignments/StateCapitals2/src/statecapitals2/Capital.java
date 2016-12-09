/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statecapitals2;

import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public class Capital {
    public static void main(String[] args) {
        StateCapitals2 statecap2 = new StateCapitals2();
        statecap2.run();
    }
    
    String name;
    int population;
    double squareMi;
    
    public Capital(String newname, int newpopulation, double newsquaremi)
    {
        name = newname;
        population = newpopulation;
        squareMi = newsquaremi;
    }
    
   
}
