package br.com.matheuscastiglioni.semivebackend.domain.person.definition;

import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.stereotype.Service;

@Service
public class PersonDefinitionService extends GenericService<PersonDefinition, PersonDefinitionRepository, Long> {

    public PersonDefinitionService(PersonDefinitionRepository repository) {
        super(repository);
    }

}
