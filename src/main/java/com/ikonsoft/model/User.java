 
package com.ikonsoft.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.restfb.FacebookClient.AccessToken;

/**
 *
 * @author Yousif
 */
@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByEmailId", query = "SELECT u FROM User u WHERE u.emailId = :emailId"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByFacebook", query = "SELECT u FROM User u WHERE u.facebook = :facebook"),
    @NamedQuery(name = "User.findByBirthdate", query = "SELECT u FROM User u WHERE u.birthdate = :birthdate"),
    @NamedQuery(name = "User.findByNationalId", query = "SELECT u FROM User u WHERE u.nationalId = :nationalId"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByArea", query = "SELECT u FROM User u WHERE u.area = :area"),
    @NamedQuery(name = "User.findByProfession", query = "SELECT u FROM User u WHERE u.profession = :profession"),
    @NamedQuery(name = "User.findByMartialStatus", query = "SELECT u FROM User u WHERE u.martialStatus = :martialStatus"),
    @NamedQuery(name = "User.findByGender", query = "SELECT u FROM User u WHERE u.gender = :gender"),
    @NamedQuery(name = "User.findByNumberOfChildren", query = "SELECT u FROM User u WHERE u.numberOfChildren = :numberOfChildren"),
    @NamedQuery(name = "User.findByDisabled", query = "SELECT u FROM User u WHERE u.disabled = :disabled"),
    @NamedQuery(name = "User.findByPhone", query = "SELECT u FROM User u WHERE u.phone = :phone"),
    @NamedQuery(name = "User.findByFriendName", query = "SELECT u FROM User u WHERE u.friendName = :friendName"),
    @NamedQuery(name = "User.findByFriendEmail", query = "SELECT u FROM User u WHERE u.friendEmail = :friendEmail"),
    @NamedQuery(name = "User.findByAuthority", query = "SELECT u FROM User u WHERE u.authority = :authority")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private int partnerId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "email_id")
    private String emailId;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Column(name = "facebook")
    private String facebook;
    
    @Column(name = "whatsapp")
    private String whatsapp;
    
    @Column(name = "birthdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthdate;
    @Column(name = "nationalId")
    private String nationalId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
     
    private String street;

	private String area;
    private String city;
    private String postalCode;
    
    @Column(name = "profession")
    private String profession;
    @Column(name = "address")
    private String address;
  
    @Column(name = "martialStatus")
    private String martialStatus;
    @Column(name = "gender")
    private String gender;
    @Column(name = "numberOfChildren")
    private Short numberOfChildren;
    @Column(name = "disabled")
    private Boolean disabled;
    @Column(name = "phone")
    private String phone;
    @Column(name = "friendName")
    private String friendName;
    @Column(name = "friendEmail")
    private String friendEmail;
    @Column(name = "authority")
    private String authority;
    @Column(name = "userToken")
    private String userToken;
    @Column(name="voucherNumber")
    private Integer voucherNumber;
    @Column(name = "country_id")
    private Integer countryId;
    @Column(name="city_id")
    private Integer cityId ;
    @Column(name="region_id")
    private Integer regionId ;
    @Column(name="profession_id")
    private Integer professionId;
    @Column(name="subprofession_id")
    private Integer subprofessionId;
    @Column(name="acessToken")
    private String acessToken;

    
    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String emailId, String password) {
        this.userId = userId;
        this.emailId = emailId;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

     
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Short getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(Short numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getFriendEmail() {
        return friendEmail;
    }

    public void setFriendEmail(String friendEmail) {
        this.friendEmail = friendEmail;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
    

	public Integer getVoucherNumber() {
		return voucherNumber;
	}

	public void setVoucherNumber(Integer voucherNumber) {
		this.voucherNumber = voucherNumber;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public Integer getProfessionId() {
		return professionId;
	}

	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}

	public Integer getSubprofessionId() {
		return subprofessionId;
	}

	public void setSubprofessionId(Integer subprofessionId) {
		this.subprofessionId = subprofessionId;
	}

	public String getAcessToken() {
		return acessToken;
	}

	public void setAcessToken(String acessToken) {
		this.acessToken = acessToken;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }
    public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


    @Override
    public String toString() {
        return "User[ firstName=" + firstName +"\tEmail:"+emailId +"\tPassword:"+password+"\tToken:"+ userToken+" ]";
    }

	public int getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String acessToken) {
		this.userToken = acessToken;
	}
	
	

    
}
