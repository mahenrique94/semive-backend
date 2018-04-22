package br.com.matheuscastiglioni.semivebackend.domain.person.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "/person/contact", path = "/person/contact")
public interface PersonContactRepository extends JpaRepository<PersonContact, Long> {
}
