package br.com.matheuscastiglioni.semivebackend.domain.person.definition;

import br.com.matheuscastiglioni.semivebackend.domain.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonDefinitionRepository extends JpaRepository<PersonDefinition, Long> {

    List<PersonDefinition> findByIdPerson(Person person);

}
