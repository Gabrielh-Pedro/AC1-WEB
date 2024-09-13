package com.example.demo.repositories;

import com.example.demo.models.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class CategoriaRepositoryImpl implements CategoriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Categoria save(Categoria categoria) {
        if (categoria.getIdCategoria() == null) {
            entityManager.persist(categoria);
            return categoria;
        } else {
            return entityManager.merge(categoria);
        }
    }

    @Override
    public void deleteById(Integer id) {
        Categoria categoria = entityManager.find(Categoria.class, id);
        if (categoria != null) {
            entityManager.remove(categoria);
        }
    }

    @Override
    public List<Categoria> findAll() {
        return entityManager.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
    }

    @Override
    public Optional<Categoria> findById(Integer id) {
        Categoria categoria = entityManager.find(Categoria.class, id);
        return Optional.ofNullable(categoria);
    }
}
