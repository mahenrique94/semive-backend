package br.com.matheuscastiglioni.semivebackend.domain.person.contact;

import br.com.matheuscastiglioni.semivebackend.domain.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonContactRepository extends JpaRepository<PersonContact, Long> {

    List<PersonContact> findByIdPerson(Person person);

}
