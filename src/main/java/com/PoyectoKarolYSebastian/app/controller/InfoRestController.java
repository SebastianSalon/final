package com.PoyectoKarolYSebastian.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PoyectoKarolYSebastian.app.repository.ClienteRepository;

@RestController
@RequestMapping("/api/VerInfo")
public class InfoRestController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public Object obtenerInfoUsuario(@RequestParam String usuario) {
        var cliente = clienteRepository.findByUsuario(usuario);

        if (cliente.isPresent()) {
            return cliente.get(); // Devuelve la información del cliente como JSON
        } else {
            return "Usuario no encontrado.";
        }
    }
}