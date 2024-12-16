package com.HospitalManagementForSpring1.Management.Service;

import com.HospitalManagementForSpring1.Management.Entity.Doctor;
import com.HospitalManagementForSpring1.Management.Entity.Patient;
import com.HospitalManagementForSpring1.Management.Repository.DoctorRepository;
import com.HospitalManagementForSpring1.Management.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public String doctor_patient(Long doctorId, Long patientId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(()->new RuntimeException("Id Not Found"));
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()->new RuntimeException("Id Not Found"));
        List<Patient> patients = doctor.getPatients();
        patients.add(patient);
        doctor.setPatients(patients);
        doctorRepository.save(doctor);
        return "Saved Seccussfully";
    }


    public long NoOfPatientTreatedByGivenDoctor(Long doctorId) {

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(()->new RuntimeException("Id Not Found"));
        return (long)doctor.getPatients().size();
    }
}
