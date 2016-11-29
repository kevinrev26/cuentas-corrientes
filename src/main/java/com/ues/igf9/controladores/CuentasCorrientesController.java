/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf9.controladores;

import com.ues.igf9.modelos.CuentaCorriente;
import com.ues.igf9.negocio.CuentasCorrientesService;
import java.util.List;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kevin
 */
@RestController
@RequestMapping("/api/")
public class CuentasCorrientesController {
    
    @Inject
    private CuentasCorrientesService cuentasCorrientesService;
    
    @RequestMapping(value="/cuentas-corrientes", method=RequestMethod.GET)
    public List<CuentaCorriente> getCuentas(){
        return cuentasCorrientesService.getCuentasCorrientes();
    }
    
    
}
