package com.akalin.projectManagement.resource;

import com.akalin.projectManagement.VersionDetailRepository;
import com.akalin.projectManagement.models.Version;
import com.akalin.projectManagement.models.VersionDetail;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/versionDetails")
public class VersionDetailResource {

    VersionDetailRepository repository;

    @Inject
    public void setRepository(VersionDetailRepository repository) {

        this.repository = repository;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)//hepsini getirdi.
    public List<VersionDetail> getVersionDetails() {

        return repository.findAll();
    }


    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public VersionDetail saveVersionDetail(@RequestBody VersionDetail versionDetail) {

        return repository.save(versionDetail);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)//bu id'ye sahip olanı getirdi.
    public VersionDetail getId(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public VersionDetail deleteById(@PathVariable Long id) {

        VersionDetail versionDetail = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException());//id ye sahip olanı buldu
        repository.delete(versionDetail);//sildi
        return versionDetail;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteAll() {

        repository.deleteAll();
    }
}
