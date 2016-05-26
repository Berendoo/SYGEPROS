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
 * @author Benucci
 */
@Entity
@Table(name = "LOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l"),
    @NamedQuery(name = "Log.findById", query = "SELECT l FROM Log l WHERE l.id = :id"),
    @NamedQuery(name = "Log.findByLogin", query = "SELECT l FROM Log l WHERE l.login = :login"),
    @NamedQuery(name = "Log.findByPageURL", query = "SELECT l FROM Log l WHERE l.pageURL = :pageURL"),
    @NamedQuery(name = "Log.findByAction", query = "SELECT l FROM Log l WHERE l.action = :action"),
    @NamedQuery(name = "Log.findByLogout", query = "SELECT l FROM Log l WHERE l.logout = :logout")})
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = true)
    //@NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PageURL")
    private String pageURL;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Action")
    private String action;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Logout")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logout;
    @JoinColumn(name = "IDUTILISATEUR", referencedColumnName = "IDUTILISATEUR")
    @ManyToOne(optional = false)
    private Utilisateur idutilisateur;

    public Log() {
    }

    public Log(Integer id) {
        this.id = id;
    }

    public Log(Integer id, Date login, String pageURL, String action, Date logout) {
        this.id = id;
        this.login = login;
        this.pageURL = pageURL;
        this.action = action;
        this.logout = logout;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLogin() {
        return login;
    }

    public void setLogin(Date login) {
        this.login = login;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getLogout() {
        return logout;
    }

    public void setLogout(Date logout) {
        this.logout = logout;
    }

    public Utilisateur getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Utilisateur idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ht.gouv.faes.entity.Log[ id=" + id + " ]";
    }
    
}
