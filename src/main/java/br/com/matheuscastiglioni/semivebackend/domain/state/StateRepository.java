package br.com.matheuscastiglioni.semivebackend.domain.state;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Integer> {
}
