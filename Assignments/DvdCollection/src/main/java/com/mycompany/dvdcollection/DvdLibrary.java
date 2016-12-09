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
public class DvdLibrary {
}

    public void writeMovie()throw IOException{
PrintWriter out = new PrintWriter(new FileWirter(DVD_FILE));

String[] keys = this.getAllMovies();

    for (int i = 0; i <keys.length; i++){
    Movie currentMovie = this.getMovie(keys[i]);
 System.out.println
}


    Set<String> keySet = movies.keySet();
    String[] keyArray = new String[key.size()];
    keyArray = keySet.toArray(keyArray);
    return KeyArray;
    
}