package br.com.matheuscastiglioni.semivebackend.domain.person.address;

import br.com.matheuscastiglioni.semivebackend.domain.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonAddressRepository extends JpaRepository<PersonAddress, Long> {

    List<PersonAddress> findByIdPerson(Person person);

}
