/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf9.persistencia;

import com.ues.igf9.modelos.Cuota;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kevin
 */
public interface CuotaRepositorio extends JpaRepository<Cuota, Integer>{
    
}
