package br.com.matheuscastiglioni.semivebackend.domain.person.address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonAddressRepository extends JpaRepository<PersonAddress, Long> {
}
