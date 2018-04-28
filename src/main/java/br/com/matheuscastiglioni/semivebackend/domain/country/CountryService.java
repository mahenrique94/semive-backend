package br.com.matheuscastiglioni.semivebackend.domain.country;

import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends GenericService<Country, CountryRepository, Integer> {

    public CountryService(CountryRepository repository) {
        super(repository);
    }

}
