/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf9.negocio;

import com.ues.igf9.modelos.Inmueble;
import com.ues.igf9.persistencia.InmuebleRepositorio;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Component;

/**
 *
 * @author kevin
 */
@Component
public class InmuebleService {
    
    
    @Inject
    private InmuebleRepositorio ir;
    
    public String guardarInmueble(Inmueble inm){
        ir.save(inm);       
        return "Inmueble agregado a la base de datos";
    }
    
    public List<Inmueble> getInmuebles(){
        return ir.findAll();
    }
    
    public Inmueble getInmuebleById(Integer id){
        return ir.findOne(id);
    }
}
