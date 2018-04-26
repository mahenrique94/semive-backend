package br.com.matheuscastiglioni.semivebackend.domain.person.contact;

import br.com.matheuscastiglioni.semivebackend.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person/contact")
public class PersonContactController extends GenericController<PersonContact, PersonContactService, Long> {

    public PersonContactController(PersonContactService service) {
        super(service);
    }

}
