/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf9.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author kevin
 */
@Controller
public class HomeController {
    
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home(){
        return "index";
    }
    
    @RequestMapping(value="/prueba")
    public String prueba(){
        return "test";
    }
}
