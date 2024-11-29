package com.PoyectoKarolYSebastian.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.PoyectoKarolYSebastian.app.entidades.Proveedor;
import com.PoyectoKarolYSebastian.app.repository.ProveedorRepository;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/proveedor")
public class ProveedorWebController {

    
    @Autowired
    private ProveedorRepository proveedorRepository;


    @GetMapping
    public String listarProveedores(Model model) {
        List<Proveedor> proveedores = proveedorRepository.findAll();
       
        model.addAttribute("proveedores", proveedores);
        return "VerProveedor";
    }
    
    @GetMapping("/crear")
    public String mostrarFormularioNuevoProveedor(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "FormProveedor";
    }
    
    @PostMapping("/guardar")
    public String guardarProveedor(@Valid @ModelAttribute("proveedor") Proveedor proveedor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "FormProveedor"; 
        }
        proveedorRepository.save(proveedor);
        return "redirect:/proveedor"; 
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarProveedor(@PathVariable("id") Long id, Model model) {
        Optional<Proveedor> proveedorOptional = proveedorRepository.findById(id);
        if (proveedorOptional.isPresent()) {
            model.addAttribute("proveedor", proveedorOptional.get());
            return "FormProveedor";
        } else {
            return "redirect:/proveedor";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProveedor(@PathVariable("id") Long id) {
        if (proveedorRepository.existsById(id)) {
            proveedorRepository.deleteById(id);
        }
        return "redirect:/proveedor";
    }

}
