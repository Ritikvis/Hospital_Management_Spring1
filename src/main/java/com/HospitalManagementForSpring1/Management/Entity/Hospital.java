package com.HospitalManagementForSpring1.Management.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalId;
    private String name;
    private String location;
    @OneToMany(mappedBy = "hospital")
    private List<Doctor> doctors;
    @ManyToMany
    private List<Patient> patients;
    public Hospital(){};

    public Hospital(Long hospitalId, String name, String location, List<Doctor> doctors, List<Patient> patients) {
        this.hospitalId = hospitalId;
        this.name = name;
        this.location = location;
        this.doctors = doctors;
        this.patients = patients;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
