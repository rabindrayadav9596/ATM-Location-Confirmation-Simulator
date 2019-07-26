package com.jon.model;

public class Location {
	private String security;
	private int distanceOfAnotherAtm;
	private String suitableArea;
	private String marketingPotential;
	public String getMarketingPotential() {
		return marketingPotential;
	}
	public void setMarketingPotential(String marketingPotential) {
		this.marketingPotential = marketingPotential;
	}
	public String getSuitableArea() {
		return suitableArea;
	}
	public void setSuitableArea(String suitableArea) {
		this.suitableArea = suitableArea;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	public int getDistanceOfAnotherAtm() {
		return distanceOfAnotherAtm;
	}
	public void setDistanceOfAnotherAtm(int distanceOfAnotherAtm) {
		this.distanceOfAnotherAtm = distanceOfAnotherAtm;
	}
	
}
