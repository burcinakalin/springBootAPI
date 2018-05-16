package com.akalin.projectManagement.resource;

import com.akalin.projectManagement.repository.ProjectRepository;
import com.akalin.projectManagement.models.Project;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectResource {

    ProjectRepository repository;

    @Inject
    public void setRepository(ProjectRepository repository) {

        this.repository = repository;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)//hepsini getirdi.
    public List<Project> getProject() {

        return repository.findAll();
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public Project saveProject(@RequestBody Project project) {
        return repository.save(project);

    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)//bu id'ye sahip olanı getirdi.
    public Project getId(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException( ));

    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Project deleteById(@PathVariable Long id) {
         Project project = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException( ));//id ye sahip olanı buldu
         repository.delete(project);//sildi
            return project;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteAll() {
         repository.deleteAll();
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public Project updateVersion(@PathVariable Long id, @RequestBody Project project){
        saveProject(project);
        return project;

    }

}
