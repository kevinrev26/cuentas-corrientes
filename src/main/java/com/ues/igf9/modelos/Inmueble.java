/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf9.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kevin
 */
@Entity
@Table(name = "inmueble")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inmueble.findAll", query = "SELECT i FROM Inmueble i"),
    @NamedQuery(name = "Inmueble.findByClavecatastral", query = "SELECT i FROM Inmueble i WHERE i.clavecatastral = :clavecatastral"),
    @NamedQuery(name = "Inmueble.findByDireccioninmueble", query = "SELECT i FROM Inmueble i WHERE i.direccioninmueble = :direccioninmueble"),
    @NamedQuery(name = "Inmueble.findByAreasuperficial", query = "SELECT i FROM Inmueble i WHERE i.areasuperficial = :areasuperficial"),
    @NamedQuery(name = "Inmueble.findByMetroslineales", query = "SELECT i FROM Inmueble i WHERE i.metroslineales = :metroslineales"),
    @NamedQuery(name = "Inmueble.findByValor", query = "SELECT i FROM Inmueble i WHERE i.valor = :valor"),
    @NamedQuery(name = "Inmueble.findByObservacion", query = "SELECT i FROM Inmueble i WHERE i.observacion = :observacion")})
public class Inmueble implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "clavecatastral")
    private Integer clavecatastral;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "direccioninmueble")
    private String direccioninmueble;
    @Basic(optional = false)
    @NotNull
    @Column(name = "areasuperficial")
    private double areasuperficial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "metroslineales")
    private double metroslineales;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @Size(max = 250)
    @Column(name = "observacion")
    private String observacion;
    @ManyToMany(targetEntity = Tasa.class, cascade = CascadeType.MERGE)
    @JoinTable(name = "detalle_tasa", joinColumns = {
        @JoinColumn(name = "clavecatastral", referencedColumnName = "clavecatastral")}, inverseJoinColumns = {
        @JoinColumn(name = "codigo", referencedColumnName = "codigo")})
    @JsonManagedReference
    private List<Tasa> tasaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clavecatastral")
    private List<Traspaso> traspasoList;

    public Inmueble() {
    }

    public Inmueble(Integer clavecatastral) {
        this.clavecatastral = clavecatastral;
    }

    public Inmueble(Integer clavecatastral, String direccioninmueble, double areasuperficial, double metroslineales, double valor) {
        this.clavecatastral = clavecatastral;
        this.direccioninmueble = direccioninmueble;
        this.areasuperficial = areasuperficial;
        this.metroslineales = metroslineales;
        this.valor = valor;
    }

    public Integer getClavecatastral() {
        return clavecatastral;
    }

    public void setClavecatastral(Integer clavecatastral) {
        this.clavecatastral = clavecatastral;
    }

    public String getDireccioninmueble() {
        return direccioninmueble;
    }

    public void setDireccioninmueble(String direccioninmueble) {
        this.direccioninmueble = direccioninmueble;
    }

    public double getAreasuperficial() {
        return areasuperficial;
    }

    public void setAreasuperficial(double areasuperficial) {
        this.areasuperficial = areasuperficial;
    }

    public double getMetroslineales() {
        return metroslineales;
    }

    public void setMetroslineales(double metroslineales) {
        this.metroslineales = metroslineales;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @XmlTransient
    public List<Tasa> getTasaList() {
        return tasaList;
    }

    public void setTasaList(List<Tasa> tasaList) {
        this.tasaList = tasaList;
    }

    @XmlTransient
    public List<Traspaso> getTraspasoList() {
        return traspasoList;
    }

    public void setTraspasoList(List<Traspaso> traspasoList) {
        this.traspasoList = traspasoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clavecatastral != null ? clavecatastral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inmueble)) {
            return false;
        }
        Inmueble other = (Inmueble) object;
        if ((this.clavecatastral == null && other.clavecatastral != null) || (this.clavecatastral != null && !this.clavecatastral.equals(other.clavecatastral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ues.igf9.modelos.Inmueble[ clavecatastral=" + clavecatastral + " ]";
    }
    
}
