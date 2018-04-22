package br.com.matheuscastiglioni.semivebackend.domain.person.definition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "/person/definition", path = "/person/definition")
public interface PersonDefinitionRepository extends JpaRepository<PersonDefinition, Long> {
}
