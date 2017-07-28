package com.cooksys.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cooksys.dto.ProjectDto;
import com.cooksys.entity.Project;
import com.cooksys.mapper.ProjectManagerMapper;
import com.cooksys.mapper.ProjectMapper;
import com.cooksys.repository.ProjectManagerRepository;
import com.cooksys.repository.ProjectRepository;

@Service
public class ProjectService {

	private ProjectManagerMapper projectManagerMapper;
	private ProjectManagerRepository projectManagerRepo;
	private ProjectRepository projectRepo;
	private ProjectMapper projectMapper;

	public ProjectService(ProjectManagerMapper projectManagerMapper, ProjectManagerRepository projectManagerRepo,
			ProjectRepository projectRepo, ProjectMapper projectMapper) {

		this.projectManagerMapper = projectManagerMapper;
		this.projectManagerRepo = projectManagerRepo;
		this.projectRepo = projectRepo;
		this.projectMapper = projectMapper;
	}
	public List<ProjectDto> getAll() {
		return projectRepo.getAll().stream().map(projectMapper::toDto).collect(Collectors.toList());
	}	

	public boolean create(ProjectDto buildIt) {	
		Project realProject = projectMapper.fromDto(buildIt);
		projectRepo.addProject(realProject);
		return true;		
	}
	
	public ProjectDto findById(Integer id) {
		return projectMapper.toDto(projectRepo.getById(id));

	}
	public Date currentTime(){
		java.sql.Date now=new java.sql.Date(System.currentTimeMillis());
		return now;
		
	}
	public List<ProjectDto> getOverDue(Date dueDate) {
		return projectRepo.getOverDue(currentTime(), dueDate).stream().map(projectMapper::toDto).collect(Collectors.toList());
	}


}