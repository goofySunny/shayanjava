package ir.najaftech.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import ir.najaftech.dto.request.ProjectRequest;
import ir.najaftech.model.Project;
import ir.najaftech.repository.ProjectRepository;
import ir.najaftech.service.ProjectService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    
    private final ProjectRepository repo;
    private final ModelMapper modelMapper;

    @Override
    public Project getProjectById(long id) throws Exception {
        return repo.findById(id).orElseThrow(() -> new Exception("Not found!"));
    }

    @Override
    public List<Project> getAllProjects() {
        return repo.findAll();
    }

    @Override
    public Project createProject(ProjectRequest req) throws Exception {
        Project mapped = modelMapper.map(req, Project.class);
        if (mapped != null) {
            return repo.save(mapped);
        } else {
            throw new Exception("Something went wrong and the save was not successful");
        }
    }

    @Override
    public Project updateProject(ProjectRequest req, long id) throws Exception {
        Project mapped = modelMapper.map(req, Project.class);
        if (mapped != null) {
            mapped.setId(id);
            return repo.save(mapped);
        } else {
            throw new Exception("Something went wrong and the save was not successful");
        }
    }

    @Override
    public void removeProject(long id) throws Exception {
        repo.findById(id).orElseThrow(() -> new Exception("Not found!"));
        repo.deleteById(id);
    }

}
