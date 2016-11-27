/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf9.negocio;

import com.ues.igf9.modelos.Contribuyente;
import com.ues.igf9.persistencia.ContribuyenteRepositorio;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Component;

/**
 *
 * @author kevin
 */
@Component
public class ContribuyenteService {
    
   @Inject
   private ContribuyenteRepositorio cr;
    
    
    public String agregarContribuyente(Contribuyente cb){
        
       cr.save(cb);       
       return "Contribuyente agregado a la cartera";
    }
    
    
    public List<Contribuyente> getContribuyentes(){
        return cr.findAll();
    }
    
}
