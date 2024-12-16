package com.HospitalManagementForSpring1.Management.Repository;

import com.HospitalManagementForSpring1.Management.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
