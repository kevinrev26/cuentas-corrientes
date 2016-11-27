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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p"),
    @NamedQuery(name = "Pago.findByIdpago", query = "SELECT p FROM Pago p WHERE p.idpago = :idpago"),
    @NamedQuery(name = "Pago.findByAbono", query = "SELECT p FROM Pago p WHERE p.abono = :abono"),
    @NamedQuery(name = "Pago.findByFechapago", query = "SELECT p FROM Pago p WHERE p.fechapago = :fechapago")})
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpago")
    private Integer idpago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "abono")
    private double abono;
    @Column(name = "fechapago")
    @Temporal(TemporalType.DATE)
    private Date fechapago;
    @JoinColumn(name = "numerocontribuyente", referencedColumnName = "numerocontribuyente")
    @ManyToOne(optional = false)
    private Contribuyente numerocontribuyente;
    @JoinColumn(name = "idcuota", referencedColumnName = "idcuota")
    @ManyToOne
    private Cuota idcuota;

    public Pago() {
    }

    public Pago(Integer idpago) {
        this.idpago = idpago;
    }

    public Pago(Integer idpago, double abono) {
        this.idpago = idpago;
        this.abono = abono;
    }

    public Integer getIdpago() {
        return idpago;
    }

    public void setIdpago(Integer idpago) {
        this.idpago = idpago;
    }

    public double getAbono() {
        return abono;
    }

    public void setAbono(double abono) {
        this.abono = abono;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public Contribuyente getNumerocontribuyente() {
        return numerocontribuyente;
    }

    public void setNumerocontribuyente(Contribuyente numerocontribuyente) {
        this.numerocontribuyente = numerocontribuyente;
    }

    public Cuota getIdcuota() {
        return idcuota;
    }

    public void setIdcuota(Cuota idcuota) {
        this.idcuota = idcuota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpago != null ? idpago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.idpago == null && other.idpago != null) || (this.idpago != null && !this.idpago.equals(other.idpago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ues.igf9.modelos.Pago[ idpago=" + idpago + " ]";
    }
    
}
