/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentquizscores;

/**
 *
 * @author apprentice
 */
public class App {
    
    public static void main(String [] args)
    {
        StudentquizScores studentquiz = new StudentquizScores();
        studentquiz.run();
    }
    private int SID;
    private int scores[] = new int[5];

    public int getSID() {
        return SID;
    }

    public void setSID(int sID) {
        SID = sID;
    }

    public int getScores(int index) {
        return scores[index];
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public void printSID() {
        System.out.println(SID);
    }

    public void printScores() {
        for (int x : scores) {
            System.out.println(x);
        }
    }
}

class Statistics {

    private final int[] lowscores = new int[5];
    private final int[] highscores = new int[5];
    private final float[] avgscores = new float[5];

    public void findlow(Student[] a) {
        for (Student stu : a) {
            for (int i = 0; i < 5; i++) {
                lowscores[i] = Math.min(lowscores[i], stu.getScores(i));
            }
        }
    }

    public void findhigh(Student[] a) {
        for (Student stu : a) {
            for (int i = 0; i < 5; i++) {
                highscores[i] = Math.max(highscores[i], stu.getScores(i));
            }
        }
    }

    public void findavg(Student[] a) {
        int[] sum = new int[5];
        for (Student stu : a) {
            for (int i = 0; i < 5; i++) {
                sum[i] += stu.getScores(i);
                avgscores[i] = sum[i] / a.length;
            }
        }
    }

    public void printLow() {
        for (int x : lowscores) {
            System.out.println("Low Score  " + x);
        }
    }

    public void printHigh() {
        for (int x : highscores) {
            System.out.println("High Score  " + x);
        }
    }

    public void printAvg() {
        for (float x : avgscores) {
            System.out.println("Average  " + x);
        }
    }
}

    
    
    
    
    
    
    
    
    

