package com.HospitalManagementForSpring1.Management.Repository;

import com.HospitalManagementForSpring1.Management.Entity.Hospital;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital,Long> {
}
