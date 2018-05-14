package br.com.matheuscastiglioni.semivebackend.domain.person.contact;

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
@RequestMapping("person/contact")
public class PersonContactController extends GenericController<PersonContact, PersonContactService, Long> {

    private final PersonContactService personContactService;
    private final Logger logger = LoggerFactory.getLogger(PersonContact.class);

    @Autowired
    public PersonContactController(PersonContactService service) {
        super(service);
        this.personContactService = service;
    }

    @GetMapping("person/{idPerson}")
    public ResponseEntity<List<PersonContact>> listByIdPerson(@PathVariable Long idPerson) {
        this.logger.info("[PersonContactController] => Listing by idPerson: " + idPerson);
        List<PersonContact> personContacts = this.personContactService.listByIdPerson(idPerson);
        if (personContacts.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personContacts);
    }

}
