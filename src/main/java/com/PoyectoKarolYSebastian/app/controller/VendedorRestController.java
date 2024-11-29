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

import com.PoyectoKarolYSebastian.app.entidades.Vendedor;
import com.PoyectoKarolYSebastian.app.repository.VendedorRepository;

public class VendedorRestController {

    @Autowired
    private VendedorRepository vendedorRepository;

    @GetMapping
    public List<Vendedor> obtenerVendedor() {
        return vendedorRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> obtenerVendedor(@PathVariable Long id) {
        return vendedorRepository.findById(id)
                .map(Vendedor -> ResponseEntity.ok(Vendedor))
                .orElse(ResponseEntity.notFound().build());
    }
    
    
    @PostMapping
    public Vendedor guardarVendedor(@RequestBody Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Vendedor> actualizarVendedor(@PathVariable Long id, @RequestBody Vendedor vendedorDetails) {
        return vendedorRepository.findById(id)
                .map(vendedor -> {
                	vendedor.setPrimernombre(vendedorDetails.getPrimernombre());
                	vendedor.setSegundonombre(vendedorDetails.getSegundonombre());
                	vendedor.setPrimerapellido(vendedorDetails.getPrimerapellido());
                	vendedor.setSegundoapellido(vendedorDetails.getSegundoapellido());
                	vendedor.setCedula(vendedorDetails.getCedula());
                	vendedor.setCelular(vendedorDetails.getCelular());
                	vendedor.setUsuario(vendedorDetails.getUsuario());
                	vendedor.setContraseña(vendedorDetails.getContraseña());
                	vendedor.setTipousuario(vendedorDetails.getTipousuario());
                	vendedor.setDireccion(vendedorDetails.getDireccion());
                	Vendedor clienteActualizado = vendedorRepository.save(vendedor);
                    return ResponseEntity.ok(clienteActualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVendedor(@PathVariable Long id) {
        if (vendedorRepository.existsById(id)) {
            vendedorRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
