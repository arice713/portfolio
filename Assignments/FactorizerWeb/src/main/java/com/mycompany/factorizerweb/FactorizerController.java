/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.factorizerweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author apprentice
 */
public class FactorizerController {
    
    @WebServlet(name = "ContactServlet", urlPatterns = {"/ContactServlet"})
public class ContactServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ContactDao dao = new ContactDaoMockImpl();
        
        List<Contact> list = dao.getContacts();
        
        request.setAttribute("contactList", list);
        RequestDispatcher rd = request.getRequestDispatcher("displayContacts.jsp");
        rd.forward(request, response);
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

  
    Scanner reader = new Scanner(System.in);
        
        String numberToFactor;
        
        System.out.println("What number would you like to factor");
        numberToFactor= reader.nextLine();
        int number= Integer.parseInt(numberToFactor);
        
        System.out.println("The number you choose was" +number);
       
        int reduceNumber= number;
        ArrayList<Integer> bucket = new ArrayList<Integer>();
        
        
        do {// reduce number goes down by 1.
            //check 5 and compare to 6.
            reduceNumber--;
            int mod =number % reduceNumber; 
            if (mod==0){
             bucket.add(reduceNumber);
             
            }
           
   
        }while(reduceNumber > 1);
        System.out.println("Print total number of factors");
        System.out.println(bucket.size());
        
        System.out.println("Print all of the factors");
        for (int x : bucket){
            System.out.println(x);
            
        }
        
        int perfect= 0;
        for (int x : bucket) {
            System.out.println(x);
            perfect=perfect+x;
            
        }
        if(number == perfect)
        {
            System.out.println("Your number is perfect!");
        }    
        else
        {  
            System.out.println("Your number is not perfect");
        } 
    
        System.out.println("Print if the number prime");
        //1, 3, 5, 7, 11, 13, 17, 19, 23]
        
        if (bucket.size()==1)
        {
            System.out.println("Your number is Prime!");
        }
        else
        {
            System.out.println("Your number is not Prime!");
        }
    }  
}

