package com.geekster.Doctors_App.service;

import com.geekster.Doctors_App.Repository.IAppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    @Autowired
    IAppointmentRepo ar;

}
