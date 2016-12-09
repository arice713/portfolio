/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbookmvc.controller;

import java.text.MessageFormat;
import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author apprentice
 */
@Controller
public class ErrorController {
    @RequestMapping(value="/error)
public String customError(HttpServletRequest request, HttpServletResponse response, Model model){
    
    Integer statusCode + (Integer) request.getAttribute("javax.servlet.error.status_code");
    HttpStatus httpstatus = HttpStatus.valueOf(statusCode);
    
    Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
    String exceptionMessage = null;
    exceptionMessage = httpStatus.getReasonPhrase();
    
    String requestUri = (String) request.getAttribute("javax.servlet.error.request.uri");
    if (requestUri == null){
        requestUri = "Unknown";
    }
    
    String message = MessageFormat.format("{0} returned for {1} : {2}", statuscode, requestUri, exceptionMessage);
    
    model.addAttribute("errorMessage", Message);
    return "customError";
}
}
