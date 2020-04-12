package com.test.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "logs")
public class Log {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "session_id")
	private String sessionId;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private List<action> actions;

	public Log() {
		super();
	}

	public Log(int id, String userId, String sessionId, List<action> actions) {
		super();
		this.id = id;
		this.userId = userId;
		this.sessionId = sessionId;
		this.actions = actions;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userID) {
		this.userId = userID;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionID) {
		this.sessionId = sessionID;
	}

	public List<action> getActions() {
		return actions;
	}

	public void setActions(List<action> actions) {
		this.actions = actions;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", userId=" + userId + ", sessionId=" + sessionId + ", actions=" + actions + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public action getActionId() {
//		return actions;
//	}
//
//	public void setActionId(action actionID) {
//		this.actions = actionID;
//	}

}
