package com.example.demo;

import com.example.demo.models.Categoria;
import com.example.demo.models.Produto;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ac1ProjetoApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public static void main(String[] args) {
        SpringApplication.run(Ac1ProjetoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria();
        cat1.setCatNome("Eletrônicos");
        cat1.setCatDescricao("Produtos eletrônicos diversos");

        Categoria cat2 = new Categoria();
        cat2.setCatNome("Alimentos");
        cat2.setCatDescricao("Produtos alimentícios");

        categoriaRepository.save(cat1);
        categoriaRepository.save(cat2);

        Produto prod1 = new Produto();
        prod1.setProdNome("Smartphone");
        prod1.setProdQtd(50);
        prod1.setCategoria(cat1);

        Produto prod2 = new Produto();
        prod2.setProdNome("Arroz");
        prod2.setProdQtd(100);
        prod2.setCategoria(cat2);

        produtoRepository.save(prod1);
        produtoRepository.save(prod2);

        System.out.println("Categorias:");
        categoriaRepository.findAll().forEach(System.out::println);

        System.out.println("Produtos:");
        produtoRepository.findAll().forEach(System.out::println);
    }
}
