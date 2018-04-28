package br.com.matheuscastiglioni.semivebackend.domain.city;

import br.com.matheuscastiglioni.semivebackend.domain.state.State;
import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService extends GenericService<City, CityRepository, Integer> {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository repository) {
        super(repository);
        this.cityRepository = repository;
    }

    public List<City> findByState(State state) {
        return this.cityRepository.findByIdState(state);
    }

}
