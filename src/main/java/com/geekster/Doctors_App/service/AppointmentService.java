package com.geekster.Doctors_App.service;

import com.geekster.Doctors_App.Repository.IAppointmentRepo;
import com.geekster.Doctors_App.model.Appointment;
import com.geekster.Doctors_App.model.AppointmentKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    @Autowired
    IAppointmentRepo ar;

    public void bookappointment(Appointment appoint) {
        ar.save(appoint);
    }

    public void deleteappointment(AppointmentKey key) {
        ar.deleteById(key);
    }
}
