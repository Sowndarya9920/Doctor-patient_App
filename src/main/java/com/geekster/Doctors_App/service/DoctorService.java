package com.geekster.Doctors_App.service;

import com.geekster.Doctors_App.Repository.IDoctorRepo;
import com.geekster.Doctors_App.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    IDoctorRepo dr;

    public void adddoc(Doctor doctor) {
        dr.save(doctor);
    }

    public List<Doctor> getalldoc() {
         List<Doctor> alldoc= (List<Doctor>) dr.findAll();
         return alldoc;

    }
}
