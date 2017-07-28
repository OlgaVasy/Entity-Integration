package com.cooksys.controller;


import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.dto.ProjectDto;
import com.cooksys.entity.Project;
import com.cooksys.service.ProjectService;

@RestController
@RequestMapping("project")
public class ProjectController {

	private ProjectService projectService;

	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}	

	@GetMapping
	public List<ProjectDto> projects() {
		return projectService.getAll();
	}
	
	@GetMapping("{id}")
	public ProjectDto getProjectById(@PathVariable Integer id) {
		return projectService.findById(id);
	}
	@GetMapping("{dueDate}")
	public List<ProjectDto> overDueProjects(@PathVariable Date dueDate) {
		return projectService.getOverDue(dueDate);
	}
	
	@PostMapping
	public void buildAProject(@RequestBody ProjectDto buildIt, HttpServletResponse response) {
		
		if(projectService.create(buildIt))
			response.setStatus(HttpServletResponse.SC_CREATED);
		else
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	}	

}