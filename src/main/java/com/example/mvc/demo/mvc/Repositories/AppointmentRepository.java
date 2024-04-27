package com.example.mvc.demo.mvc.Repositories;

import com.example.mvc.demo.mvc.Models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Override
    @Query("SELECT a FROM Appointment a order by a.appointment_date,a.appointment_time ASC")
    List<Appointment> findAll();
    List<Appointment> findAllBydoctorId(int id);

    @Query("SELECT a FROM Appointment a WHERE a.doctorId = :doctorId AND a.appointment_date = :date order by a.appointment_date,a.appointment_time ASC")
    List<Appointment> findAllByDoctorIdAndAppointmentDate(@Param("doctorId") int id, @Param("date") LocalDate date);

}
