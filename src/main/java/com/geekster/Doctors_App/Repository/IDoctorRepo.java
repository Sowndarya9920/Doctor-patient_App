package com.geekster.Doctors_App.Repository;

import com.geekster.Doctors_App.model.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoctorRepo extends CrudRepository<Doctor,Long> {
}
