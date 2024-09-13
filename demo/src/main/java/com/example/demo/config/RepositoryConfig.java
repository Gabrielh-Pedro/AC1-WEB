package com.example.demo.config;

import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.CategoriaRepositoryImpl;
import com.example.demo.repositories.ProdutoRepository;
import com.example.demo.repositories.ProdutoRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public CategoriaRepository categoriaRepository() {
        return new CategoriaRepositoryImpl();
    }

    @Bean
    public ProdutoRepository produtoRepository() {
        return new ProdutoRepositoryImpl();
    }
}
