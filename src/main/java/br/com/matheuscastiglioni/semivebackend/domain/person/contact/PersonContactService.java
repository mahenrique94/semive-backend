package br.com.matheuscastiglioni.semivebackend.domain.person.contact;

import br.com.matheuscastiglioni.semivebackend.domain.person.Person;
import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonContactService extends GenericService<PersonContact, PersonContactRepository, Long> {

    private final PersonContactRepository personContactRepository;

    @Autowired
    public PersonContactService(PersonContactRepository repository) {
        super(repository);
        this.personContactRepository = repository;
    }

    public List<PersonContact> listByIdPerson(Long idPerson) {
        return this.personContactRepository.findByIdPerson(new Person(idPerson));
    }

}
