package com.geekster.Doctors_App.Repository;

import com.geekster.Doctors_App.model.AuthenticationToken;
import com.geekster.Doctors_App.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepo extends CrudRepository<AuthenticationToken,Long> {
    AuthenticationToken findByPatient(Patient patient);
}
