package com.geekster.Doctors_App.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDateTime;
@Embeddable
public class AppointmentKey implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long appointmentId;
    public LocalDateTime time;
}