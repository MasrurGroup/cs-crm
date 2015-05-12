/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikonsoft.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Yousif
 */
@Entity
@Table(name = "user_roles")
@NamedQueries({
    @NamedQuery(name = "UserRoles.findAll", query = "SELECT u FROM UserRoles u"),
    @NamedQuery(name = "UserRoles.findByRoleId", query = "SELECT u FROM UserRoles u WHERE u.userRolesPK.roleId = :roleId"),
    @NamedQuery(name = "UserRoles.findByUserId", query = "SELECT u FROM UserRoles u WHERE u.userRolesPK.userId = :userId")})
public class UserRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserRolesPK userRolesPK;

    public UserRoles() {
    }

    public UserRoles(UserRolesPK userRolesPK) {
        this.userRolesPK = userRolesPK;
    }

    public UserRoles(int roleId, int userId) {
        this.userRolesPK = new UserRolesPK(roleId, userId);
    }

    public UserRolesPK getUserRolesPK() {
        return userRolesPK;
    }

    public void setUserRolesPK(UserRolesPK userRolesPK) {
        this.userRolesPK = userRolesPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userRolesPK != null ? userRolesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRoles)) {
            return false;
        }
        UserRoles other = (UserRoles) object;
        if ((this.userRolesPK == null && other.userRolesPK != null) || (this.userRolesPK != null && !this.userRolesPK.equals(other.userRolesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ikonsoft.model.UserRoles[ userRolesPK=" + userRolesPK + " ]";
    }
    
}
