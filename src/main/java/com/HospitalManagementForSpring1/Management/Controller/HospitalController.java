package com.HospitalManagementForSpring1.Management.Controller;

import com.HospitalManagementForSpring1.Management.Entity.Hospital;
import com.HospitalManagementForSpring1.Management.Entity.Patient;
import com.HospitalManagementForSpring1.Management.Service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Hospital")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;
    @PostMapping("addHospital")
    public Hospital addHospital(@RequestBody Hospital hospital){
        return hospitalService.addHospital(hospital);
    }
    @PostMapping("hospital_patient")
    public ResponseEntity<String> hospital_patient(@RequestParam Long hospitalId, @RequestParam Long patientId){
        String response  = hospitalService.hospital_patient(hospitalId,patientId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("admitMostNoOfHospital")
    public Patient admitMostNoOfHospital(){
        Patient patient = hospitalService.admitMostNoOfHospital();
        return patient;
    }
}
