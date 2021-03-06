/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf9.controladores;

import com.ues.igf9.modelos.Respuesta;
import com.ues.igf9.modelos.Tasa;
import com.ues.igf9.negocio.TasaService;
import java.util.List;
import javax.inject.Inject;
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
public class TasaController {
    
    @Inject
    TasaService tasaService;
    
    @RequestMapping(value="/tasas", method=RequestMethod.POST)
    public Respuesta agregarContribuyente(@RequestBody Tasa t){        
        return new Respuesta(tasaService.agregarTasa(t));        
    }
    
    @RequestMapping(value="/tasas", method=RequestMethod.GET)
    public List<Tasa> getTasas(){
        return tasaService.getTasas();
    }
    
    
}
