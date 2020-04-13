package com.test.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "properties")
public class property {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int propertyID;
	private String locationX;
	private String locationY;
	private String viewedId;
	private String pageFrom;
	private String pageTo;

	public property() {
		super();
	}

	public property(String locationX, String locationY, String viewedID, String pageFrom, String pageTo) {
		super();
		this.locationX = locationX;
		this.locationY = locationY;
		this.viewedId = viewedID;
		this.pageFrom = pageFrom;
		this.pageTo = pageTo;
	}

	public int getPropertyID() {
		return propertyID;
	}

	public void setPropertyID(int propertyID) {
		this.propertyID = propertyID;
	}

	public String getLocationX() {
		return locationX;
	}

	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}

	public String getLocationY() {
		return locationY;
	}

	public void setLocationY(String locationY) {
		this.locationY = locationY;
	}

	public String getViewedID() {
		return viewedId;
	}

	public void setViewedID(String viewedID) {
		this.viewedId = viewedID;
	}

	public String getPageFrom() {
		return pageFrom;
	}

	public void setPageFrom(String pageFrom) {
		this.pageFrom = pageFrom;
	}

	public String getPageTo() {
		return pageTo;
	}

	public void setPageTo(String pageTo) {
		this.pageTo = pageTo;
	}

	@Override
	public String toString() {
		return "property [propertyID=" + propertyID + ", locationX=" + locationX + ", locationY=" + locationY
				+ ", viewedId=" + viewedId + ", pageFrom=" + pageFrom + ", pageTo=" + pageTo + "]";
	}

	
}
