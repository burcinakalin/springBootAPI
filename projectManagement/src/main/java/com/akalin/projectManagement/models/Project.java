package com.akalin.projectManagement.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "projects")
public class Project {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    @Size(max = 60)
    private String name;
    @NotNull
    @Size(max = 255)
    private String description;
   /* @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "project")
    private Set<Version> version = new HashSet<Version>();
*/
    public Long getId() {
        return id;
    }

    public Project setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Project setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Project setDescription(String description) {
        this.description = description;
        return this;
    }
/*
    public Set<Version> getVersion() {
        return version;
    }

    public Project setVersion(Set<Version> version) {
        this.version = version;
        return this;
    }
    */
}
