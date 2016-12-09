/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdcollection;

/**
 *
 * @author apprentice
 */
public class DVDController {
    private DvdLibrary library = new DvdLibrary();
    private ConsoleIO con = new ConsoleIO();
    
    
    public void run() {
        boolean keepGoing = true;
        int dvdSelection = 0;
        try{
           movie.loadMovie();
           while (keepGoing){
               printDvd();
               dvdSelection = con.readInt("Please select from the following choices")
           }
        }
    
    
    
    
    }
    
}
