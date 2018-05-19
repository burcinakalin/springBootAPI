package com.akalin.projectManagement.resource;

import com.akalin.projectManagement.repository.ProjectRepository;
import com.akalin.projectManagement.repository.VersionRepository;
import com.akalin.projectManagement.models.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/versions")
public class VersionResource {

    @Autowired
    VersionRepository versionRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Inject
    public void setRepository(VersionRepository repository) {

        this.versionRepository = repository;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)//hepsini getirdi.
    public List<Version> getVersion() {

        return versionRepository.findAll();
    }


    @RequestMapping(value = "/post/{projectId}", method = RequestMethod.POST)
    public Version saveVersion(@PathVariable(value = "projectId") Long projectId, @Valid @RequestBody Version version) {

        return projectRepository.findById(projectId).map(project -> {
            version.setProject(project);
            return versionRepository.save(version);
        }).orElseThrow(() -> new ResourceNotFoundException());

    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)//bu id'ye sahip olanı getirdi.
    public Version getId(@PathVariable Long id) {

        return versionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Version deleteById(@PathVariable Long id) {

        Version version = versionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());//id ye sahip olanı buldu
        versionRepository.delete(version);//sildi
        return version;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteAll() {

        versionRepository.deleteAll();
    }

    @RequestMapping(value = "/update/{projectId}/{versionId}",method = RequestMethod.PUT)
    public Version updateVersion(@PathVariable (value = "projectId") Long projectId,
                                 @PathVariable(value = "versionId") Long versionId,
                                 @Valid @RequestBody Version versionRequest){

        return versionRepository.findById(versionId).map(version -> {
            version.setName(versionRequest.getName());
            return versionRepository.save(version);
        }).orElseThrow(() -> new ResourceNotFoundException());
    }
}
