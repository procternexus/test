package com.example.mvc.demo.mvc.Controllers;

import com.example.mvc.demo.mvc.Models.*;
import com.example.mvc.demo.mvc.Repositories.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping({"","/"})
    public String getAppointment(Model model){
        List<Appointment> appointments = appointmentRepository.findAll();
        List<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("appointments",appointments);
        model.addAttribute("doctors",doctors);
        return "appointments/index";
    }


    @GetMapping("/create")
    public String showcreateAppointment(Model model){
        AppointmentDto appointmentDto = new AppointmentDto();
        List<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("appointmentDto",appointmentDto);
        model.addAttribute("doctors",doctors);
        return "appointments/CreateAppointment";
    }

    @PostMapping("/create")
    public String registerAppointment(@Valid @ModelAttribute AppointmentDto appointmentDto, BindingResult result, Model model){
        if (appointmentDto.getAppointmentTime() == null) {
            result.addError(new FieldError("appointmentDto", "appointmentTime", ""));
        }

        if (result.hasErrors()) {
            List<Doctor> doctors = doctorRepository.findAll();
            model.addAttribute("doctors",doctors);
            return "appointments/CreateAppointment";
        }

        Appointment appointment = new Appointment();
        appointment.setDoctorId(Integer.parseInt(appointmentDto.getDoctorId()));
        appointment.setAppointment_date(appointmentDto.getAppointmentDate());
        appointment.setAppointment_time(appointmentDto.getAppointmentTime());
        appointment.setPatient(appointmentDto.getPatient());
        appointment.setEmail(appointmentDto.getPatientEmail());

        appointmentRepository.save(appointment);
        return "redirect:/appointments";
    }
}
