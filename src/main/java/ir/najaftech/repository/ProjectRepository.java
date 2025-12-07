package ir.najaftech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ir.najaftech.model.Project;

public interface  ProjectRepository extends JpaRepository<Project, Long>{
    
}
