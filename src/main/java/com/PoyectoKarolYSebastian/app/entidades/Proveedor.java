package com.PoyectoKarolYSebastian.app.entidades;

	import org.springframework.data.annotation.Id;
	import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotEmpty;

	@Document(collection = "Proveedor")
	public class Proveedor {
	    
		@Id
	    private Long id;
		
		@NotEmpty
	    private String nombre;
		
		@NotEmpty
		
		private String telefono;
		
		@NotEmpty
	    private String direccion;
		
		@NotEmpty
		private String email;
		
		@NotEmpty
		private String estado;

		
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
	    
	    public String getTelefono() {
	        return telefono;
	    }

	    public void setTelefono(String telefono) {
	        this.telefono = telefono;
	    }

	    public String getDireccion() {
	        return direccion;
	    }

	    public void setDireccion(String direccion) {
	        this.direccion = direccion;
	    }
	    
	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }
	    
	    public String getEstado() {
	        return estado;
	    }

	    public void setEstado(String estado) {
	        this.estado = estado;
	    }
	}
