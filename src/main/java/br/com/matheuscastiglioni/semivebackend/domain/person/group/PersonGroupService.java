package br.com.matheuscastiglioni.semivebackend.domain.person.group;

import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.stereotype.Service;

@Service
public class PersonGroupService extends GenericService<PersonGroup, PersonGroupRepository, Integer> {

    public PersonGroupService(PersonGroupRepository repository) {
        super(repository);
    }

}
