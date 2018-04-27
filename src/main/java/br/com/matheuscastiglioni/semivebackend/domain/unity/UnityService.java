package br.com.matheuscastiglioni.semivebackend.domain.unity;

import br.com.matheuscastiglioni.semivebackend.generic.GenericService;
import org.springframework.stereotype.Service;

@Service
public class UnityService extends GenericService<Unity, UnityRepository, Integer> {

    public UnityService(UnityRepository repository) {
        super(repository);
    }

}
