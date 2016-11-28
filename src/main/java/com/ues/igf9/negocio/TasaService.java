/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf9.negocio;

import com.ues.igf9.modelos.Tasa;
import com.ues.igf9.persistencia.TasaRepositorio;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Component;

/**
 *
 * @author kevin
 */

@Component
public class TasaService {
    
    @Inject
    private TasaRepositorio tr;
    
    
    public String agregarTasa(Tasa t){
        tr.save(t);
        return "Tasa agregada con exito";
    }
    
    public List<Tasa> getTasas(){
        return tr.findAll();
    }
}
