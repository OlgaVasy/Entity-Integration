package com.cooksys.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.ProjectManager;

public interface ProjectManagerRepository extends JpaRepository<ProjectManager, Long>{
	
	

}
