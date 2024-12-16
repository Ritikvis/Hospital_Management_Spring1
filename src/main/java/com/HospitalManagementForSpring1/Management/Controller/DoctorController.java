package com.HospitalManagementForSpring1.Management.Controller;

import com.HospitalManagementForSpring1.Management.Entity.Doctor;
import com.HospitalManagementForSpring1.Management.Entity.Hospital;
import com.HospitalManagementForSpring1.Management.Repository.HospitalRepository;
import com.HospitalManagementForSpring1.Management.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private HospitalRepository hospitalRepository;
    @PostMapping("addDoctor")
    public Doctor addDoctor(@RequestBody Doctor doctor, @RequestParam Long hospitalId){
        Hospital hospital = hospitalRepository.findById(hospitalId)
                .orElseThrow(()-> new RuntimeException("Id Not found"));
        doctor.setHospital(hospital);
        Doctor doctor1 = doctorService.addDoctor(doctor);
        return doctor1;

    }
    @PostMapping("doctor_patient")
    public ResponseEntity<String> doctor_patient(@RequestParam Long doctorId,@RequestParam Long patientId){
        String responce  = doctorService.doctor_patient(doctorId,patientId);
        return new ResponseEntity<>(responce, HttpStatus.OK);
    }
    @GetMapping("NoOfPatientTreatedByGivenDoctor")
    private Long NoOfPatientTreatedByGivenDoctor(@RequestParam Long doctorId){
        long ans = doctorService.NoOfPatientTreatedByGivenDoctor(doctorId);
        return ans;

    }
}
