package br.com.matheuscastiglioni.semivebackend.domain.person;

import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends GenericService<Person, PersonRepository, Long> {

    public PersonService(PersonRepository repository) {
        super(repository);
    }
}
