package com.example.demo.repositories;

import com.example.demo.models.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class ProdutoRepositoryImpl implements ProdutoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Produto save(Produto produto) {
        if (produto.getIdProduto() == null) {
            entityManager.persist(produto);
            return produto;
        } else {
            return entityManager.merge(produto);
        }
    }

    @Override
    public void deleteById(Integer id) {
        Produto produto = entityManager.find(Produto.class, id);
        if (produto != null) {
            entityManager.remove(produto);
        }
    }

    @Override
    public List<Produto> findAll() {
        return entityManager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }

    @Override
    public Optional<Produto> findById(Integer id) {
        Produto produto = entityManager.find(Produto.class, id);
        return Optional.ofNullable(produto);
    }
}
