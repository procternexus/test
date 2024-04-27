package com.example.mvc.demo.mvc.Repositories;

import com.example.mvc.demo.mvc.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
