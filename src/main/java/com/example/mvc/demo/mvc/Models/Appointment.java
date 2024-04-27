package com.example.mvc.demo.mvc.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "doctorId")
    private int doctorId;
    private LocalDate appointment_date;
    private LocalTime appointment_time;
    private String patient;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(LocalDate appointment_date) {
        this.appointment_date = appointment_date;
    }

    public LocalTime getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(LocalTime appointment_time) {
        this.appointment_time = appointment_time;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
