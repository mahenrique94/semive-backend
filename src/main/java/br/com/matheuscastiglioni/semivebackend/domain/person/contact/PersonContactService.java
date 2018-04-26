package br.com.matheuscastiglioni.semivebackend.domain.person.contact;

import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.stereotype.Service;

@Service
public class PersonContactService extends GenericService<PersonContact, PersonContactRepository, Long> {

    public PersonContactService(PersonContactRepository repository) {
        super(repository);
    }

}
