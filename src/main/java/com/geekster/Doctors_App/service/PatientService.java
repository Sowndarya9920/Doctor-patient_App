package com.geekster.Doctors_App.service;

import com.geekster.Doctors_App.Repository.IPatientRepo;
import com.geekster.Doctors_App.dto.SignInInput;
import com.geekster.Doctors_App.dto.SignInOutput;
import com.geekster.Doctors_App.dto.SignUpInput;
import com.geekster.Doctors_App.dto.SignUpOutput;
import com.geekster.Doctors_App.model.AppointmentKey;
import com.geekster.Doctors_App.model.AuthenticationToken;
import com.geekster.Doctors_App.model.Doctor;
import com.geekster.Doctors_App.model.Patient;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    IPatientRepo pr;

    @Autowired
    AuthenticationService as;

    @Autowired
    DoctorService ds;

    @Autowired
    AppointmentService appoints;

    public SignUpOutput signup(SignUpInput signupdto) {

        //check if user exist or not
        Patient patient=pr.findFirstByPatientEmail(signupdto.getUserEmail());
        if(patient!=null){
            throw new IllegalStateException("Patient already exist..!! sign in instead..");
        }
        //encrypt the password
        String encryptedPassword=null;
        try {
            encryptedPassword=encryptedPassword(signupdto.getUserPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //save the user
        patient=new Patient(signupdto.getUserFirstName(),signupdto.getUserLastName(),
                            signupdto.getUserEmail(),encryptedPassword,
                            signupdto.getUserContact());
        pr.save(patient);
        //generate the token
        AuthenticationToken token=new AuthenticationToken(patient);
        as.savetoken(token);
        return new SignUpOutput("patient registered","Patient created successfully");
    }

    private String encryptedPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5= MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] digested=md5.digest();
        String hash= DatatypeConverter.printHexBinary(digested);
        return hash;
    }

    public SignInOutput signin(SignInInput signindto) {
        //get email and password
        Patient patient=pr.findFirstByPatientEmail(signindto.getPatientEmail());
        if(patient==null){
            throw new IllegalStateException("User Invalid..!! sign up instead..");
        }
        //encrypt the password
        String encryptedPassword=null;
        try {
            encryptedPassword=encryptedPassword(signindto.getPatientPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //match with database password
       boolean isvalid=encryptedPassword.equals(patient.getPatientPassword());
        if(!isvalid){
            //dont want to help hacker which is incorrect
            throw new IllegalStateException("User Invalid..!! sign up instead..");
        }
        //figure out token
        AuthenticationToken authtoken=as.gettoken(patient);
        //set output response
        return new SignInOutput("Authentication successful",authtoken.getToken());
    }

    public List<Doctor> getalldoc() {
       return ds.getalldoc();
    }

    public void deleteappointment(AppointmentKey key) {
        appoints.deleteappointment(key);
    }
}
