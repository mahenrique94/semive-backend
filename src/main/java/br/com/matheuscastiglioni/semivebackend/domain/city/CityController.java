package br.com.matheuscastiglioni.semivebackend.domain.city;

import br.com.matheuscastiglioni.semivebackend.domain.state.State;
import br.com.matheuscastiglioni.semivebackend.generic.GenericController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("city")
public class CityController extends GenericController<City, CityService, Integer> {

    private final CityService cityService;
    private final Logger logger = LoggerFactory.getLogger(City.class);

    @Autowired
    public CityController(CityService service) {
        super(service);
        this.cityService = service;
    }

    @GetMapping("state/{idState}")
    public ResponseEntity<List<City>> findByState(@PathVariable Integer idState) {
        this.logger.info("[CityController] => findByState: " + idState);
        return ResponseEntity.ok(this.cityService.findByState(new State(idState)));
    }

}
