package com.akalin.projectManagement.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Version {

    @Id
    @GeneratedValue
    private Long id;
    @Size(max = 16)
    private String name;
    @NotNull
    private String project;
    
    public Long getId() {
        return id;
    }

    public Version setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Version setName(String name) {
        this.name = name;
        return this;
    }

    public String getProject() {
        return project;
    }

    public Version setProject(String     project) {
        this.project = project;
        return this;
    }


}
