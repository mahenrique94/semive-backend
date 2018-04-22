package br.com.matheuscastiglioni.semivebackend.domain.person.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "/person/address", path = "/person/address")
public interface PersonAddressRepository extends JpaRepository<PersonAddress, Long> {
}
