package com.example.mvc.demo.mvc.Controllers;

import com.example.mvc.demo.mvc.Repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;

@RestController
@RequestMapping("/appointment")
public class AppointmentDtoController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("")
    public Object getAppoitnment (@RequestParam int id,LocalDate date){
        return appointmentRepository.findAllByDoctorIdAndAppointmentDate(id, LocalDate.from(date));
    }

}
