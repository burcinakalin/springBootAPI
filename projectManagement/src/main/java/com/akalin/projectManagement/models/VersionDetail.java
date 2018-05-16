package com.akalin.projectManagement.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity

public class VersionDetail {

    @Id
    @GeneratedValue
    private Long id;
    private String version;
    @Size(max = 255)
    private String issue_description ;

    public Long getId() {
        return id;
    }

    public VersionDetail setId(Long id) {
        this.id = id;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public VersionDetail setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getIssue_description() {
        return issue_description;
    }

    public VersionDetail setIssue_description(String issue_description) {
        this.issue_description = issue_description;
        return this;
    }
}
