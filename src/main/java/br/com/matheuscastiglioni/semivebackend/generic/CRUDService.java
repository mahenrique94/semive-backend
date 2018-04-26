package br.com.matheuscastiglioni.semivebackend.generic;

import java.util.List;

public interface CRUDService<T, PK> {

    void delete(PK id);
    T edit(PK id);
    List<T> list();
    T save(T t);
    T update(T t);

}
