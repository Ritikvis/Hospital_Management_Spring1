package com.HospitalManagementForSpring1.Management.Service;

import com.HospitalManagementForSpring1.Management.Entity.Patient;
import com.HospitalManagementForSpring1.Management.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
}
