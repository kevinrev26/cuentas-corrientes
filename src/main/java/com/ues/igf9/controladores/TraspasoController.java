/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf9.controladores;

import com.ues.igf9.modelos.Respuesta;
import com.ues.igf9.modelos.Traspaso;
import com.ues.igf9.negocio.TraspasoService;
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
public class TraspasoController {
    
    @Inject
    private TraspasoService traspasoService;
    
    
    @RequestMapping(value="/traspasos", method=RequestMethod.POST)
    public Respuesta agregarTraspaso(@RequestBody Traspaso t){
        return new Respuesta(traspasoService.tramitarTraspaso(t));
    }
    
}
