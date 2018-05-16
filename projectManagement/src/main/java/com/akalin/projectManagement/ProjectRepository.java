package com.akalin.projectManagement;

import com.akalin.projectManagement.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository < Project, Long>{
    //Jpa veritabanı işlemleri için < ,primary keyin tipi>

}
