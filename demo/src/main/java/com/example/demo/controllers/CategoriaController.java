package com.example.demo.controllers;

import com.example.demo.models.Categoria;
import com.example.demo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public Categoria adicionarCategoria(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Categoria buscarCategoriaPorId(@PathVariable Integer id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletarCategoria(@PathVariable Integer id) {
        categoriaRepository.deleteById(id);
    }
}
