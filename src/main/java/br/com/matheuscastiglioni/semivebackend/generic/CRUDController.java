package br.com.matheuscastiglioni.semivebackend.generic;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CRUDController<T, PK> {

    ResponseEntity<Object> delete(PK id);
    ResponseEntity<Object> edit(PK id);
    ResponseEntity<List> list();
    ResponseEntity<Object> save(T t);
    ResponseEntity<Object> update(T t);

}
