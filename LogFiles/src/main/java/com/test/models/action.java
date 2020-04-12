package com.test.models;

import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int actionID;
	private Instant time;
	private String type;
	private int id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "propertyID")
	private property properties;

	@ManyToOne(cascade = CascadeType.ALL)
	private Log log;

	public action() {
		super();
	}

	public action(int actionID, Instant time, String type, property properties, Log log) {
		super();
		this.actionID = actionID;
		this.time = time;
		this.type = type;
		this.properties = properties;
		this.log = log;
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

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "action [actionID=" + actionID + ", time=" + time + ", type=" + type + ", properties=" + properties
				+ ", log=" + log + "]";
	}

	

//	public List<property> getProperties() {
//		return properties;
//	}
//
//	public void setProperties(List<property> properties) {
//		this.properties = properties;
//	}

}
