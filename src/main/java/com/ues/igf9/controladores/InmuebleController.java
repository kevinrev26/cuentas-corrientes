/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf9.controladores;

import com.ues.igf9.modelos.Inmueble;
import com.ues.igf9.modelos.Respuesta;
import com.ues.igf9.negocio.InmuebleService;
import java.util.List;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.PathVariable;
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
public class InmuebleController {
    
    @Inject
    private InmuebleService inmuebleService;
    
    
    @RequestMapping(value="/inmuebles", method=RequestMethod.POST)
    public Respuesta agregarInmueble(@RequestBody Inmueble inm){
        return new Respuesta(inmuebleService.guardarInmueble(inm));
    }
    
    
    @RequestMapping(value="/inmuebles", method=RequestMethod.GET)
    public List<Inmueble> getInmuebles(){
        return inmuebleService.getInmuebles();
    }
    
    @RequestMapping(value = "/inmuebles/{inmuebleId}", method=RequestMethod.GET)
    public Inmueble getInmuebleById(@PathVariable Integer inmuebleId){
        return inmuebleService.getInmuebleById(inmuebleId);
    }
    
}
