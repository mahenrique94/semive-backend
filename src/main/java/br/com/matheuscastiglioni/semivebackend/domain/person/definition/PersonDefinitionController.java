package br.com.matheuscastiglioni.semivebackend.domain.person.definition;

import br.com.matheuscastiglioni.semivebackend.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person/definition")
public class PersonDefinitionController extends GenericController<PersonDefinition, PersonDefinitionService, Long> {

    public PersonDefinitionController(PersonDefinitionService service) {
        super(service);
    }

}
