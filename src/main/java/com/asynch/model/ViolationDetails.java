package com.asynch.model;

public class ViolationDetails {
	private long establishmentID;
	private long violation;

	
	public ViolationDetails(long establishmentID){
		this.establishmentID = establishmentID;
	}
	
	public long getEstablishmentID() {
		return establishmentID;
	}
	public void setEstablishmentID(long establishmentID) {
		this.establishmentID = establishmentID;
	}
	public long getViolation() {
		return violation;
	}
	public void setViolation(long violation) {
		this.violation = violation;
	}
	
}