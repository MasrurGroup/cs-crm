package com.ikonsoft.model;
 

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
 


@Entity
@Table

@NamedQueries({
    @NamedQuery(name = "Partner.findAll", query = "SELECT p FROM Partner p"),
    @NamedQuery(name = "Partner.findById", query = "SELECT p FROM Partner p WHERE p.id = :id"),
    @NamedQuery(name = "Partner.findByCompanyEmail", query = "SELECT p FROM Partner p WHERE p.companyEmail = :companyEmail"),
    @NamedQuery(name = "Partner.findByCompanyName", query = "SELECT p FROM Partner p WHERE p.companyName = :companyName"),
    @NamedQuery(name = "Partner.findByPassword", query = "SELECT p FROM Partner p WHERE p.password = :password"),
    @NamedQuery(name = "Partner.findByYearofCompanyFormation", query = "SELECT p FROM Partner p WHERE p.yearofCompanyFormation = :yearofCompanyFormation"),
    @NamedQuery(name = "Partner.findByCompanyRegistrationNumber", query = "SELECT p FROM Partner p WHERE p.companyRegistrationNumber = :companyRegistrationNumber"),
    @NamedQuery(name = "Partner.findByOfficername", query = "SELECT p FROM Partner p WHERE p.officername = :officername"),
    @NamedQuery(name = "Partner.findByPosition", query = "SELECT p FROM Partner p WHERE p.position = :position"),
    @NamedQuery(name = "Partner.findByAddress", query = "SELECT p FROM Partner p WHERE p.address = :address"),
    @NamedQuery(name = "Partner.findByTelephone", query = "SELECT p FROM Partner p WHERE p.telephone = :telephone"),
    @NamedQuery(name = "Partner.findByBusinesstype", query = "SELECT p FROM Partner p WHERE p.businesstype = :businesstype"),
    @NamedQuery(name = "Partner.findByNumberofEmployees", query = "SELECT p FROM Partner p WHERE p.numberofEmployees = :numberofEmployees"),
    @NamedQuery(name = "Partner.findByNumberofcustomers", query = "SELECT p FROM Partner p WHERE p.numberofcustomers = :numberofcustomers"),
    @NamedQuery(name = "Partner.findByDataFileUploded", query = "SELECT p FROM Partner p WHERE p.dataFileUploded = :dataFileUploded")})
public class Partner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
   
    @Basic(optional = false)   
    @Column(nullable = false, length = 300)
    private String companyEmail;
    @Basic(optional = false)
     
    
    @Column(nullable = false, length = 300)
    private String companyName;
    @Basic(optional = false)
     
    
    @Column(nullable = false, length = 150)
    private String password;
    @Basic(optional = false)
     
   
    @Column(nullable = false)
    private int yearofCompanyFormation;
    @Basic(optional = false)
     
   
    @Column(nullable = false)
    private String companyRegistrationNumber;
    @Basic(optional = false)
     
    
    @Column(nullable = false, length = 300)
    private String officername;
    @Basic(optional = false)
     
    
    @Column(nullable = false, length = 300)
    private String position;
    @Basic(optional = false)
     
    
    @Column(nullable = false, length = 300)
    private String address;
    @Basic(optional = false)
     
    @Column(nullable = false, length = 300)
    private String partnertype;
    @Basic(optional = false)
     
    @Column(nullable = false, length = 300)
    private String interest;
    @Basic(optional = false)
     
    
    @Column(nullable = false, length = 20)
    private String telephone;
    @Basic(optional = false)
     
    
    @Column(nullable = false, length = 300)
    private String businesstype;
    @Basic(optional = false)
     
    @Column(nullable = false)
    private int numberofEmployees;
    @Basic(optional = false)
     
    
    @Column(nullable = false)
    private int numberofcustomers;
    @Basic(optional = false)
     
    @Column(nullable = false)
    private boolean dataFileUploded;

    public Partner() {
    }

    public Partner(Integer id) {
        this.id = id;
    }

    public Partner(Integer id, String companyEmail, String companyName, String password, int yearofCompanyFormation, String companyRegistrationNumber, String officername, String position, String address, String telephone, String businesstype, int numberofEmployees, int numberofcustomers, boolean dataFileUploded) {
        this.id = id;
        this.companyEmail = companyEmail;
        this.companyName = companyName;
        this.password = password;
        this.yearofCompanyFormation = yearofCompanyFormation;
        this.companyRegistrationNumber = companyRegistrationNumber;
        this.officername = officername;
        this.position = position;
        this.address = address;
        this.telephone = telephone;
        this.businesstype = businesstype;
        this.numberofEmployees = numberofEmployees;
        this.numberofcustomers = numberofcustomers;
        this.dataFileUploded = dataFileUploded;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getYearofCompanyFormation() {
        return yearofCompanyFormation;
    }

    public void setYearofCompanyFormation(int yearofCompanyFormation) {
        this.yearofCompanyFormation = yearofCompanyFormation;
    }

    public String getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    public void setCompanyRegistrationNumber(String companyRegistrationNumber) {
        this.companyRegistrationNumber = companyRegistrationNumber;
    }

    public String getOfficername() {
        return officername;
    }

    public void setOfficername(String officername) {
        this.officername = officername;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBusinesstype() {
        return businesstype;
    }

    public void setBusinesstype(String businesstype) {
        this.businesstype = businesstype;
    }

    public int getNumberofEmployees() {
        return numberofEmployees;
    }

    public void setNumberofEmployees(int numberofEmployees) {
        this.numberofEmployees = numberofEmployees;
    }

    public int getNumberofcustomers() {
        return numberofcustomers;
    }

    public void setNumberofcustomers(int numberofcustomers) {
        this.numberofcustomers = numberofcustomers;
    }

    public boolean getDataFileUploded() {
        return dataFileUploded;
    }

    public void setDataFileUploded(boolean dataFileUploded) {
        this.dataFileUploded = dataFileUploded;
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
        if (!(object instanceof Partner)) {
            return false;
        }
        Partner other = (Partner) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    	return "Partner[ Company Name=" + companyName +"\tEmail:"+companyEmail +"\tPassword:"+password+"\tbusinesstype:"+ businesstype+" ]";
    }

	public String getPartnertype() {
		return partnertype;
	}

	public void setPartnertype(String partnertype) {
		this.partnertype = partnertype;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}
    
}
