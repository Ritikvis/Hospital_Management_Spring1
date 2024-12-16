package com.HospitalManagementForSpring1.Management.Service;

import com.HospitalManagementForSpring1.Management.Entity.Hospital;
//import com.HospitalManagementForSpring1.Management.Entity.Patient;
import com.HospitalManagementForSpring1.Management.Entity.Patient;
import com.HospitalManagementForSpring1.Management.Repository.HospitalRepository;
import com.HospitalManagementForSpring1.Management.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HospitalService {
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private PatientRepository patientRepository;

    public Hospital addHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    public String hospital_patient(Long hospitalId, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient with ID " + patientId + " not found"));
        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(() -> new RuntimeException("Hospital with ID " + hospitalId + " not found"));
        List<Patient> patients = hospital.getPatients();
        patients.add(patient);
        hospital.setPatients(patients);

        hospitalRepository.save(hospital);
        return "Patient added to hospital successfully.";
    }


    public Patient admitMostNoOfHospital() {
        List<Patient> patients = patientRepository.findAll();
        Map<Patient, Integer> patientHospitalCount = new HashMap<>();

        // Count the number of hospitals each patient is admitted to
        for (Patient patient : patients) {
            int hospitalCount = patient.getHospitals().size(); // Assuming Patient has a List<Hospital>
            patientHospitalCount.put(patient, hospitalCount);
        }

        // Find the patient with the maximum hospital count
        Patient maxHospitalPatient = null;
        int maxCount = 0;

        for (Map.Entry<Patient, Integer> entry : patientHospitalCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxHospitalPatient = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return maxHospitalPatient;
    }

}
