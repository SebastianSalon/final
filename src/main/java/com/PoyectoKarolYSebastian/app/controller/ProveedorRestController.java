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

import com.PoyectoKarolYSebastian.app.entidades.Proveedor;
import com.PoyectoKarolYSebastian.app.repository.ProveedorRepository;

@RestController
@RequestMapping("/login/proveedor")
public class ProveedorRestController {
	
	  @Autowired
	    private ProveedorRepository proveedorRepository;
	    
	    @GetMapping
	    public List<Proveedor> proveedores() {
	        return proveedorRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Proveedor> obtenerProveedor(@PathVariable Long id) {
	        return proveedorRepository.findById(id)
	                .map(Proveedor -> ResponseEntity.ok(Proveedor))
	                .orElse(ResponseEntity.notFound().build());
	    }
	    
	    @PostMapping
	    public Proveedor guardarProveedor(@RequestBody Proveedor proveedor) {
	        return proveedorRepository.save(proveedor);
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Long id, @RequestBody Proveedor proveedorDetails) {
	        return proveedorRepository.findById(id)
	                .map(proveedor -> {
	                	proveedor.setNombre(proveedorDetails.getNombre());
	                	proveedor.setTelefono(proveedorDetails.getTelefono());
	                    proveedor.setDireccion(proveedorDetails.getDireccion());
	                    proveedor.setEmail(proveedorDetails.getEmail());
	                    proveedor.setEstado(proveedorDetails.getEmail());
	                    Proveedor proveedorActualizado = proveedorRepository.save(proveedor);
	                    return ResponseEntity.ok(proveedorActualizado);
	                    
	                })
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> eliminarProveedor(@PathVariable Long id) {
	        if (proveedorRepository.existsById(id)) {
	            proveedorRepository.deleteById(id);
	            return ResponseEntity.ok().build();
	        }
	        return ResponseEntity.notFound().build();
	    }
	    

}
