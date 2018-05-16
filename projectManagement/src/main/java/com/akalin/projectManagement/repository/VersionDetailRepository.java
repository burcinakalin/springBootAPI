package com.akalin.projectManagement.repository;

import com.akalin.projectManagement.models.VersionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionDetailRepository extends JpaRepository<VersionDetail, Long> {

}
