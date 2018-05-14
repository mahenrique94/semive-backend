package br.com.matheuscastiglioni.semivebackend.domain.person.document;

import br.com.matheuscastiglioni.semivebackend.generic.GenericController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("person/document")
public class PersonDocumentController extends GenericController<PersonDocument, PersonDocumentService, Long> {

    private final PersonDocumentService personDocumentService;
    private final Logger logger = LoggerFactory.getLogger(PersonDocument.class);

    @Autowired
    public PersonDocumentController(PersonDocumentService service) {
        super(service);
        this.personDocumentService = service;
    }

    @GetMapping("person/{idPerson}")
    public ResponseEntity<List<PersonDocument>> listByIdPerson(@PathVariable Long idPerson) {
        this.logger.info("[PersonDocumentController] => Listing by idPerson: " + idPerson);
        List<PersonDocument> personDocuments = this.personDocumentService.listByIdPerson(idPerson);
        if (personDocuments.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personDocuments);
    }

}
