package com.PoyectoKarolYSebastian.app.controller;

import com.PoyectoKarolYSebastian.app.entidades.Producto;
import com.PoyectoKarolYSebastian.app.repository.CategoriaRepository;
import com.PoyectoKarolYSebastian.app.repository.ProductoRepository;
import com.PoyectoKarolYSebastian.app.repository.ProveedorRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/productos")
public class ProductoWebController {

    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private ProveedorRepository proveedorRepository;
    
    @Autowired
    private CategoriaRepository categoriaRepository;


    @GetMapping
    public String listarProductos(Model model, HttpSession session) {
        
        String tipoUsuario = (String) session.getAttribute("tipousuario");

        List<Producto> productos = productoRepository.findAll();

        model.addAttribute("listaProductos", productos);

        if ("administrador".equalsIgnoreCase(tipoUsuario)) {
            return "VerProductos";
        } else {
            return "VerProductosdos";
        }
    }
    
    @GetMapping("/crear")
    public String mostrarFormularioNuevoProducto(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("proveedor", proveedorRepository.findAll());
        model.addAttribute("categoria", categoriaRepository.findAll());
        return "formProductos";
    }
    
    @PostMapping("/guardar")
    public String guardarProducto(@Valid @ModelAttribute("producto") Producto producto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("proveedor", proveedorRepository.findAll()); 
            model.addAttribute("categoria", categoriaRepository.findAll());
            return "formProductos"; 
        }
        
        System.out.println("Proveedor ID: " + producto.getProveedor().getId());
        System.out.println("Categoría ID: " + producto.getCategoria().getId());

        productoRepository.save(producto);
        return "redirect:/productos"; 
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarProducto(@PathVariable("id") Long id, Model model) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()) {
            model.addAttribute("producto", productoOptional.get());
            model.addAttribute("proveedor", proveedorRepository.findAll());
            model.addAttribute("categoria", categoriaRepository.findAll());
            return "formProductos";
        } else {
            return "redirect:/productos";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
        }
        return "redirect:/productos";
    }
}