package br.com.matheuscastiglioni.semivebackend.generic;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class GenericController<T, Service extends CRUDService, PK> implements CRUDController<T, PK> {

    private final Service service;

    public GenericController(Service service) {
        this.service = service;
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") PK id) {
        try {
            this.service.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<Object> edit(@PathVariable("id") PK id) {
        try {
            Object obj = this.service.edit(id);
            return ResponseEntity.ok(obj);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<List> list() {
        return ResponseEntity.ok(this.service.list());
    }

    @Override
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody T t) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(t));
    }

    @Override
    @PutMapping
    public ResponseEntity<Object> update(@RequestBody T t) {
        return ResponseEntity.ok(this.service.update(t));
    }

}
