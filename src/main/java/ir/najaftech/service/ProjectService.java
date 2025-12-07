package ir.najaftech.service;

import java.util.List;

import ir.najaftech.dto.request.ProjectRequest;
import ir.najaftech.model.Project;

public interface ProjectService {

    Project getProjectById(long id) throws Exception;

    List<Project> getAllProjects();

    Project createProject(ProjectRequest req) throws Exception;

    Project updateProject(ProjectRequest req, long id) throws Exception;

    void removeProject(long id) throws Exception;

}