package com.PoyectoKarolYSebastian.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.PoyectoKarolYSebastian.app.entidades.Citas;
import com.PoyectoKarolYSebastian.app.repository.CitasRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login/citas")
public class CitasRestController {

	@PostMapping("/guardar")
	public String guardarCita(@ModelAttribute Citas cita) {
	   
	    return "redirect:/productos";
    
}
}