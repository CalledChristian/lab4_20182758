package com.example.demo.controller;

import com.example.demo.entities.User;
import com.example.demo.entities.Vuelo;
import com.example.demo.repository.ReservaRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VueloRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value={"/"},method = RequestMethod.GET)
public class InicioController {


    final UserRepository userRepository;
    final VueloRepository vueloRepository;

    final ReservaRepository reservaRepository;

    public InicioController(ReservaRepository reservaRepository,UserRepository userRepository,VueloRepository vueloRepository) {

        this.userRepository = userRepository;
        this.vueloRepository = vueloRepository;
        this.reservaRepository=reservaRepository;
    }


    @GetMapping(value = {"/", "/inicio"})
    public String inicio() {
        return "inicio";
    }

    @PostMapping("/validarusuario")
    public String validarUsuario(RedirectAttributes redirectAttributes,@RequestParam("email") String email, @RequestParam("password") String password) {


        Optional<User> optUser = Optional.ofNullable(userRepository.buscarUsuario(email, password));

        if (optUser.isPresent()) {
            User user1 = optUser.get();
            redirectAttributes.addAttribute("iduser",user1.getIdUser());
            return "redirect:/home";
        } else {
            return "redirect:/inicio";
        }
    }

    @GetMapping("/home")
    public String home(Model model,@RequestParam("iduser") int idUsuario){
        model.addAttribute("usuario", userRepository.findById(idUsuario).get());
        List<Vuelo> listaVuelos1 = vueloRepository.findAll();
        model.addAttribute("listaVuelos",listaVuelos1);
        return "homePage";
    }

    @PostMapping(value = "/reservarvuelo")
    @Transactional
    public String reservar(@RequestParam("idvuelo") Integer idVuelo, @RequestParam("iduser") Integer idUsuario, @RequestParam("precio") Float precio, RedirectAttributes redirectAttributes){
        reservaRepository.reservar(precio,idUsuario,idVuelo);
        redirectAttributes.addAttribute("iduser", idUsuario);
        return "redirect:/home";
    }


}
