package com.test.models;

import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "actions")
public class action {

	@Id
	@GeneratedValue
	private int actionID;
	private Instant time;
	private String type;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "propertyID")
	private property properties;

	public action() {
		super();
	}

	public action(Instant time, String type, com.test.models.property property) {
		super();
		this.time = time;
		this.type = type;
		this.properties = (com.test.models.property) property;
	}

	public int getActionID() {
		return actionID;
	}

	public void setActionID(int actionID) {
		this.actionID = actionID;
	}

	public Instant getTime() {
		return time;
	}

	public void setTime(Instant time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public property getProperties() {
		return properties;
	}

	public void setProperties(property property) {
		this.properties = property;
	}
	
	

	@Override
	public String toString() {
		return "action [actionID=" + actionID + ", time=" + time + ", type=" + type + ", properties=" + properties
				+ "]";
	}

//	public List<property> getProperties() {
//		return properties;
//	}
//
//	public void setProperties(List<property> properties) {
//		this.properties = properties;
//	}

}
