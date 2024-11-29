package com.PoyectoKarolYSebastian.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PoyectoKarolYSebastian.app.service.LoginService;

@RestController
@RequestMapping("/api/login")
public class LoginRestController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public String login(@RequestParam String usuario, @RequestParam String contraseña) {
        String tipoUsuario = loginService.authenticate(usuario, contraseña);
        
        if (tipoUsuario == null) {
            return "Credenciales inválidas";
        }

        switch (tipoUsuario.toLowerCase()) {
            case "administrador":
                return "Redirigir a funciones de administrador";
            case "cliente":
                return "Redirigir a funciones de cliente";
            default:
                return "Tipo de usuario no reconocido";
        }
    }
}
