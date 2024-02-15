package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tblVet")
public class Vet extends BaseEntity {
	
//	vendor id 
	@ManyToOne(fetch = FetchType.EAGER )
	@JoinColumn(name = "provider_id")
	private Provider provider ;
	
	@Column(nullable = false)
	private String clinicname ;
	
	@Column(nullable = false)
	private String docname ;
	
	@Column(nullable = false)
	private String opentime ;
	
	@Column(nullable = false)
	private String closetime ;
	
	@Column(nullable = false)
	private String description ;
	
//	image 
	@Column
	private String imgUrl ;
	   
	
	@Column(nullable = false)
	private boolean isActive = true;
	
	@Column(nullable = false)
	private String address ;

	
	@Column
	private float pincode;
	
	@Column(nullable = false)
	private String contact ;

	public Vet() {
	
	}

	public Vet(Provider provider, String clinicname, String docname, String opentime, String closetime,
			String description, String imgUrl, boolean isActive, String address, float pincode, String contact) {
		super();
		this.provider = provider;
		this.clinicname = clinicname;
		this.docname = docname;
		this.opentime = opentime;
		this.closetime = closetime;
		this.description = description;
		this.imgUrl = imgUrl;
		this.isActive = isActive;
		this.address = address;
		this.pincode = pincode;
		this.contact = contact;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public String getClinicname() {
		return clinicname;
	}

	public void setClinicname(String clinicname) {
		this.clinicname = clinicname;
	}

	public String getDocname() {
		return docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public String getOpentime() {
		return opentime;
	}

	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}

	public String getClosetime() {
		return closetime;
	}

	public void setClosetime(String closetime) {
		this.closetime = closetime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getPincode() {
		return pincode;
	}

	public void setPincode(float pincode) {
		this.pincode = pincode;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	
}
