package com.task.allocation.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class Tasks {

	@Id
	private String id;
	
	private String name;
	
	private String assignee;
	
	private String start_date;
	
	public Tasks(String name, String assignee, String start_date, String end_date, String comments) {
		super();
		this.name = name;
		this.assignee = assignee;
		this.start_date = start_date;
		this.end_date = end_date;
		this.comments = comments;
	}

	private String end_date;
	
	private String comments;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
