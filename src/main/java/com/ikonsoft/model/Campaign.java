/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikonsoft.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author MasrurGroup
 */
@Entity
@Table(name = "campaign")

public class Campaign implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "BusinessType")
    private String businessType;
    @Column(name = "CampaignDescription")
    private String campaignDescription;
    @Column(name = "CampaignObjectives")
    private String campaignObjectives;
    @Column(name = "Channels")
    private String channels;
    @Column(name = "DBFileSent")
    private String dBFileSent;
    @Column(name = "Languages")
    private String languages;
    @Column(name = "MarketEndDate")
    @Temporal(TemporalType.DATE)
    private Date marketEndDate;
    @Column(name = "MarketLaunchDate")
    @Temporal(TemporalType.DATE)
    private Date marketLaunchDate;
    @Column(name = "OfferType")
    private String offerType;
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    @Column(name = "ProjectName")
    private String projectName;
    @Basic(optional = false)
    @Column(name = "RequesterName")
    private String requesterName;
    @Basic(optional = false)
    @Column(name = "SenderEmail")
    private String senderEmail;
    @Column(name = "TargetAudience")
    private String targetAudience;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "budget")
    private Double budget;
    @Column(name = "approved")
    private Boolean approved=false;

    public Campaign() {
    }

    public Campaign(Integer id) {
        this.id = id;
    }

    public Campaign(Integer id, String businessType, String requesterName, String senderEmail) {
        this.id = id;
        this.businessType = businessType;
        this.requesterName = requesterName;
        this.senderEmail = senderEmail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getCampaignDescription() {
        return campaignDescription;
    }

    public void setCampaignDescription(String campaignDescription) {
        this.campaignDescription = campaignDescription;
    }

    public String getCampaignObjectives() {
        return campaignObjectives;
    }

    public void setCampaignObjectives(String campaignObjectives) {
        this.campaignObjectives = campaignObjectives;
    }

    public String getChannels() {
        return channels;
    }

    public void setChannels(String channels) {
        this.channels = channels;
    }

    public String getDBFileSent() {
        return dBFileSent;
    }

    public void setDBFileSent(String dBFileSent) {
        this.dBFileSent = dBFileSent;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public Date getMarketEndDate() {
        return marketEndDate;
    }

    public void setMarketEndDate(Date marketEndDate) {
        this.marketEndDate = marketEndDate;
    }

    public Date getMarketLaunchDate() {
        return marketLaunchDate;
    }

    public void setMarketLaunchDate(Date marketLaunchDate) {
        this.marketLaunchDate = marketLaunchDate;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campaign)) {
            return false;
        }
        Campaign other = (Campaign) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ikonsoft.model.Campaign[ requesterName =" + requesterName + " ]";
    }
    
}
