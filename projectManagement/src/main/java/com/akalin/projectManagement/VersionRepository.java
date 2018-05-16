package com.akalin.projectManagement;

import com.akalin.projectManagement.models.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionRepository extends JpaRepository< Version, Long > {

}
