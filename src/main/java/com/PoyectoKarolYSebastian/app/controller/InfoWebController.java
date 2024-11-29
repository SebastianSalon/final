package com.PoyectoKarolYSebastian.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.PoyectoKarolYSebastian.app.repository.ClienteRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class InfoWebController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/verInfo")
    public String verInfoUsuario(HttpSession session, Model model) {
        
        String usuario = (String) session.getAttribute("usuario");

        if (usuario == null) {
            model.addAttribute("error", "Debe iniciar sesión primero.");
            return "index"; 
        }

        
        var cliente = clienteRepository.findByUsuario(usuario);

        if (cliente.isPresent()) {
            model.addAttribute("cliente", cliente.get());
            return "verInfo"; 
        } else {
            model.addAttribute("error", "Usuario no encontrado.");
            return "error"; 
        }
    }
}
