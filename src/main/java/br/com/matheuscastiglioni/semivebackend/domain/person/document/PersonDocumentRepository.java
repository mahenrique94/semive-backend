package br.com.matheuscastiglioni.semivebackend.domain.person.document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "/person/document", path = "/person/document")
public interface PersonDocumentRepository extends JpaRepository<PersonDocument, Long> {
}
