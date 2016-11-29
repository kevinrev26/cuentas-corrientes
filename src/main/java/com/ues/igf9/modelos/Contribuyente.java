/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf9.modelos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "contribuyente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contribuyente.findAll", query = "SELECT c FROM Contribuyente c"),
    @NamedQuery(name = "Contribuyente.findByNumerocontribuyente", query = "SELECT c FROM Contribuyente c WHERE c.numerocontribuyente = :numerocontribuyente"),
    @NamedQuery(name = "Contribuyente.findByNombre", query = "SELECT c FROM Contribuyente c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Contribuyente.findByApellido", query = "SELECT c FROM Contribuyente c WHERE c.apellido = :apellido"),
    @NamedQuery(name = "Contribuyente.findByNit", query = "SELECT c FROM Contribuyente c WHERE c.nit = :nit"),
    @NamedQuery(name = "Contribuyente.findByDireccion", query = "SELECT c FROM Contribuyente c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Contribuyente.findByTelefono", query = "SELECT c FROM Contribuyente c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Contribuyente.findByCorreoelectronico", query = "SELECT c FROM Contribuyente c WHERE c.correoelectronico = :correoelectronico")})
public class Contribuyente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numerocontribuyente")
    private Integer numerocontribuyente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "nit")
    private String nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 250)
    @Column(name = "correoelectronico")
    private String correoelectronico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numerocontribuyente")
    private List<Traspaso> traspasoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numerocontribuyente")
    private List<CuentaCorriente> cuentaCorrienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numerocontribuyente")
    private List<PlanDePago> planDePagoList;
    @OneToMany(mappedBy = "propietario")
    private List<Inmueble> inmuebleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numerocontribuyente")
    private List<Pago> pagoList;

    public Contribuyente() {
    }

    public Contribuyente(Integer numerocontribuyente) {
        this.numerocontribuyente = numerocontribuyente;
    }

    public Contribuyente(Integer numerocontribuyente, String nombre, String apellido, String nit, String direccion, String telefono) {
        this.numerocontribuyente = numerocontribuyente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Integer getNumerocontribuyente() {
        return numerocontribuyente;
    }

    public void setNumerocontribuyente(Integer numerocontribuyente) {
        this.numerocontribuyente = numerocontribuyente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }

    @XmlTransient
    public List<Traspaso> getTraspasoList() {
        return traspasoList;
    }

    public void setTraspasoList(List<Traspaso> traspasoList) {
        this.traspasoList = traspasoList;
    }

    @XmlTransient
    public List<CuentaCorriente> getCuentaCorrienteList() {
        return cuentaCorrienteList;
    }

    public void setCuentaCorrienteList(List<CuentaCorriente> cuentaCorrienteList) {
        this.cuentaCorrienteList = cuentaCorrienteList;
    }

    @XmlTransient
    public List<PlanDePago> getPlanDePagoList() {
        return planDePagoList;
    }

    public void setPlanDePagoList(List<PlanDePago> planDePagoList) {
        this.planDePagoList = planDePagoList;
    }

    @XmlTransient
    public List<Inmueble> getInmuebleList() {
        return inmuebleList;
    }

    public void setInmuebleList(List<Inmueble> inmuebleList) {
        this.inmuebleList = inmuebleList;
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
        hash += (numerocontribuyente != null ? numerocontribuyente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contribuyente)) {
            return false;
        }
        Contribuyente other = (Contribuyente) object;
        if ((this.numerocontribuyente == null && other.numerocontribuyente != null) || (this.numerocontribuyente != null && !this.numerocontribuyente.equals(other.numerocontribuyente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ues.igf9.modelos.Contribuyente[ numerocontribuyente=" + numerocontribuyente + " ]";
    }
    
}
