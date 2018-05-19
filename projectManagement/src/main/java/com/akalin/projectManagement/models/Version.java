package com.akalin.projectManagement.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "versions")
public class Version {

    @Id
    @GeneratedValue
    private Long id;
    @Size(max = 16)
    private String name;
    //@NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;
   // @OneToMany(mappedBy = "version")
    //private Set<VersionDetail> versionDetail  = new HashSet<VersionDetail>();

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

    public Project getProject() {
        return project;
    }

    public Version setProject(Project project) {
        this.project = project;
        return this;
    }
/*
    public Set<VersionDetail> getVersionDetail() {
        return versionDetail;
    }

    public Version setVersionDetail(Set<VersionDetail> versionDetail) {
        this.versionDetail = versionDetail;
        return this;
    }
    */
}
