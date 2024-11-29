package com.PoyectoKarolYSebastian.app.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotEmpty;

@Document(collection = "usuarios")
public class Vendedor {

	 @Id
	 private Long id;
	 
	 @NotEmpty
	 private String primernombre;
	 
	 @NotEmpty
	 private String segundonombre;
	    
	 @NotEmpty
	 private String primerapellido;
	    
	 @NotEmpty
	 private String segundoapellido;
	    
	 @NotEmpty
	 private String cedula;
	    
	 @NotEmpty
	 private String celular;
	    
	 @NotEmpty
	 private String direccion;
	    
	 @NotEmpty
	 private String usuario;
	    
	 @NotEmpty
	 private String contraseña;
	    
	 @NotEmpty
	 private String tipousuario;

	 
	 
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getPrimernombre() {
	        return primernombre;
	    }

	    public void setPrimernombre(String primernombre) {
	        this.primernombre = primernombre;
	    }

	    public String getSegundonombre() {
	        return segundonombre;
	    }

	    public void setSegundonombre(String segundonombre) {
	        this.segundonombre = segundonombre;
	    }

	    public String getPrimerapellido() {
	        return primerapellido;
	    }

	    public void setPrimerapellido(String primerapellido) {
	        this.primerapellido = primerapellido;
	    }

	    public String getSegundoapellido() {
	        return segundoapellido;
	    }

	    public void setSegundoapellido(String segundoapellido) {
	        this.segundoapellido = segundoapellido;
	    }

	    public String getCedula() {
	        return cedula;
	    }

	    public void setCedula(String cedula) {
	        this.cedula = cedula;
	    }

	    public String getCelular() {
	        return celular;
	    }

	    public void setCelular(String celular) {
	        this.celular = celular;
	    }
	    
	    public String getDireccion() {
	        return direccion;
	    }

	    public void setDireccion(String direccion) {
	        this.direccion = direccion;
	    }	    

	    public String getUsuario() {
	        return usuario;
	    }

	    public void setUsuario(String usuario) {
	        this.usuario = usuario;
	    }

	    public String getContraseña() {
	        return contraseña;
	    }

	    public void setContraseña(String contraseña) {
	        this.contraseña = contraseña;
	    }

	    public String getTipousuario() {
	        return tipousuario;
	    }

	    public void setTipousuario(String tipousuario) {
	        this.tipousuario = tipousuario;
	    }


}