package br.com.matheuscastiglioni.semivebackend.domain.document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "/document/type", path = "/document/type")
public interface DocumentTypeRepository extends JpaRepository<DocumentType, Integer> {
}
