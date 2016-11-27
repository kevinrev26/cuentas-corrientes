/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf9.modelos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "plan_de_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanDePago.findAll", query = "SELECT p FROM PlanDePago p"),
    @NamedQuery(name = "PlanDePago.findByIdentificadorplan", query = "SELECT p FROM PlanDePago p WHERE p.identificadorplan = :identificadorplan"),
    @NamedQuery(name = "PlanDePago.findByFecha", query = "SELECT p FROM PlanDePago p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "PlanDePago.findBySaldoactual", query = "SELECT p FROM PlanDePago p WHERE p.saldoactual = :saldoactual"),
    @NamedQuery(name = "PlanDePago.findByPagomensual", query = "SELECT p FROM PlanDePago p WHERE p.pagomensual = :pagomensual"),
    @NamedQuery(name = "PlanDePago.findByTotalacobrar", query = "SELECT p FROM PlanDePago p WHERE p.totalacobrar = :totalacobrar")})
public class PlanDePago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "identificadorplan")
    private Integer identificadorplan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldoactual")
    private double saldoactual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pagomensual")
    private double pagomensual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalacobrar")
    private double totalacobrar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identificadorplan")
    private List<Cuota> cuotaList;
    @JoinColumn(name = "numerocontribuyente", referencedColumnName = "numerocontribuyente")
    @ManyToOne(optional = false)
    private Contribuyente numerocontribuyente;

    public PlanDePago() {
    }

    public PlanDePago(Integer identificadorplan) {
        this.identificadorplan = identificadorplan;
    }

    public PlanDePago(Integer identificadorplan, Date fecha, double saldoactual, double pagomensual, double totalacobrar) {
        this.identificadorplan = identificadorplan;
        this.fecha = fecha;
        this.saldoactual = saldoactual;
        this.pagomensual = pagomensual;
        this.totalacobrar = totalacobrar;
    }

    public Integer getIdentificadorplan() {
        return identificadorplan;
    }

    public void setIdentificadorplan(Integer identificadorplan) {
        this.identificadorplan = identificadorplan;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSaldoactual() {
        return saldoactual;
    }

    public void setSaldoactual(double saldoactual) {
        this.saldoactual = saldoactual;
    }

    public double getPagomensual() {
        return pagomensual;
    }

    public void setPagomensual(double pagomensual) {
        this.pagomensual = pagomensual;
    }

    public double getTotalacobrar() {
        return totalacobrar;
    }

    public void setTotalacobrar(double totalacobrar) {
        this.totalacobrar = totalacobrar;
    }

    @XmlTransient
    public List<Cuota> getCuotaList() {
        return cuotaList;
    }

    public void setCuotaList(List<Cuota> cuotaList) {
        this.cuotaList = cuotaList;
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
        hash += (identificadorplan != null ? identificadorplan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanDePago)) {
            return false;
        }
        PlanDePago other = (PlanDePago) object;
        if ((this.identificadorplan == null && other.identificadorplan != null) || (this.identificadorplan != null && !this.identificadorplan.equals(other.identificadorplan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ues.igf9.modelos.PlanDePago[ identificadorplan=" + identificadorplan + " ]";
    }
    
}
