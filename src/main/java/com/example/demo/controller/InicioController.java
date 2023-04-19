package com.example.demo.controller;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value={"/"},method = RequestMethod.GET)
public class InicioController {


    final UserRepository userRepository;

    public InicioController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping(value = {"/", "/inicio"})
    public String inicio() {
        return "inicio";
    }

    @PostMapping("/validarusuario")
    public String validarUsuario(Model model,@RequestParam("email") String email, @RequestParam("password") String password) {


        Optional<User> optUser = Optional.ofNullable((userRepository.buscarUsuario(email, password)));

        if (optUser.isPresent()) {
            User user1 = optUser.get();
            model.addAttribute("usuario", user1);
            return "homePage";
        } else {
            return "redirect:/inicio";
        }

    }
}
