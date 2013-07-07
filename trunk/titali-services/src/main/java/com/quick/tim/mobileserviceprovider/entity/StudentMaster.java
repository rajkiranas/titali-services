package com.quick.tim.mobileserviceprovider.entity;
// Generated 5 Jun, 2013 6:08:00 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * StudentMaster generated by hbm2java
 */
@Entity
@Table(name="student_master", schema="public"
)
public class StudentMaster  implements java.io.Serializable {


     private String username;
     private Std std;
     private UserMaster userMaster;
     private String eduYear;
     private String div;
     private Short rno;
     private Date dob;
     private Character gender;
     private String address;
     private Date addDate;
     private String uploadBy;
     private Short uploadCount;

    public StudentMaster() {
    }

	
    public StudentMaster(String username, UserMaster userMaster) {
        this.username = username;
        this.userMaster = userMaster;
    }
    public StudentMaster(String username, Std std, UserMaster userMaster, String eduYear, String div, Short rno, Date dob, Character gender, String address, Date addDate, String uploadBy, Short uploadCount) {
       this.username = username;
       this.std = std;
       this.userMaster = userMaster;
       this.eduYear = eduYear;
       this.div = div;
       this.rno = rno;
       this.dob = dob;
       this.gender = gender;
       this.address = address;
       this.addDate = addDate;
       this.uploadBy = uploadBy;
       this.uploadCount = uploadCount;
    }
   
     @Id 
    
    @Column(name="username", unique=true, nullable=false, length=250)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="std")
    public Std getStd() {
        return this.std;
    }
    
    public void setStd(Std std) {
        this.std = std;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="username", unique=true, nullable=false, insertable=false, updatable=false)
    public UserMaster getUserMaster() {
        return this.userMaster;
    }
    
    public void setUserMaster(UserMaster userMaster) {
        this.userMaster = userMaster;
    }
    
    @Column(name="edu_year", length=9)
    public String getEduYear() {
        return this.eduYear;
    }
    
    public void setEduYear(String eduYear) {
        this.eduYear = eduYear;
    }
    
    @Column(name="div", length=3)
    public String getDiv() {
        return this.div;
    }
    
    public void setDiv(String div) {
        this.div = div;
    }
    
    @Column(name="rno")
    public Short getRno() {
        return this.rno;
    }
    
    public void setRno(Short rno) {
        this.rno = rno;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="dob", length=13)
    public Date getDob() {
        return this.dob;
    }
    
    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    @Column(name="gender", length=1)
    public Character getGender() {
        return this.gender;
    }
    
    public void setGender(Character gender) {
        this.gender = gender;
    }
    
    @Column(name="address", length=100)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="add_date", length=13)
    public Date getAddDate() {
        return this.addDate;
    }
    
    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
    
    @Column(name="upload_by", length=200)
    public String getUploadBy() {
        return this.uploadBy;
    }
    
    public void setUploadBy(String uploadBy) {
        this.uploadBy = uploadBy;
    }
    
    @Column(name="upload_count")
    public Short getUploadCount() {
        return this.uploadCount;
    }
    
    public void setUploadCount(Short uploadCount) {
        this.uploadCount = uploadCount;
    }




}


