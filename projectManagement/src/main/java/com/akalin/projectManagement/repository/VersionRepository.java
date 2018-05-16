package com.akalin.projectManagement.repository;

import com.akalin.projectManagement.models.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionRepository extends JpaRepository< Version, Long > {

}
