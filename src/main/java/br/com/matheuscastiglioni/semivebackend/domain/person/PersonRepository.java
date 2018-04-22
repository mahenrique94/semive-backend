package br.com.matheuscastiglioni.semivebackend.domain.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "/person", path = "/person")
public interface PersonRepository extends JpaRepository<Person, Long> {
}
