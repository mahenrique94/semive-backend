package br.com.matheuscastiglioni.semivebackend.domain.city;

import br.com.matheuscastiglioni.semivebackend.domain.state.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    List<City> findByIdState(State state);

}
