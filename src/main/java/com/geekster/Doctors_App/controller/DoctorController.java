package com.geekster.Doctors_App.controller;

import com.geekster.Doctors_App.model.Doctor;
import com.geekster.Doctors_App.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
    @Autowired
    DoctorService ds;

    @PostMapping(value = "/adddoc")
    public void adddoc(@RequestBody Doctor doctor){
        ds.adddoc(doctor);
    }
}
