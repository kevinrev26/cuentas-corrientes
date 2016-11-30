/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf9.negocio;

import com.ues.igf9.modelos.Contribuyente;
import com.ues.igf9.modelos.CuentaCorriente;
import com.ues.igf9.modelos.Inmueble;
import com.ues.igf9.modelos.Tasa;
import com.ues.igf9.modelos.Traspaso;
import com.ues.igf9.persistencia.CuentaCorrienteRepositorio;
import com.ues.igf9.persistencia.InmuebleRepositorio;
import com.ues.igf9.persistencia.TraspasoRepositorio;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Component;

/**
 *
 * @author kevin
 */
@Component
public class TraspasoService {
    
    @Inject
    TraspasoRepositorio tsr;
    @Inject
    CuentaCorrienteRepositorio ccr;
    @Inject
    InmuebleRepositorio inr;
    
    
    public String tramitarTraspaso(Traspaso t){
        
        String mensaje = "";
        tsr.save(t);
        mensaje = mensaje + "Traspaso: " + t.getIdtraspaso();
        
        Inmueble i = inr.findOne(t.getClavecatastral().getClavecatastral());
        CuentaCorriente cc = ccr.findBynumerocontribuyente(t.getNumerocontribuyente());        
        Contribuyente propietarioAnterior = i.getPropietario();
        if(cc == null){
            cc = new CuentaCorriente();
            cc.setInteres(0);
            cc.setSaldoacumulado(calculoTasaMensual(i));
            cc.setTasamensual(calculoTasaMensual(i));
            cc.setFechaultimopago(t.getFechatraspaso());
            cc.setNumerocontribuyente(t.getNumerocontribuyente());
            ccr.save(cc);
            if(propietarioAnterior != null){
                CuentaCorriente cuentaPropietarioAnterior = ccr.findBynumerocontribuyente(propietarioAnterior);
                quitarTasas(cuentaPropietarioAnterior , i);
            }
            mensaje = mensaje + " Cuenta corriente generada para el contribuyente: " + t.getNumerocontribuyente().getNumerocontribuyente();
        } else {
            
            Double nuevatasa = cc.getTasamensual() + calculoTasaMensual(i);
            cc.setTasamensual(nuevatasa);
            ccr.save(cc);
            
            CuentaCorriente cuentaPropietarioAnterior = ccr.findBynumerocontribuyente(propietarioAnterior);
            quitarTasas(cuentaPropietarioAnterior , i);
            mensaje = mensaje + " Actualizado el nuevo importe mensual para la cuenta: " + cc.getIdcuentacorriente();
        }        
                
        i.setPropietario(t.getNumerocontribuyente());
        inr.save(i);
        return mensaje;
    }
    
    private Double calculoTasaMensual(Inmueble inm){
        Double acu = 0.0;
        for(Tasa t : inm.getTasaList()){
            //acu = acu + t.getValor();
            if(t.getCodigo()>=111 && t.getCodigo() <= 143){
                acu = acu + t.getValor()*inm.getAreasuperficial();
            } else if (t.getCodigo()>=211 && t.getCodigo() <= 222){
                acu = acu + t.getValor()*inm.getAreasuperficial();
            } else  if(t.getCodigo()>= 311 && t.getCodigo()<=354) {
                acu = acu + t.getValor()*inm.getMetroslineales();
            } else {
                acu = acu + t.getValor();
            }
            
        }
        
        return acu;
    } 
    
    private void quitarTasas(CuentaCorriente cuenta , Inmueble inm){
            //Double tasaActual = 0.0;
            //CuentaCorriente cuenta = ccr.findBynumerocontribuyente(c);
            Double tasaActual = cuenta.getTasamensual() - calculoTasaMensual(inm);
            cuenta.setTasamensual(tasaActual);
            ccr.save(cuenta);
    }
    
    
    
    
}
