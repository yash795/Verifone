package com.example.SimApi.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sim_card")
public class SimCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String simCardNo;
    private long mobileNo;
    private String status;
    private Date expiryDate;
    private String stateOfRegistration;
    private String KYC;
    private String telcomProvider;
    private String fullName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSimCardNo() {
        return simCardNo;
    }

    public void setSimCardNo(String simCardNo) {
        this.simCardNo = simCardNo;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getStateOfRegistration() {
        return stateOfRegistration;
    }

    public void setStateOfRegistration(String stateOfRegistration) {
        this.stateOfRegistration = stateOfRegistration;
    }

    public String getKYC() {
        return KYC;
    }

    public void setKYC(String KYC) {
        this.KYC = KYC;
    }

    public String getTelcomProvider() {
        return telcomProvider;
    }

    public void setTelcomProvider(String telcomProvider) {
        this.telcomProvider = telcomProvider;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}