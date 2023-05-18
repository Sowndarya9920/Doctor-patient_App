package com.geekster.Doctors_App.Repository;

import com.geekster.Doctors_App.model.Appointment;
import com.geekster.Doctors_App.model.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDoctorRepo extends CrudRepository<Doctor,Long> {

    Doctor findByDoctorId(Long id);
}
