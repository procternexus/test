package com.example.mvc.demo.mvc.Controllers;


import com.example.mvc.demo.mvc.Models.*;
import com.example.mvc.demo.mvc.Repositories.UserRepository;
import com.example.mvc.demo.mvc.Security.SessionManager;
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

@Controller
@RequestMapping(path = "/login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String loginGet(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "Login/login";
    }
    @PostMapping("")
    public String loginUser(@Valid @ModelAttribute UserDto userDto, BindingResult result){
        if(userDto.getName()==null){
            result.addError(new FieldError("userDto","name",""));
        }
        if(result.hasErrors()){
            return "Login/login";
        }
        User user = userRepository.findByName(userDto.getName());
        if(user!=null){
            user.setStatus(1);
            userRepository.save(user);
            SessionManager sessionManager = SessionManager.getInstance();
            sessionManager.setAttribute("name",user.getName());
            return "redirect:/appointments";
        }else{
            result.addError(new FieldError("userDto","name","user not exists"));
            return "Login/login";
        }


    }
}
