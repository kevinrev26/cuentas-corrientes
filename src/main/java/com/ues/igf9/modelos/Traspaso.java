/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf9.modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "traspaso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Traspaso.findAll", query = "SELECT t FROM Traspaso t"),
    @NamedQuery(name = "Traspaso.findByIdtraspaso", query = "SELECT t FROM Traspaso t WHERE t.idtraspaso = :idtraspaso"),
    @NamedQuery(name = "Traspaso.findByFechatraspaso", query = "SELECT t FROM Traspaso t WHERE t.fechatraspaso = :fechatraspaso")})
public class Traspaso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idtraspaso")
    private String idtraspaso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechatraspaso")
    @Temporal(TemporalType.DATE)
    private Date fechatraspaso;
    @JoinColumn(name = "numerocontribuyente", referencedColumnName = "numerocontribuyente")
    @ManyToOne(optional = false)
    private Contribuyente numerocontribuyente;
    @JoinColumn(name = "clavecatastral", referencedColumnName = "clavecatastral")
    @ManyToOne(optional = false)
    private Inmueble clavecatastral;

    public Traspaso() {
    }

    public Traspaso(String idtraspaso) {
        this.idtraspaso = idtraspaso;
    }

    public Traspaso(String idtraspaso, Date fechatraspaso) {
        this.idtraspaso = idtraspaso;
        this.fechatraspaso = fechatraspaso;
    }

    public String getIdtraspaso() {
        return idtraspaso;
    }

    public void setIdtraspaso(String idtraspaso) {
        this.idtraspaso = idtraspaso;
    }

    public Date getFechatraspaso() {
        return fechatraspaso;
    }

    public void setFechatraspaso(Date fechatraspaso) {
        this.fechatraspaso = fechatraspaso;
    }

    public Contribuyente getNumerocontribuyente() {
        return numerocontribuyente;
    }

    public void setNumerocontribuyente(Contribuyente numerocontribuyente) {
        this.numerocontribuyente = numerocontribuyente;
    }

    public Inmueble getClavecatastral() {
        return clavecatastral;
    }

    public void setClavecatastral(Inmueble clavecatastral) {
        this.clavecatastral = clavecatastral;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtraspaso != null ? idtraspaso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Traspaso)) {
            return false;
        }
        Traspaso other = (Traspaso) object;
        if ((this.idtraspaso == null && other.idtraspaso != null) || (this.idtraspaso != null && !this.idtraspaso.equals(other.idtraspaso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ues.igf9.modelos.Traspaso[ idtraspaso=" + idtraspaso + " ]";
    }
    
}
