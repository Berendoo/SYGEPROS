/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.gouv.faes.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Benucci
 */
@Entity
@Table(name = "DOSSIERBENEFICIAIRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dossierbeneficiaire.findAll", query = "SELECT d FROM Dossierbeneficiaire d"),
    @NamedQuery(name = "Dossierbeneficiaire.findByIddossierbeneficiaire", query = "SELECT d FROM Dossierbeneficiaire d WHERE d.iddossierbeneficiaire = :iddossierbeneficiaire"),
    @NamedQuery(name = "Dossierbeneficiaire.findByDescription", query = "SELECT d FROM Dossierbeneficiaire d WHERE d.description = :description"),
    @NamedQuery(name = "Dossierbeneficiaire.findByDatecreation", query = "SELECT d FROM Dossierbeneficiaire d WHERE d.datecreation = :datecreation"),
    @NamedQuery(name = "Dossierbeneficiaire.findByCreatedBy", query = "SELECT d FROM Dossierbeneficiaire d WHERE d.createdBy = :createdBy")})
public class Dossierbeneficiaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = true)
    //@NotNull
    @Column(name = "IDDOSSIERBENEFICIAIRE")
    private Integer iddossierbeneficiaire;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Past
    @Column(name = "DATECREATION")
    @Temporal(TemporalType.DATE)
    private Date datecreation;
    @Column(name = "CreatedBy")
    private Integer createdBy;
    @JoinColumn(name = "IDINDIVIDU", referencedColumnName = "IDINDIVIDU")
    @OneToOne(optional = false)
    private Individu idindividu;

    public Dossierbeneficiaire() {
    }

    public Dossierbeneficiaire(Integer iddossierbeneficiaire) {
        this.iddossierbeneficiaire = iddossierbeneficiaire;
    }

    public Dossierbeneficiaire(Integer iddossierbeneficiaire, String description, Date datecreation) {
        this.iddossierbeneficiaire = iddossierbeneficiaire;
        this.description = description;
        this.datecreation = datecreation;
    }

    public Integer getIddossierbeneficiaire() {
        return iddossierbeneficiaire;
    }

    public void setIddossierbeneficiaire(Integer iddossierbeneficiaire) {
        this.iddossierbeneficiaire = iddossierbeneficiaire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Individu getIdindividu() {
        return idindividu;
    }

    public void setIdindividu(Individu idindividu) {
        this.idindividu = idindividu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddossierbeneficiaire != null ? iddossierbeneficiaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dossierbeneficiaire)) {
            return false;
        }
        Dossierbeneficiaire other = (Dossierbeneficiaire) object;
        if ((this.iddossierbeneficiaire == null && other.iddossierbeneficiaire != null) || (this.iddossierbeneficiaire != null && !this.iddossierbeneficiaire.equals(other.iddossierbeneficiaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "entities.Dossierbeneficiaire[ iddossierbeneficiaire=" + iddossierbeneficiaire + " ]";
        return ""+iddossierbeneficiaire;
    }
    
}
