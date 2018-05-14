package br.com.matheuscastiglioni.semivebackend.domain.person.document;

import br.com.matheuscastiglioni.semivebackend.domain.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonDocumentRepository extends JpaRepository<PersonDocument, Long> {

    List<PersonDocument> findByIdPerson(Person person);

}
