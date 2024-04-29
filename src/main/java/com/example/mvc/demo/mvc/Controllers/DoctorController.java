package com.example.mvc.demo.mvc.Controllers;

import com.example.mvc.demo.mvc.Models.Appointment;
import com.example.mvc.demo.mvc.Models.AppointmentDto;
import com.example.mvc.demo.mvc.Models.Doctor;
import com.example.mvc.demo.mvc.Models.DoctorDto;
import com.example.mvc.demo.mvc.Repositories.AppointmentRepository;
import com.example.mvc.demo.mvc.Repositories.DoctorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/create")
    public String showcreateDoctor(Model model){
        DoctorDto doctorDto = new DoctorDto();
        model.addAttribute("doctorDto",doctorDto);
        return "doctors/CreateDoctor";
    }

    @PostMapping("/create")
    public String registerDoctor(@Valid @ModelAttribute DoctorDto doctorDto, BindingResult result){
        if (doctorDto.getName().equals("")) {
            result.addError(new FieldError("doctorDto", "name", ""));
        }

        if (result.hasErrors()) {
            return "doctors/CreateDoctor";
        }

        Doctor doctor = new Doctor();
        doctor.setName(doctorDto.getName());
        doctor.setTuition(doctorDto.getTuition());
        doctor.setCreated_At(LocalDate.now());

        doctorRepository.save(doctor);
        return "redirect:/appointments";
    }
}
