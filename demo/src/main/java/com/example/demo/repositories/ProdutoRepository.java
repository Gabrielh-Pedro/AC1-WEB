package com.example.demo.repositories;

import com.example.demo.models.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {
    Produto save(Produto produto);
    void deleteById(Integer id);
    List<Produto> findAll();
    Optional<Produto> findById(Integer id);
}
