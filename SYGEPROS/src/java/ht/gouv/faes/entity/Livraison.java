/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.gouv.faes.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Benucci
 */
@Entity
@Table(name = "LIVRAISON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livraison.findAll", query = "SELECT l FROM Livraison l"),
    @NamedQuery(name = "Livraison.findByIdlivraison", query = "SELECT l FROM Livraison l WHERE l.idlivraison = :idlivraison"),
    @NamedQuery(name = "Livraison.findByQuantite", query = "SELECT l FROM Livraison l WHERE l.quantite = :quantite"),
    @NamedQuery(name = "Livraison.findByDatelivraison", query = "SELECT l FROM Livraison l WHERE l.datelivraison = :datelivraison"),
    @NamedQuery(name = "Livraison.findByNofacture", query = "SELECT l FROM Livraison l WHERE l.nofacture = :nofacture"),
    @NamedQuery(name = "Livraison.findByCin", query = "SELECT l FROM Livraison l WHERE l.cin = :cin"),
    @NamedQuery(name = "Livraison.findByDatelancement", query = "SELECT l FROM Livraison l WHERE l.datelancement = :datelancement"),
    @NamedQuery(name = "Livraison.findByPin", query = "SELECT l FROM Livraison l WHERE l.pin = :pin"),
    @NamedQuery(name = "Livraison.findByPeriode", query = "SELECT l FROM Livraison l WHERE l.periode = :periode"),
    @NamedQuery(name = "Livraison.findByMontant", query = "SELECT l FROM Livraison l WHERE l.montant = :montant"),
    @NamedQuery(name = "Livraison.findByDevise", query = "SELECT l FROM Livraison l WHERE l.devise = :devise"),
    @NamedQuery(name = "Livraison.findByPyPayerId", query = "SELECT l FROM Livraison l WHERE l.pyPayerId = :pyPayerId"),
    @NamedQuery(name = "Livraison.findByPyPayrollNo", query = "SELECT l FROM Livraison l WHERE l.pyPayrollNo = :pyPayrollNo"),
    @NamedQuery(name = "Livraison.findByPyPayeeId", query = "SELECT l FROM Livraison l WHERE l.pyPayeeId = :pyPayeeId"),
    @NamedQuery(name = "Livraison.findByDossier", query = "SELECT l FROM Livraison l WHERE l.dossier = :dossier"),
    @NamedQuery(name = "Livraison.findByNumeroch", query = "SELECT l FROM Livraison l WHERE l.numeroch = :numeroch"),
    @NamedQuery(name = "Livraison.findBySerie", query = "SELECT l FROM Livraison l WHERE l.serie = :serie")})
public class Livraison implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = true)
    //@NotNull
    @Column(name = "IDLIVRAISON")
    private Integer idlivraison;
    @Column(name = "QUANTITE")
    private Integer quantite;
    @Column(name = "DATELIVRAISON")
    @Temporal(TemporalType.DATE)
    private Date datelivraison;
    @Size(max = 15)
    @Column(name = "NOFACTURE")
    private String nofacture;
    @Size(max = 17)
    @Column(name = "CIN")
    private String cin;
    @Column(name = "DATELANCEMENT")
    @Temporal(TemporalType.DATE)
    private Date datelancement;
    @Size(max = 10)
    @Column(name = "PIN")
    private String pin;
    @Size(max = 15)
    @Column(name = "PERIODE")
    private String periode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTANT")
    private BigDecimal montant;
    @Column(name = "DEVISE")
    private String devise;
    @Size(max = 15)
    @Column(name = "PY_PAYER_ID")
    private String pyPayerId;
    @Size(max = 15)
    @Column(name = "PY_PAYROLL_NO")
    private String pyPayrollNo;
    @Size(max = 15)
    @Column(name = "PY_PAYEE_ID")
    private String pyPayeeId;
    @Size(max = 10)
    @Column(name = "DOSSIER")
    private String dossier;
    @Size(max = 10)
    @Column(name = "NUMEROCH")
    private String numeroch;
    @Size(max = 15)
    @Column(name = "SERIE")
    private String serie;
    @JoinColumn(name = "IDCOMMUNE", referencedColumnName = "IDCOMMUNE")
    @ManyToOne(optional = false)
    private Commune idcommune;
    @JoinColumn(name = "IDDIDTRIBUTEUR", referencedColumnName = "IDDISTRIBUTEUR")
    @ManyToOne
    private Distributeur iddidtributeur;
    @JoinColumn(name = "IDFICHE", referencedColumnName = "IDFICHE")
    @ManyToOne(optional = false)
    private Fichebeneficiaire idfiche;
    @JoinColumn(name = "IDPRESTATION", referencedColumnName = "IDPRESTATION")
    @ManyToOne(optional = false)
    private Prestation idprestation;

    public Livraison() {
    }

    public Livraison(Integer idlivraison) {
        this.idlivraison = idlivraison;
    }

    public Integer getIdlivraison() {
        return idlivraison;
    }

    public void setIdlivraison(Integer idlivraison) {
        this.idlivraison = idlivraison;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Date getDatelivraison() {
        return datelivraison;
    }

    public void setDatelivraison(Date datelivraison) {
        this.datelivraison = datelivraison;
    }

    public String getNofacture() {
        return nofacture;
    }

    public void setNofacture(String nofacture) {
        this.nofacture = nofacture;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Date getDatelancement() {
        return datelancement;
    }

    public void setDatelancement(Date datelancement) {
        this.datelancement = datelancement;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getPyPayerId() {
        return pyPayerId;
    }

    public void setPyPayerId(String pyPayerId) {
        this.pyPayerId = pyPayerId;
    }

    public String getPyPayrollNo() {
        return pyPayrollNo;
    }

    public void setPyPayrollNo(String pyPayrollNo) {
        this.pyPayrollNo = pyPayrollNo;
    }

    public String getPyPayeeId() {
        return pyPayeeId;
    }

    public void setPyPayeeId(String pyPayeeId) {
        this.pyPayeeId = pyPayeeId;
    }

    public String getDossier() {
        return dossier;
    }

    public void setDossier(String dossier) {
        this.dossier = dossier;
    }

    public String getNumeroch() {
        return numeroch;
    }

    public void setNumeroch(String numeroch) {
        this.numeroch = numeroch;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Commune getIdcommune() {
        return idcommune;
    }

    public void setIdcommune(Commune idcommune) {
        this.idcommune = idcommune;
    }

    public Distributeur getIddidtributeur() {
        return iddidtributeur;
    }

    public void setIddidtributeur(Distributeur iddidtributeur) {
        this.iddidtributeur = iddidtributeur;
    }

    public Fichebeneficiaire getIdfiche() {
        return idfiche;
    }

    public void setIdfiche(Fichebeneficiaire idfiche) {
        this.idfiche = idfiche;
    }

    public Prestation getIdprestation() {
        return idprestation;
    }

    public void setIdprestation(Prestation idprestation) {
        this.idprestation = idprestation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlivraison != null ? idlivraison.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livraison)) {
            return false;
        }
        Livraison other = (Livraison) object;
        if ((this.idlivraison == null && other.idlivraison != null) || (this.idlivraison != null && !this.idlivraison.equals(other.idlivraison))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ht.gouv.faes.entity.Livraison[ idlivraison=" + idlivraison + " ]";
    }
    
}
