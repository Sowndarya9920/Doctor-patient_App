package com.geekster.Doctors_App.controller;

import com.geekster.Doctors_App.dto.SignInInput;
import com.geekster.Doctors_App.dto.SignInOutput;
import com.geekster.Doctors_App.dto.SignUpInput;
import com.geekster.Doctors_App.dto.SignUpOutput;
import com.geekster.Doctors_App.model.Appointment;
import com.geekster.Doctors_App.model.AppointmentKey;
import com.geekster.Doctors_App.model.Doctor;
import com.geekster.Doctors_App.service.AppointmentService;
import com.geekster.Doctors_App.service.AuthenticationService;
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

    @Autowired
    AuthenticationService auths;

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

    @GetMapping(value = "/getdoc/{userEmail}/{token}")
    public ResponseEntity<List<Doctor>> getalldoc(@PathVariable String userEmail,@PathVariable String token){
        HttpStatus status;
        List<Doctor> alldoc=null;
        //authenticate
        if(auths.authenticate(userEmail,token)){
           alldoc = ps.getalldoc();
            status=HttpStatus.ACCEPTED;
        }else{
            status=HttpStatus.FORBIDDEN;
        }
        return  new ResponseEntity<List<Doctor>>(alldoc, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{useremail}/{token}/")
    public ResponseEntity<Void> deleteappointment(@PathVariable String useremail,@PathVariable String token,@RequestBody AppointmentKey key){
        HttpStatus status;
        if(auths.authenticate(useremail,token)){
            ps.deleteappointment(key);
            status=HttpStatus.OK;
        }else {
            status=HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<Void>(status);
    }
}
