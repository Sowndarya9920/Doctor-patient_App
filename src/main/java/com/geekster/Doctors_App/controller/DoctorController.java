package com.geekster.Doctors_App.controller;

import com.geekster.Doctors_App.model.Appointment;
import com.geekster.Doctors_App.model.Doctor;
import com.geekster.Doctors_App.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {
    @Autowired
    DoctorService ds;

    @PostMapping(value = "/adddoc")
    public void adddoc(@RequestBody Doctor doctor){
        ds.adddoc(doctor);
    }

    @GetMapping(value = "/docappoint/{id}")
    public ResponseEntity<List<Appointment>> getmyappointment(@PathVariable Long id){
        HttpStatus status;
        List<Appointment> myappointment=null;
        try {
            myappointment=ds.getmyappointment(id);
            if(myappointment.isEmpty()){
                status=HttpStatus.NO_CONTENT;
            }else{
                status=HttpStatus.OK;
            }
        }catch (Exception e){
            System.out.println(e);
            status=HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<List<Appointment>>(myappointment,status);
    }
}
