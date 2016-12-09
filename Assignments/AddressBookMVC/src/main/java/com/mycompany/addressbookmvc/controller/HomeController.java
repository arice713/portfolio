/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbookmvc.controller;

import dao.AddressBookDAO;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import models.Person;

/**
 *
 * @author apprentice
 */
@Controller
public class HomeController {
    private AddressBookDAO dao;
    
    @Inject
    public HomeController(AddressBookDAO dao){
        this.dao = dao
    }
    
    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String displayHomePage(){
        return "home";
    }
    
    @RequestMapping(value = "/person/{id}", method = RequestMethod.Get)
    @ResponseBody
    public Person getPerson(@PathVarible("id") int id){
        return dao.getPersonById(id);
    }
    
    @RequestMapping(Value = "/person", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Person createPerson(@Valid @RequestBody Person person, HttpServletResponse response){
       
        if (!Person.getLastName().equals(".")){
            dao.addPerson(person);
        }else{
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return person;
    }
    
    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    
    public void deletePerson(@PathVarible("id")int id){
        dao.removePerson(id);
    }
    
    @RequestMapping(value ="/persons", method= RequestMethod.GET)
    @ResponseBody public List<Person> getAllPersons(){
        return dao.getAllPersons();
    }
    
    }

