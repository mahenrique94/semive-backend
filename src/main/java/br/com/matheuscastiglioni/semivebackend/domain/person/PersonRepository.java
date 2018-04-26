package br.com.matheuscastiglioni.semivebackend.domain.person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
