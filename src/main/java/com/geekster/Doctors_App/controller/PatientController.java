package com.geekster.Doctors_App.controller;

import com.geekster.Doctors_App.dto.SignInInput;
import com.geekster.Doctors_App.dto.SignInOutput;
import com.geekster.Doctors_App.dto.SignUpInput;
import com.geekster.Doctors_App.dto.SignUpOutput;
import com.geekster.Doctors_App.model.Doctor;
import com.geekster.Doctors_App.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
//@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService ps;

    //sign up
    @PostMapping(value = "/signup")
    public SignUpOutput signup(@RequestBody SignUpInput signupdto){
        return ps.signup(signupdto);
    }

    //sign in
    @PostMapping(value = "/signin")
    public SignInOutput signin(@RequestBody SignInInput signindto){
        return ps.signin(signindto);
    }

    @GetMapping(value = "/getdoc")
    public ResponseEntity<List<Doctor>> getalldoc(){
        List<Doctor> alldoc= ps.getalldoc();
        return  new ResponseEntity<List<Doctor>>(alldoc, HttpStatus.OK);
    }
}
