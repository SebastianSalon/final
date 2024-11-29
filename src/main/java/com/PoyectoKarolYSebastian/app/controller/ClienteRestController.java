package com.PoyectoKarolYSebastian.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PoyectoKarolYSebastian.app.entidades.Cliente;
import com.PoyectoKarolYSebastian.app.repository.ClienteRepository;

@RestController
@RequestMapping("/login/clientes")
public class ClienteRestController {
    
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientes(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(Cliente -> ResponseEntity.ok(Cliente))
                .orElse(ResponseEntity.notFound().build());
    }
    
    
    @PostMapping
    public Cliente guardarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteDetails) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                	cliente.setPrimernombre(clienteDetails.getPrimernombre());
                	cliente.setSegundonombre(clienteDetails.getSegundonombre());
                	cliente.setPrimerapellido(clienteDetails.getPrimerapellido());
                	cliente.setSegundoapellido(clienteDetails.getSegundoapellido());
                	cliente.setCedula(clienteDetails.getCedula());
                	cliente.setCelular(clienteDetails.getCelular());
                	cliente.setUsuario(clienteDetails.getUsuario());
                	cliente.setContraseña(clienteDetails.getContraseña());
                	cliente.setTipousuario(clienteDetails.getTipousuario());
                	cliente.setDireccion(clienteDetails.getDireccion());
                	Cliente clienteActualizado = clienteRepository.save(cliente);
                    return ResponseEntity.ok(clienteActualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}