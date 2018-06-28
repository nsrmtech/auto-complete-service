package com.autocomplete.search.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "pincode")
public class Pincode implements Serializable {
 
    private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
 
    @Column(name = "officename")
    private String officeName;
 
    @Column(name = "pincode")
    private String pincode;
    
    @Column(name = "officetype")
    private String officeType;
    
    @Column(name = "deliverystatus")
    private String deliveryStatus;
    
    @Column(name = "divisionname")
    private String divisionName;
    
    @Column(name = "regionname")
    private String regionName;
    
    @Column(name = "circlename")
    private String circleName;
    
    @Column(name = "taluk")
    private String taluk;
    
    @Column(name = "districtname")
    private String districtName;
    
    @Column(name = "statename")
    private String stateName;
    
    

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getOfficeType() {
		return officeType;
	}

	public void setOfficeType(String officeType) {
		this.officeType = officeType;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public String getTaluk() {
		return taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "Pincode [ officeName=" + officeName + ", pincode=" + pincode + ", officeType="
				+ officeType + ", deliveryStatus=" + deliveryStatus + ", divisionName=" + divisionName + ", regionName="
				+ regionName + ", circleName=" + circleName + ", taluk=" + taluk + ", districtName=" + districtName
				+ ", stateName=" + stateName + "]";
	}
  
 
}
