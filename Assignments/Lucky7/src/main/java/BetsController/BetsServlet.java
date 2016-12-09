/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BetsController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author apprentice
 */
@WebServlet(name = "BetsServlet", urlPatterns = {"/BetsServlet"})
public class BetsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            Scanner reader= new Scanner(System.in);
        
        System.out.println("How many dollars do you have?");
        String startingBet= reader.nextLine();
        int bet=Integer.parseInt(startingBet);
        int mostMoney=bet;
        int numberOfRolls=0;
        int highestRolls=0;
        Random number = new Random();
        do
        {
            int dice1=number.nextInt(6)+1;
            int dice2=number.nextInt(6)+1;
            numberOfRolls++;
        if ((dice1+dice2)==7)    
        {
            bet=bet+4;
            System.out.println("You win!!");
        }
        else
        {
            bet--;
        }  
        if( bet>mostMoney )
         {
           mostMoney=bet;
           highestRolls=numberOfRolls;
                    
         }
            
        } while(bet>=0);
        
        
        System.out.println("You're broke after"+numberOfRolls);
        System.out.println("You should have quit after"+highestRolls +"When you had"+mostMoney);
    
        
        
        request.setAttribute("Bets", bet);
        RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
        
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             processRequest(request, response);
        }
        
    
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

        
    
}