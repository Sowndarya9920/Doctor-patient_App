package com.geekster.Doctors_App.Repository;

import com.geekster.Doctors_App.model.Appointment;
import com.geekster.Doctors_App.model.AppointmentKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRepo extends CrudRepository<Appointment,AppointmentKey> {
}
