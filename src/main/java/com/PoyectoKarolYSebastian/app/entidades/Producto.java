package com.PoyectoKarolYSebastian.app.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Document(collection = "Producto")
public class Producto {
	
	    @Id
	    private Long id;
	    
	    @NotEmpty
	    private String nombre;
	    
	    @DBRef(lazy = false)
	    private Categoria categoria;

	    @DBRef(lazy = false)
	    private Proveedor proveedor;
	    
	    @Positive
	    private double precioCompra;
	    
	    @Positive
	    private double precioVenta;
	    
	    @NotNull
	    @Min(0)
	    private int stock;
	    
	    public Proveedor getProveedor() {
	        return proveedor;
	    }

	    public void setProveedor(Proveedor proveedor) {
	        this.proveedor = proveedor;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }
	    
	    public Categoria getCategoria() {
	        return categoria;
	    }

	    public void setCategoria(Categoria categoria) {
	        this.categoria = categoria;
	    }

	    public double getPrecioCompra() {
	        return precioCompra;
	    }

	    public void setPrecioCompra(double precioCompra) {
	        this.precioCompra = precioCompra;
	    }

	    public double getPrecioVenta() {
	        return precioVenta;
	    }

	    public void setPrecioVenta(double precioVenta) {
	        this.precioVenta = precioVenta;
	    }

	    public int getStock() {
	        return stock;
	    }

	    public void setStock(int stock) {
	        this.stock = stock;
	    }

	}
