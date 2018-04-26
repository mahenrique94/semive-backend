package br.com.matheuscastiglioni.semivebackend.domain.person.document;

import br.com.matheuscastiglioni.semivebackend.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person/document")
public class PersonDocumentController extends GenericController<PersonDocument, PersonDocumentService, Long> {

    public PersonDocumentController(PersonDocumentService service) {
        super(service);
    }

}
