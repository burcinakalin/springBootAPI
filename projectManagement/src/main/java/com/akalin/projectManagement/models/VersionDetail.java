package com.akalin.projectManagement.models;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "versionDetail")
public class VersionDetail {

    @Id
    @GeneratedValue
    private Long id;
    @Size(max = 255)
    private String issue_description ;
    @ManyToOne
    @JoinColumn(name = "version_id")
    private Version version;

    public Long getId() {
        return id;
    }

    public VersionDetail setId(Long id) {
        this.id = id;
        return this;
    }

    public String getIssue_description() {
        return issue_description;
    }

    public VersionDetail setIssue_description(String issue_description) {
        this.issue_description = issue_description;
        return this;
    }

    public Version getVersion() {
        return version;
    }

    public VersionDetail setVersion(Version version) {
        this.version = version;
        return this;
    }
}
