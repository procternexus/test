package com.example.mvc.demo.mvc.Models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDto {

    @NotEmpty(message = "The doctor is required")
    private String doctorId;


    @NotNull(message = "The date is required")
    private LocalDate appointmentDate;

    @NotNull(message = "The time is required")
    private LocalTime appointmentTime;

    @NotEmpty(message = "The patient name is required")
    private String patient;

    @NotEmpty(message = "The patient email is required")
    private String patientEmail;

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }
}
