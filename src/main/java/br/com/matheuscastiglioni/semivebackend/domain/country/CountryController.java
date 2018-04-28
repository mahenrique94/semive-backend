package br.com.matheuscastiglioni.semivebackend.domain.country;

import br.com.matheuscastiglioni.semivebackend.generic.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("country")
public class CountryController extends GenericController<Country, CountryService, Integer> {

    public CountryController(CountryService service) {
        super(service);
    }

}
