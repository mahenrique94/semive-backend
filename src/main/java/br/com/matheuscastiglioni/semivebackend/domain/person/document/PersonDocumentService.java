package br.com.matheuscastiglioni.semivebackend.domain.person.document;

import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.stereotype.Service;

@Service
public class PersonDocumentService extends GenericService<PersonDocument, PersonDocumentRepository, Long> {

    public PersonDocumentService(PersonDocumentRepository repository) {
        super(repository);
    }

}
