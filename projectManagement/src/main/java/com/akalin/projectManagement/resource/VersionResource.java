package com.akalin.projectManagement.resource;

import com.akalin.projectManagement.repository.VersionRepository;
import com.akalin.projectManagement.models.Version;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/versions")
public class VersionResource {

    VersionRepository repository;

    @Inject
    public void setRepository(VersionRepository repository) {

        this.repository = repository;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)//hepsini getirdi.
    public List<Version> getVersion() {

        return repository.findAll();
    }


    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public Version saveVersion(@RequestBody Version version) {

        return repository.save(version);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)//bu id'ye sahip olanı getirdi.
    public Version getId(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Version deleteById(@PathVariable Long id) {

        Version version = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException());//id ye sahip olanı buldu
        repository.delete(version);//sildi
        return version;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteAll() {

        repository.deleteAll();
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public Version updateVersion(@PathVariable Long id, @RequestBody Version version){
        saveVersion(version);
        return version;

    }
}
