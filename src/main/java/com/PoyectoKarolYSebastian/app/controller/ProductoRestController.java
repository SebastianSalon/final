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

import com.PoyectoKarolYSebastian.app.entidades.Producto;
import com.PoyectoKarolYSebastian.app.repository.ProductoRepository;


@RestController
@RequestMapping("/login/productos")
public class ProductoRestController {
	
	  @Autowired
	    private ProductoRepository productoRepository;
	    
	    @GetMapping
	    public List<Producto> listaProductos() {
	        return productoRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Producto> obtenerProducto(@PathVariable Long id) {
	        return productoRepository.findById(id)
	                .map(Producto -> ResponseEntity.ok(Producto))
	                .orElse(ResponseEntity.notFound().build());
	    }
	    
	    @PostMapping
	    public Producto guardarProducto(@RequestBody Producto producto) {
	        return productoRepository.save(producto);
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto productoDetails) {
	        return productoRepository.findById(id)
	                .map(producto -> {
	                    producto.setNombre(productoDetails.getNombre());
	                    producto.setProveedor(productoDetails.getProveedor());
	                    producto.setCategoria(productoDetails.getCategoria());
	                    producto.setPrecioCompra(productoDetails.getPrecioCompra());
	                    producto.setPrecioVenta(productoDetails.getPrecioVenta());
	                    producto.setStock(productoDetails.getStock());
	                    Producto productoActualizado = productoRepository.save(producto);
	                    return ResponseEntity.ok(productoActualizado);
	                })
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
	        if (productoRepository.existsById(id)) {
	            productoRepository.deleteById(id);
	            return ResponseEntity.ok().build();
	        }
	        return ResponseEntity.notFound().build();
	    }
	}

