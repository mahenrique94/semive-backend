package br.com.matheuscastiglioni.semivebackend.domain.person.group;

import br.com.matheuscastiglioni.semivebackend.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person/group")
public class PersonGroupController extends GenericController<PersonGroup, PersonGroupService, Integer> {

    public PersonGroupController(PersonGroupService service) {
        super(service);
    }

}
