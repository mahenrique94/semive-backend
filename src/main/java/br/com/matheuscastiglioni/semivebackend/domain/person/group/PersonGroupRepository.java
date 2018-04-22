package br.com.matheuscastiglioni.semivebackend.domain.person.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "/person/group", path = "/person/group")
public interface PersonGroupRepository extends JpaRepository<PersonGroup, Integer> {
}
