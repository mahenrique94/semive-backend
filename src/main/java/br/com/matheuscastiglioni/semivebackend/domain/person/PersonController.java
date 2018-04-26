package br.com.matheuscastiglioni.semivebackend.domain.person;

import br.com.matheuscastiglioni.semivebackend.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonController extends GenericController<Person, PersonService, Long> {

    public PersonController(PersonService service) {
        super(service);
    }

}
