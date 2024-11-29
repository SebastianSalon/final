package com.PoyectoKarolYSebastian.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.PoyectoKarolYSebastian.app.entidades.Citas;
import com.PoyectoKarolYSebastian.app.entidades.Producto;

import ch.qos.logback.core.model.Model;

@Controller
public class CitasWebController {
	
    @GetMapping("/crearCitas")
    public String crearCitas() {
        return "crearCitas"; // Sin extensión
    }

    @GetMapping("/verCitas")
    public String verCitas() {
        return "verCitas"; // Sin extensión
    }
}
   
    
