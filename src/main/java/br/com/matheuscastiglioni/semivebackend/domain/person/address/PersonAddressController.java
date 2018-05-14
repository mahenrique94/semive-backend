package br.com.matheuscastiglioni.semivebackend.domain.person.address;

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
@RequestMapping("person/address")
public class PersonAddressController extends GenericController<PersonAddress, PersonAddressService, Long> {

    private final PersonAddressService personAddressService;
    private final Logger logger = LoggerFactory.getLogger(PersonAddress.class);

    @Autowired
    public PersonAddressController(PersonAddressService service) {
        super(service);
        this.personAddressService = service;
    }

    @GetMapping("person/{idPerson}")
    public ResponseEntity<List<PersonAddress>> listByIdPerson(@PathVariable Long idPerson) {
        this.logger.info("[PersonAddressController] => Listing by idPerson: " + idPerson);
        List<PersonAddress> personAddresses = this.personAddressService.listByIdPerson(idPerson);
        if (personAddresses.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personAddresses);
    }

}
