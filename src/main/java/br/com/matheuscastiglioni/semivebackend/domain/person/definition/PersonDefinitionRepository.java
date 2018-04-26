package br.com.matheuscastiglioni.semivebackend.domain.person.definition;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDefinitionRepository extends JpaRepository<PersonDefinition, Long> {
}
