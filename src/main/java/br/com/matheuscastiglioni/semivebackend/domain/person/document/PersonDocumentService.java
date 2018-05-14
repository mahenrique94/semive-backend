package br.com.matheuscastiglioni.semivebackend.domain.person.document;

import br.com.matheuscastiglioni.semivebackend.domain.person.Person;
import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonDocumentService extends GenericService<PersonDocument, PersonDocumentRepository, Long> {

    private final PersonDocumentRepository personDocumentRepository;

    @Autowired
    public PersonDocumentService(PersonDocumentRepository repository) {
        super(repository);
        this.personDocumentRepository = repository;
    }

    public List<PersonDocument> listByIdPerson(Long idPerson) {
        return this.personDocumentRepository.findByIdPerson(new Person(idPerson));
    }

}
