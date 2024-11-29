package com.PoyectoKarolYSebastian.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.PoyectoKarolYSebastian.app.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginWebController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public String showLoginForm() {
        return "index"; 
    }
    
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; 
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String usuario, @RequestParam String contraseña, HttpSession session) {
        String tipoUsuario = loginService.authenticate(usuario, contraseña);
        ModelAndView modelAndView = new ModelAndView();

        if (tipoUsuario == null) {
            modelAndView.setViewName("index"); 
            modelAndView.addObject("error", "Credenciales inválidas");
            return modelAndView;
        }
        
        session.setAttribute("usuario", usuario);
        
        session.setAttribute("tipousuario", tipoUsuario);

        switch (tipoUsuario.toLowerCase()) {
        case "administrador":
            modelAndView.setViewName("admin");
            modelAndView.addObject("mensaje", "Hola Administrador");
            break;
        case "cliente":
            modelAndView.setViewName("cliente");
            modelAndView.addObject("mensaje", "Hola Cliente");
            break;
        case "instalador":
            modelAndView.setViewName("insta");
            modelAndView.addObject("mensaje", "Hola Instalador");
            break;
        case "vendedor":
            modelAndView.setViewName("vendedor");
            modelAndView.addObject("mensaje", "Hola Vendedor");
            break;
        default:
            modelAndView.setViewName("index");
            modelAndView.addObject("error", "Tipo de usuario no reconocido");
            break;
    }
		return modelAndView;
    }
}