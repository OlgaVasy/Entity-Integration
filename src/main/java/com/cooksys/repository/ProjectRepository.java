package com.cooksys.repository;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cooksys.dto.ProjectDto;
import com.cooksys.entity.Project;

@Repository
public class ProjectRepository {

	EntityManager em;

	public ProjectRepository(EntityManager em) {
		this.em = em;
	}
	
	@Transactional
	public void updateProject(Project project) {
		em.merge(project);
	}

	@Transactional
	public void addProject(Project project) {
		em.persist(project);
		System.out.println("Saved Project, assigned ID[" + project.getId() + "]");
	}	

	public Project getById(int id) {
		return em.createQuery("FROM Project WHERE id = " + id, Project.class).getSingleResult();
	}

	public List<Project> getAll() {
		return em.createQuery("FROM Project", Project.class).getResultList();
	}
	
	public List<Project> getOverDue(Date now, Date dueDate) {
		return em.createQuery("FROM Project WHERE dueDate>now", Project.class).getResultList();
	}

}
