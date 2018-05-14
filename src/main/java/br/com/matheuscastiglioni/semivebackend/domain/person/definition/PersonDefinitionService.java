package br.com.matheuscastiglioni.semivebackend.domain.person.definition;

import br.com.matheuscastiglioni.semivebackend.domain.person.Person;
import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonDefinitionService extends GenericService<PersonDefinition, PersonDefinitionRepository, Long> {

    private final PersonDefinitionRepository personDefinitionRepository;

    @Autowired
    public PersonDefinitionService(PersonDefinitionRepository repository) {
        super(repository);
        this.personDefinitionRepository = repository;
    }

    public List<PersonDefinition> listByIdPerson(Long idPerson) {
        return this.personDefinitionRepository.findByIdPerson(new Person(idPerson));
    }

}
