package com.HospitalManagementForSpring1.Management.Repository;

import com.HospitalManagementForSpring1.Management.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
