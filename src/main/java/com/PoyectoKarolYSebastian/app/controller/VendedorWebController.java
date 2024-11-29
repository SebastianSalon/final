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

import com.PoyectoKarolYSebastian.app.entidades.Vendedor;
import com.PoyectoKarolYSebastian.app.repository.VendedorRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/empleados")
public class VendedorWebController {

    @Autowired
    private VendedorRepository vendedorRepository;
 

    @GetMapping
    public String listarVendedor(Model model) {
        List<Vendedor> vendedor = vendedorRepository.findAll();
        
        model.addAttribute("obtenerVendedor", vendedor);
        return "VerVendedor";
    }
    
    
    @GetMapping("/crear")
    public String mostrarFormularioNuevoVendedor(Model model) {
        model.addAttribute("vendedor", new Vendedor());
        return "FormVendedor";
    }
    
    @PostMapping("/guardar")
    public String guardarVendedor(@Valid @ModelAttribute("vendedor") Vendedor vendedor, BindingResult result, Model model) {
       
        if (result.hasErrors()) {
            return "FormVendedor";
        }
        if (vendedor.getId() == null) {
            Long nuevoId = vendedorRepository.findAll().stream()
                                            .mapToLong(Vendedor::getId)
                                            .max()
                                            .orElse(0L) + 1;
            vendedor.setId(nuevoId);
        }
        vendedorRepository.save(vendedor);
        return "redirect:/empleados"; 
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarVendedor(@PathVariable("id") Long id, Model model) {
        Optional<Vendedor> vendedorOptional = vendedorRepository.findById(id);
        if (vendedorOptional.isPresent()) {
            model.addAttribute("vendedor", vendedorOptional.get());
            return "FormVendedor";
        } else {
            return "redirect:/empleados";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarVendedor(@PathVariable("id") Long id) {
        if (vendedorRepository.existsById(id)) {
            vendedorRepository.deleteById(id);
        }
        return "redirect:/empleados";
    }
    
}
