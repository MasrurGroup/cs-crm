package com.ikonsoft.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mohamed
 */
@Entity
@Table(name = "offer")
 
 
public class Offer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "RequesterName")
    private String requesterName;
    @Column(name = "Department")
    private String department;
    @Column(name="description")
    private String description;
    @Column(name="objective")
    private String objective;
  
 @Column(name = "MarketLaunchDate")
    @Temporal(TemporalType.DATE)
    private Date marketLaunchDate;
    @Column(name = "Channels")
    private String channels;
    @Column(name = "SenderEmail")
    private String senderEmail;
    @Lob
    
    
    @Column(name = "MarketEndDate")
    @Temporal(TemporalType.DATE)
    private Date marketEndDate;
    @Column(name = "DBfileSent")
    private String dBfileSent;
    @Column(name = "ProjectName")
    private String projectName;
    @Column(name = "Languages")
    private String languages;
    @JoinColumn(name = "PartnerID", referencedColumnName = "id")
    @ManyToOne
    private Partner partnerID;
    @Column(name = "budget")
    private Double budget;
    @Column(name = "approved")
    private Boolean approved=false;
    
    @Column(name = "TargetAudience")
    private String targetAudience;
    
    
    public Offer() {
    }

    public Offer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getMarketLaunchDate() {
        return marketLaunchDate;
    }

    public void setMarketLaunchDate(Date marketLaunchDate) {
        this.marketLaunchDate = marketLaunchDate;
    }

    public String getChannels() {
        return channels;
    }

    public void setChannels(String channels) {
        this.channels = channels;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

   
    public Date getMarketEndDate() {
        return marketEndDate;
    }

    public void setMarketEndDate(Date marketEndDate) {
        this.marketEndDate = marketEndDate;
    }

    public String getDBfileSent() {
        return dBfileSent;
    }

    public void setDBfileSent(String dBfileSent) {
        this.dBfileSent = dBfileSent;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public Partner getPartnerID() {
        return partnerID;
    }

    public void setPartnerID(Partner partnerID) {
        this.partnerID = partnerID;
    }
       public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
    public String getDescription() {
    return description;
   }

   public void setDescription(String description) {
    this.description = description;
   }

    public String getObjective() {
  return objective;
 }

 public void setObjective(String objective) {
  this.objective = objective;
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
        if (!(object instanceof Offer)) {
            return false;
        }
        Offer other = (Offer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "asd.Offer[ id=" + id + " ]";
    }

 public String getTargetAudience() {
  return targetAudience;
 }

 public void setTargetAudience(String targetAudience) {
  this.targetAudience = targetAudience;
 }
    
}