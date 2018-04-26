package br.com.matheuscastiglioni.semivebackend.domain.person.document;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDocumentRepository extends JpaRepository<PersonDocument, Long> {
}
