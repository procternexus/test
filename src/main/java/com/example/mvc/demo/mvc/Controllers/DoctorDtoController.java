package com.example.mvc.demo.mvc.Controllers;

import com.example.mvc.demo.mvc.Models.Doctor;
import com.example.mvc.demo.mvc.Repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorDtoController {

    @Autowired
    private DoctorRepository doctorRepository;


    @GetMapping("")
    public Optional<Doctor> getDoctor(@RequestParam int id){
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return doctor;
    }
}
