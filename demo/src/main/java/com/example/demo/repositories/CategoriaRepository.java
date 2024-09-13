package com.example.demo.repositories;

import com.example.demo.models.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository {
    Categoria save(Categoria categoria);
    void deleteById(Integer id);
    List<Categoria> findAll();
    Optional<Categoria> findById(Integer id);
}
