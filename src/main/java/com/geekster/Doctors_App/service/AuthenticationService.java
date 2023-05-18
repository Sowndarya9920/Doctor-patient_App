package com.geekster.Doctors_App.service;

import com.geekster.Doctors_App.Repository.IAuthenticationRepo;
import com.geekster.Doctors_App.model.AuthenticationToken;
import com.geekster.Doctors_App.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    IAuthenticationRepo ar;

    public void savetoken(AuthenticationToken token){
        ar.save(token);
    }

    public AuthenticationToken gettoken(Patient patient) {

       return ar.findByPatient(patient);
    }

    public boolean authenticate(String userEmail, String token) {
       AuthenticationToken authtoken= ar.findFirstByToken(token);
       String expectedemail=authtoken.getPatient().getPatientEmail();
       return expectedemail.equals(userEmail);
    }
}
