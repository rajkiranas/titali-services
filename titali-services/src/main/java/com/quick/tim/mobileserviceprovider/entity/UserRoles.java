package com.quick.tim.mobileserviceprovider.entity;
// Generated 5 Jun, 2013 6:08:00 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserRoles generated by hbm2java
 */
@Entity
@Table(name="user_roles", schema="public"
)
public class UserRoles  implements java.io.Serializable {


     private int associationId;
     private UserMaster userMaster;
     private RoleMaster roleMaster;

    public UserRoles() {
    }

    public UserRoles(int associationId, UserMaster userMaster, RoleMaster roleMaster) {
       this.associationId = associationId;
       this.userMaster = userMaster;
       this.roleMaster = roleMaster;
    }
   
     @Id 
    
    @Column(name="association_id", unique=true, nullable=false)
    public int getAssociationId() {
        return this.associationId;
    }
    
    public void setAssociationId(int associationId) {
        this.associationId = associationId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="username", nullable=false)
    public UserMaster getUserMaster() {
        return this.userMaster;
    }
    
    public void setUserMaster(UserMaster userMaster) {
        this.userMaster = userMaster;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="role_name", nullable=false)
    public RoleMaster getRoleMaster() {
        return this.roleMaster;
    }
    
    public void setRoleMaster(RoleMaster roleMaster) {
        this.roleMaster = roleMaster;
    }




}


