package com.cooksys.dto;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ProjectDto {
	private Long id;
	
	private Date startDate;
	
	private Date dueDate;
	
	public ProjectDto() {		
	}
	
	public ProjectDto(Long id, Date startDate, Date dueDate) {
		super();
		this.setId(id);
		this.setStartDate(startDate);
		this.setDueDate(dueDate);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	
	
}
