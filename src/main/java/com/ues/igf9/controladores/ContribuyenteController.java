/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf9.controladores;

import com.ues.igf9.modelos.Contribuyente;
import com.ues.igf9.modelos.Respuesta;
import com.ues.igf9.negocio.ContribuyenteService;
import com.ues.igf9.persistencia.ContribuyenteRepositorio;
import java.util.List;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kevin
 */
@RestController
@RequestMapping("/api")
public class ContribuyenteController {
    
    @Inject
    private ContribuyenteService contribuyenteService;
    
    
    
    @RequestMapping(value="/contribuyentes", method=RequestMethod.POST)
    public Respuesta agregarContribuyente(@RequestBody Contribuyente cont){
        
        return new Respuesta(contribuyenteService.agregarContribuyente(cont));        
    }
    
    @RequestMapping(value="/contribuyentes", method=RequestMethod.GET)
    public List<Contribuyente> getContribuyentes(){
        return contribuyenteService.getContribuyentes();
    }
    
}
