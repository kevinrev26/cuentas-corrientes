/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf9.negocio;

import com.ues.igf9.modelos.CuentaCorriente;
import com.ues.igf9.persistencia.CuentaCorrienteRepositorio;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Component;

/**
 *
 * @author kevin
 */
@Component
public class CuentasCorrientesService {
    
    @Inject
    CuentaCorrienteRepositorio ccr;
     
    
    public List<CuentaCorriente> getCuentasCorrientes(){
        return ccr.findAll();
    }
    
    public CuentaCorriente getCuentaCorrienteById(Integer id){
        return ccr.findOne(id);
    }
    
}
