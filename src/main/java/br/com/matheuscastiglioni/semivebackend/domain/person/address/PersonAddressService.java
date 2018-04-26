package br.com.matheuscastiglioni.semivebackend.domain.person.address;

import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.stereotype.Service;

@Service
public class PersonAddressService extends GenericService<PersonAddress, PersonAddressRepository, Long> {

    public PersonAddressService(PersonAddressRepository repository) {
        super(repository);
    }

}
