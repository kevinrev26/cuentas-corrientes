/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf9.modelos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "interes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Interes.findAll", query = "SELECT i FROM Interes i"),
    @NamedQuery(name = "Interes.findByIdinteres", query = "SELECT i FROM Interes i WHERE i.idinteres = :idinteres"),
    @NamedQuery(name = "Interes.findByTasa", query = "SELECT i FROM Interes i WHERE i.tasa = :tasa")})
public class Interes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idinteres")
    private Integer idinteres;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tasa")
    private double tasa;

    public Interes() {
    }

    public Interes(Integer idinteres) {
        this.idinteres = idinteres;
    }

    public Interes(Integer idinteres, double tasa) {
        this.idinteres = idinteres;
        this.tasa = tasa;
    }

    public Integer getIdinteres() {
        return idinteres;
    }

    public void setIdinteres(Integer idinteres) {
        this.idinteres = idinteres;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinteres != null ? idinteres.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interes)) {
            return false;
        }
        Interes other = (Interes) object;
        if ((this.idinteres == null && other.idinteres != null) || (this.idinteres != null && !this.idinteres.equals(other.idinteres))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ues.igf9.modelos.Interes[ idinteres=" + idinteres + " ]";
    }
    
}
