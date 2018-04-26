package br.com.matheuscastiglioni.semivebackend.domain.person.contact;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonContactRepository extends JpaRepository<PersonContact, Long> {
}
