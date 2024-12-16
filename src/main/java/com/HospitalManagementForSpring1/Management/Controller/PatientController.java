package com.HospitalManagementForSpring1.Management.Controller;

import com.HospitalManagementForSpring1.Management.Entity.Patient;
import com.HospitalManagementForSpring1.Management.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Patient")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @PostMapping("addPatient")
    public Patient addPatient(@RequestBody Patient patient){
        return patientService.addPatient(patient);
    }
}
