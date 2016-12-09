/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentquizscores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class StudentquizScores {

   
    public void run() {
        String filename = "file.in";
        
    try {
            FileReader file = new FileReader(filename);
            BufferedReader buff = new BufferedReader(file);
            Scanner reader = new Scanner(buff);
            int count = 0;

            boolean eof = false;
            while (nextLine) {
                String line = buff.readLine();
                if (line == null)
                    break;
                else {
                    System.out.println(line);

                    if (count > 0) {
                        String st = new String(line);
                        for (int i = 0; i < stu.length; i++) {
                            stu[i] = new Student();
                        }
                        stu[count - 1].setSID(Integer.parseInt(()));
                        int scores[] = new int[5];
                        int scoreCount = 0;
                        while (()) {
                            scores[scoreCount] = Integer.parseInt(s());
                            scoreCount++;
                            stu[count - 1].setScores(scores);
                        }
                    }
                }
                count++;
            }
            buff.close();
        } catch (IOException e) {
            System.out.println("Error -- " + e.toString());
        }
        return stu;
    }
}

public class Driver{

    public static void main(String[] args) {
        Student lab4[] = new Student[40];
        Statistics statlab4 = new Statistics();
        statlab4.findlow(lab4);
        statlab4.findhigh(lab4);
        statlab4.findavg(lab4);
        statlab4.printLow();
        statlab4.printHigh();
        statlab4.printAvg();
    }
}
        
    }
}     
    