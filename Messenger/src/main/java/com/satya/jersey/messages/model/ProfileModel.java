package com.satya.jersey.messages.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProfileModel {
	
	private Long   profileid;
	private String profileName;
	private	String firstName;
	private String lastName;
	private	String Created;
	
	public ProfileModel() {
		
	}
	
	public ProfileModel(Long profileid, String profileName, String firstName, String lastName) {
		super();
		this.profileid = profileid;
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.Created = new Date().toString();
	}

	public Long getProfileid() {
		return profileid;
	}
	public void setProfileid(Long profileid) {
		this.profileid = profileid;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
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
	public String getCreated() {
		return Created;
	}
	public void setCreated(String created) {
		Created = created;
	}
	
	
	
}
