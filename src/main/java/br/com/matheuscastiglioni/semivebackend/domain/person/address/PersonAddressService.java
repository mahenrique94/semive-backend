package br.com.matheuscastiglioni.semivebackend.domain.person.address;

import br.com.matheuscastiglioni.semivebackend.domain.person.Person;
import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonAddressService extends GenericService<PersonAddress, PersonAddressRepository, Long> {

    private final PersonAddressRepository personAddressRepository;

    @Autowired
    public PersonAddressService(PersonAddressRepository repository) {
        super(repository);
        this.personAddressRepository = repository;
    }

    public List<PersonAddress> listByIdPerson(Long idPerson) {
        return this.personAddressRepository.findByIdPerson(new Person(idPerson));
    }

}
