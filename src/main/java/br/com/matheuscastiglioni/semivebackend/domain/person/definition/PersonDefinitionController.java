package br.com.matheuscastiglioni.semivebackend.domain.person.definition;

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
@RequestMapping("person/definition")
public class PersonDefinitionController extends GenericController<PersonDefinition, PersonDefinitionService, Long> {

    private final PersonDefinitionService personDefinitionService;
    private final Logger logger = LoggerFactory.getLogger(PersonDefinition.class);

    @Autowired
    public PersonDefinitionController(PersonDefinitionService service) {
        super(service);
        this.personDefinitionService = service;
    }

    @GetMapping("person/{idPerson}")
    public ResponseEntity<List<PersonDefinition>> listByIdPerson(@PathVariable Long idPerson) {
        this.logger.info("[PersonDefinitionController] => Listing by idPerson: " + idPerson);
        List<PersonDefinition> personDefinitions = this.personDefinitionService.listByIdPerson(idPerson);
        if (personDefinitions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personDefinitions);
    }

}
