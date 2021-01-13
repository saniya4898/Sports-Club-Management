package com.xoriant.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clerk")
public class Clerk {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="clerk_id")
	private Integer clerkId;
	@Column(name="clerk_name")
	private String clerkName;
	@Column(name="clerk_password")
	private String clerkPassword;
	
	public Clerk() {
	}
	
	public Clerk(String clerkName, String clerkPassword) {
		super();
		this.clerkName = clerkName;
		this.clerkPassword = clerkPassword;
	}

	public String getClerkName() {
		return clerkName;
	}

	public void setClerkName(String clerkName) {
		this.clerkName = clerkName;
	}

	public String getClerkPassword() {
		return clerkPassword;
	}

	public void setClerkPassword(String clerkPassword) {
		this.clerkPassword = clerkPassword;
	}

	public Integer getClerkId() {
		return clerkId;
	}

	public void setClerkId(Integer clerkId) {
		this.clerkId = clerkId;
	}

	@Override
	public String toString() {
		return "Clerk [clerkId=" + clerkId + ", clerkName=" + clerkName + ", clerkPassword=" + clerkPassword + "]";
	}
	
}
