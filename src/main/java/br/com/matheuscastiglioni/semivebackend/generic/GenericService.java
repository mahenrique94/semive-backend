package br.com.matheuscastiglioni.semivebackend.generic;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class GenericService<T, Repository extends JpaRepository, PK> implements CRUDService<T, PK> {

    private final JpaRepository repository;

    public GenericService(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void delete(PK id) {
        if (!this.repository.existsById(id)) {
            throw new EmptyResultDataAccessException("Entity not found to delete", 0);
        }
        this.repository.deleteById(id);
    }

    @Override
    public T edit(PK id) {
        if (!this.repository.existsById(id)) {
            throw new EmptyResultDataAccessException("Entity not found to edit", 0);
        }
        return (T) this.repository.findById(id);
    }

    @Override
    public List<T> list() {
        return this.repository.findAll();
    }

    @Override
    public T save(T t) {
        return (T) this.repository.save(t);
    }

    @Override
    public T update(T t) {
        return this.save(t);
    }

}
