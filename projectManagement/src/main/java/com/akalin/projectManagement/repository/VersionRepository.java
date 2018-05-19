package com.akalin.projectManagement.repository;

import com.akalin.projectManagement.models.Version;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionRepository extends JpaRepository< Version, Long > {
    Page<Version> findByProjectId(Long projectId, Pageable pageable);
}
