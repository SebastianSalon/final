package com.PoyectoKarolYSebastian.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PoyectoKarolYSebastian.app.entidades.usuario;
import com.PoyectoKarolYSebastian.app.repository.UsuarioRepository;

@Service
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String authenticate(String Usuario, String contraseña) {
        return usuarioRepository.findByUsuarioAndContraseña(Usuario, contraseña)
            .map(usuario::getTipousuario)
            .orElse(null); 
    }
}
