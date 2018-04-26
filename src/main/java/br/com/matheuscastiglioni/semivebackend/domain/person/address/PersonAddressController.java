package br.com.matheuscastiglioni.semivebackend.domain.person.address;

import br.com.matheuscastiglioni.semivebackend.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person/address")
public class PersonAddressController extends GenericController<PersonAddress, PersonAddressService, Long> {

    public PersonAddressController(PersonAddressService service) {
        super(service);
    }

}
