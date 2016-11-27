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
@Table(name = "cuenta_corriente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentaCorriente.findAll", query = "SELECT c FROM CuentaCorriente c"),
    @NamedQuery(name = "CuentaCorriente.findByIdcuentacorriente", query = "SELECT c FROM CuentaCorriente c WHERE c.idcuentacorriente = :idcuentacorriente"),
    @NamedQuery(name = "CuentaCorriente.findByFechaultimopago", query = "SELECT c FROM CuentaCorriente c WHERE c.fechaultimopago = :fechaultimopago"),
    @NamedQuery(name = "CuentaCorriente.findByInteres", query = "SELECT c FROM CuentaCorriente c WHERE c.interes = :interes"),
    @NamedQuery(name = "CuentaCorriente.findByTasamensual", query = "SELECT c FROM CuentaCorriente c WHERE c.tasamensual = :tasamensual"),
    @NamedQuery(name = "CuentaCorriente.findBySaldoacumulado", query = "SELECT c FROM CuentaCorriente c WHERE c.saldoacumulado = :saldoacumulado")})
public class CuentaCorriente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcuentacorriente")
    private Integer idcuentacorriente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaultimopago")
    @Temporal(TemporalType.DATE)
    private Date fechaultimopago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "interes")
    private double interes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tasamensual")
    private double tasamensual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldoacumulado")
    private double saldoacumulado;
    @JoinColumn(name = "numerocontribuyente", referencedColumnName = "numerocontribuyente")
    @ManyToOne(optional = false)
    private Contribuyente numerocontribuyente;

    public CuentaCorriente() {
    }

    public CuentaCorriente(Integer idcuentacorriente) {
        this.idcuentacorriente = idcuentacorriente;
    }

    public CuentaCorriente(Integer idcuentacorriente, Date fechaultimopago, double interes, double tasamensual, double saldoacumulado) {
        this.idcuentacorriente = idcuentacorriente;
        this.fechaultimopago = fechaultimopago;
        this.interes = interes;
        this.tasamensual = tasamensual;
        this.saldoacumulado = saldoacumulado;
    }

    public Integer getIdcuentacorriente() {
        return idcuentacorriente;
    }

    public void setIdcuentacorriente(Integer idcuentacorriente) {
        this.idcuentacorriente = idcuentacorriente;
    }

    public Date getFechaultimopago() {
        return fechaultimopago;
    }

    public void setFechaultimopago(Date fechaultimopago) {
        this.fechaultimopago = fechaultimopago;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getTasamensual() {
        return tasamensual;
    }

    public void setTasamensual(double tasamensual) {
        this.tasamensual = tasamensual;
    }

    public double getSaldoacumulado() {
        return saldoacumulado;
    }

    public void setSaldoacumulado(double saldoacumulado) {
        this.saldoacumulado = saldoacumulado;
    }

    public Contribuyente getNumerocontribuyente() {
        return numerocontribuyente;
    }

    public void setNumerocontribuyente(Contribuyente numerocontribuyente) {
        this.numerocontribuyente = numerocontribuyente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuentacorriente != null ? idcuentacorriente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaCorriente)) {
            return false;
        }
        CuentaCorriente other = (CuentaCorriente) object;
        if ((this.idcuentacorriente == null && other.idcuentacorriente != null) || (this.idcuentacorriente != null && !this.idcuentacorriente.equals(other.idcuentacorriente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ues.igf9.modelos.CuentaCorriente[ idcuentacorriente=" + idcuentacorriente + " ]";
    }
    
}
