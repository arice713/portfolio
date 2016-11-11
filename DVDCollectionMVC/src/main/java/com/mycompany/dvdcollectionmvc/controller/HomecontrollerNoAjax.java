/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdcollectionmvc.controller;

import com.mycompany.dvdcollectionmvc.DAO.DvdCollectionDAO;
import com.mycompany.dvdcollectionmvc.model.Dvd;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class HomecontrollerNoAjax {
    
     private  DvdCollectionDAO dao;
    
    @Inject
    public HomecontrollerNoAjax(DvdCollectionDAO dao){
        this.dao = dao;
    }
    
    @RequestMapping(value="displayNewDvdCollectionNoAjax", method=RequestMethod.GET)
    public String displayNewDvdCollectionNoAjax(){
        return "newDvdCollectionNoAjax";
    }
    
    @RequestMapping(value="/addNewDvdNoAjax",method=RequestMethod.POST)
    public String addNewDvdNoAjax(HttpServletRequest req){
        String title = req.getParameter("title");
         String releaseDate  = req.getParameter("releaseDate");
        String rating = req.getParameter("rating");
        String director = req.getParameter("director");
        String studio = req.getParameter("studio");
        String userRating = req.getParameter("userRating");
        Dvd dvdToAdd = new Dvd();
        dvdToAdd.setTitle(title);
        dvdToAdd.setReleaseDate(releaseDate);
        dvdToAdd.setRating(rating);
        dvdToAdd.setDirector(director);
        dvdToAdd.setStudio(studio);
        dvdToAdd.setUserRating(userRating);
        dao.addDvd(dvdToAdd);
        return "redirect:displayDvdCollectionNoAjax";
    }
    
    
    @RequestMapping(value="/displayEditDvdCollectionNoAjax", method=RequestMethod.GET)
    public String displayEditDvdCollectionNoAjax(HttpServletRequest req, Model model){
        int dvdId = Integer.parseInt(req.getParameter("dvdId"));
        
        
        Dvd dvdToEdit = dao.getDvdById(dvdId);
        
        
        model.addAttribute("Dvd", dvdToEdit);
        return "editDvdCollectionNoAjax";
        
    }
    
    @RequestMapping(value="/editDvdNoAjax", method=RequestMethod.POST)
    public String editDvdNoAjax(@ModelAttribute("dvd") Dvd dvd){
        
        dao.updateDvd(dvd);
        
        return "redirect:displayDvdCollectionNoAjax";
    }
    
    
    @RequestMapping(value="/deleteDvdNoAjax",method=RequestMethod.GET)
    public String deleteDvdNoAjax(HttpServletRequest req){
        
        int dvdId = Integer.parseInt(req.getParameter("dvdId"));
        dao.removeDvd(dvdId);
        return "redirect:displayDvdcollectionNoAjax";
    }
    
    
    @RequestMapping(value="/displayDvdCollectionNoAjax", method=RequestMethod.GET)
    public String displayDvdCollectionNoAjax(Model model){
        
        List<Dvd> allDvds = dao.getAllDvds();
        model.addAttribute("Dvd Collection",allDvds);
        return "displayDvdCollectionsNoAjax";
    }
}
