package com.xoriant.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="plan")
public class Plan {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="plan_id")
	private Integer planId;
	@Column(name="no_of_days")
	private int noOfDays;
	@Column(name="plan_name")
	private String planName;
	@Column(name="plan_price")
	private double planPrice;
	
	public Plan() {
		// TODO Auto-generated constructor stub
	}

	public Plan(int noOfDays, String planName, double planPrice) {
		super();
		this.noOfDays = noOfDays;
		this.planName = planName;
		this.planPrice = planPrice;
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public double getPlanPrice() {
		return planPrice;
	}

	public void setPlanPrice(double planPrice) {
		this.planPrice = planPrice;
	}

	@Override
	public String toString() {
		return "PlanType [planId=" + planId + ", noOfDays=" + noOfDays + ", planName=" + planName + ", planPrice="
				+ planPrice + "]";
	}
	
}
