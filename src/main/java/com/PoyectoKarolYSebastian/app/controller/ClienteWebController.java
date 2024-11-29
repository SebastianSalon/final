package com.PoyectoKarolYSebastian.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.PoyectoKarolYSebastian.app.entidades.Cliente;
import com.PoyectoKarolYSebastian.app.repository.ClienteRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/clientes")
public class ClienteWebController {
	
    @Autowired
    private ClienteRepository clienteRepository;
 

    @GetMapping
    public String listarProductos(Model model, HttpSession session) {
    	
        String tipoUsuario = (String) session.getAttribute("tipousuario");
        List<Cliente> cliente = clienteRepository.findAll();
        
        model.addAttribute("obtenerClientes", cliente);
        
        if ("administrador".equalsIgnoreCase(tipoUsuario) || "vendedor".equalsIgnoreCase(tipoUsuario)) {
            return "VerCliente";
        } else {
            return "VerClientedos";
        }
        //return "VerCliente";
    }
    
    
    @GetMapping("/crear")
    public String mostrarFormularioNuevoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "FormCliente";
    }
    
    @PostMapping("/guardar")
    public String guardarCliente(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result, Model model) {
       
        if (result.hasErrors()) {
            return "FormCliente";
        }
        if (cliente.getId() == null) {
            Long nuevoId = clienteRepository.findAll().stream()
                                            .mapToLong(Cliente::getId)
                                            .max()
                                            .orElse(0L) + 1;
            cliente.setId(nuevoId);
        }
        clienteRepository.save(cliente);
        return "redirect:/clientes"; 
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarCliente(@PathVariable("id") Long id, Model model) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            model.addAttribute("cliente", clienteOptional.get());
            return "FormCliente";
        } else {
            return "redirect:/clientes";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable("id") Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        }
        return "redirect:/clientes";
    }
    
}