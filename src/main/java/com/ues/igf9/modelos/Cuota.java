/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf9.modelos;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "cuota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuota.findAll", query = "SELECT c FROM Cuota c"),
    @NamedQuery(name = "Cuota.findByIdcuota", query = "SELECT c FROM Cuota c WHERE c.idcuota = :idcuota"),
    @NamedQuery(name = "Cuota.findByEstado", query = "SELECT c FROM Cuota c WHERE c.estado = :estado")})
public class Cuota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcuota")
    private Integer idcuota;
    @Column(name = "estado")
    private Boolean estado;
    @JoinColumn(name = "identificadorplan", referencedColumnName = "identificadorplan")
    @ManyToOne(optional = false)
    private PlanDePago identificadorplan;
    @OneToMany(mappedBy = "idcuota")
    private List<Pago> pagoList;

    public Cuota() {
    }

    public Cuota(Integer idcuota) {
        this.idcuota = idcuota;
    }

    public Integer getIdcuota() {
        return idcuota;
    }

    public void setIdcuota(Integer idcuota) {
        this.idcuota = idcuota;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public PlanDePago getIdentificadorplan() {
        return identificadorplan;
    }

    public void setIdentificadorplan(PlanDePago identificadorplan) {
        this.identificadorplan = identificadorplan;
    }

    @XmlTransient
    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcuota != null ? idcuota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuota)) {
            return false;
        }
        Cuota other = (Cuota) object;
        if ((this.idcuota == null && other.idcuota != null) || (this.idcuota != null && !this.idcuota.equals(other.idcuota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ues.igf9.modelos.Cuota[ idcuota=" + idcuota + " ]";
    }
    
}
